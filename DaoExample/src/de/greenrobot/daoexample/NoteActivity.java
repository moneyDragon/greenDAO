/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daoexample;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import org.apache.commons.lang3.time.StopWatch;

import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.daoexample.DaoMaster.DevOpenHelper;
import de.greenrobot.daoexample.PlayHistoryDao.Properties;

public class NoteActivity extends ListActivity implements OnClickListener {

    private SQLiteDatabase db;

    private EditText editText;
    private Button mBtnAddAll;
    private Button mBtnDeleteAll;
    private Button mBtnQueryCount;
    private Button mBtnQueryAll;
    private Button mBtnQueryWithParam;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private NoteDao noteDao;
    private PlayHistoryDao playHistoryDao;

    private Cursor cursor;
    private StopWatch sw;

    private static final int DATA_COUNT = 550000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        noteDao = daoSession.getNoteDao();

        playHistoryDao = daoSession.getPlayHistoryDao();
        sw = new StopWatch();

        String textColumn = NoteDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = db.query(noteDao.getTablename(), noteDao.getAllColumns(), null, null, null, null, orderBy);
        String[] from = { textColumn, NoteDao.Properties.Comment.columnName };
        int[] to = { android.R.id.text1, android.R.id.text2 };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
                to);
        setListAdapter(adapter);

        editText = (EditText) findViewById(R.id.editTextNote);

        initView();

        addUiListeners();
    }

    private void initView() {
        mBtnAddAll = (Button) findViewById(R.id.btn_add);
        mBtnDeleteAll = (Button) findViewById(R.id.btn_delete);
        mBtnQueryCount = (Button) findViewById(R.id.btn_query_count);
        mBtnQueryAll = (Button) findViewById(R.id.btn_query_all);
        mBtnQueryWithParam = (Button) findViewById(R.id.btn_query_with_param);
    }

    protected void addUiListeners() {
        editText.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addNote();
                    return true;
                }
                return false;
            }
        });

        final View button = findViewById(R.id.buttonAdd);
        button.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean enable = s.length() != 0;
                button.setEnabled(enable);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mBtnAddAll.setOnClickListener(this);
        mBtnDeleteAll.setOnClickListener(this);
        mBtnQueryCount.setOnClickListener(this);
        mBtnQueryAll.setOnClickListener(this);
        mBtnQueryWithParam.setOnClickListener(this);
    }

    public void onMyButtonClick(View view) {
        addNote();
    }

    private void addNote() {
        String noteText = editText.getText().toString();
        editText.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());
        Note note = new Note(null, noteText, comment, new Date());
        noteDao.insert(note);
        Log.d("DaoExample", "Inserted new note, ID: " + note.getId());

        cursor.requery();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        noteDao.deleteByKey(id);
        Log.d("DaoExample", "Deleted note, ID: " + id);
        cursor.requery();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                batchInsert();
                break;
            case R.id.btn_delete:
                batchDelete();
                break;
            case R.id.btn_query_count:
                long count = queryCount();
                editText.setText(count + "");
                break;
            case R.id.btn_query_all:
                queryAll();
                break;
            case R.id.btn_query_with_param:
                List<PlayHistory> l = queryWithParam();
                if (l != null && l.size() > 0) {
                    editText.setText(l.size() + "  " + l.get(0).getId() + "  " + l.get(0).getPlayId());
                } else {
                    editText.setText("not found");
                }
                break;
            default:
                break;
        }
    }

    private void batchInsert() {
        // PlayHistory h = new PlayHistory();
        // sw.start();
        //
        // db.beginTransaction();
        // for (int i = 0; i < DATA_COUNT; i++) {
        //
        // h.setId(null);
        // h.setPlayId(i + "");
        // playHistoryDao.insert(h);
        // if ((i + 1) % 50000 == 0) {
        // db.setTransactionSuccessful();
        // db.endTransaction();
        // sw.split();
        // System.out.println("inserted " + (i + 1) + "  " + sw.toSplitString()
        // + "  " + sw.toString());
        // db.beginTransaction();
        // }
        // }
        // db.setTransactionSuccessful();
        // db.endTransaction();
        // sw.split();
        // System.out.println("total time " + sw.toSplitString() + "  " +
        // sw.toString());
        // sw.stop();
        // sw.reset();

        sw.start();
        List<PlayHistory> entities = new ArrayList<PlayHistory>();

        for (int i = 0; i < DATA_COUNT; i++) {
            
            PlayHistory h = new PlayHistory();
            h.setId(null);
            h.setPlayId(i + "");
            entities.add(h);
            if ((i + 1) % 50000 == 0 || i == DATA_COUNT-1) {
                playHistoryDao.insertInTx(entities);
                sw.split();
                System.out.println("inserted " + (i + 1) + "  " + sw.toSplitString() + "  " + sw.toString());
                entities.clear();
            }
        }

        sw.split();
        System.out.println("total time " + sw.toSplitString() + "  " + sw.toString());
        sw.stop();
        sw.reset();
    }

    private void batchDelete() {
        sw.start();
        playHistoryDao.deleteAll();
        sw.split();
        System.out.println("total time " + sw.toSplitString() + "  " + sw.toString());
        sw.stop();
        sw.reset();
    }

    private long queryCount() {
        return playHistoryDao.count();
    }

    private List<PlayHistory> queryAll() {
        sw.start();

        List<PlayHistory> l = playHistoryDao.loadAll();

        sw.split();
        System.out.println("total time " + sw.toSplitString() + "  " + sw.toString());
        sw.stop();
        sw.reset();

        return l;
    }

    private List<PlayHistory> queryWithParam() {
        sw.start();

        QueryBuilder<PlayHistory> qb = playHistoryDao.queryBuilder();
        qb.where(Properties.PlayId.eq(editText.getText()));

        List<PlayHistory> l = qb.list();

        sw.split();
        System.out.println("total time " + sw.toSplitString() + "  " + sw.toString());
        sw.stop();
        sw.reset();

        return l;
    }
}
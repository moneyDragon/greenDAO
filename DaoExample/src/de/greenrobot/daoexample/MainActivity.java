package de.greenrobot.daoexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button mBtnNote;

    private Button mBtnCustomer;

    private Button mBtnSohu;
    
    private Button mBtnTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {

        mBtnNote = (Button) findViewById(R.id.button1);

        mBtnCustomer = (Button) findViewById(R.id.button2);

        mBtnSohu = (Button) findViewById(R.id.button3);
        
        mBtnTool = (Button) findViewById(R.id.button4);
    }

    private void initData() {

    }

    private void initListener() {
        mBtnNote.setOnClickListener(this);
        mBtnCustomer.setOnClickListener(this);
        mBtnSohu.setOnClickListener(this);
        mBtnTool.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(getApplicationContext(), NoteActivity.class));
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                startActivity(new Intent(getApplicationContext(), PlayHistoryActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(getApplicationContext(), ToolActivity.class));
                break;
        }

    }

}

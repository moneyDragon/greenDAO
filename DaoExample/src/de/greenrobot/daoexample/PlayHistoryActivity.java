package de.greenrobot.daoexample;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import de.greenrobot.dao.query.QueryBuilder;

public class PlayHistoryActivity extends Activity {
    
    private PlayHistoryDao mPlayHisDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playhistory);
        initView();
        initData();
        initListener();
        
        testAllMethods();
    }

    private void initView() {

    }

    private void initData() {
        mPlayHisDao = MyApplication.getInstance().getDaoSession().getPlayHistoryDao();
    }

    private void initListener() {

    }
    
    private void testAllMethods(){
        String tag = "testAllMethods";
        
        PlayHistory entity = new PlayHistory();
        entity.setPlayId("entity1");
        
        long key = mPlayHisDao.insert(entity);
        Log.d(tag, "insert(PlayHistory entity), key is "+key);
        
        long num = mPlayHisDao.count();
        Log.d(tag, "count(), num is "+num);
        
        entity = mPlayHisDao.load(key);
        Log.d(tag, "load(Long arg0), playId is "+entity.getPlayId());
        
        entity.setPlayId("playId2");
        mPlayHisDao.update(entity);
        Log.d(tag, "update(PlayHistory entity), playId is "+entity.getPlayId());
        
        entity = mPlayHisDao.load(key);
        Log.d(tag, "load(Long arg0), playId is "+entity.getPlayId());
        
        List<PlayHistory> allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());
        
        mPlayHisDao.delete(entity);
        Log.d(tag, "delete(PlayHistory entity)");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());
        
        entity = new PlayHistory();
        entity.setPlayId("entity1");
        
        key = mPlayHisDao.insert(entity);
        Log.d(tag, "insert(PlayHistory entity), key is "+key);
        
        mPlayHisDao.deleteAll();
        Log.d(tag, "deleteAll() ");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());
        
        entity = new PlayHistory();
        entity.setPlayId("entity1");
        
        key = mPlayHisDao.insert(entity);
        Log.d(tag, "insert(PlayHistory entity), key is "+key);
        
        mPlayHisDao.deleteByKey(key);
        Log.d(tag, "deleteByKey(Long key)");
       
        QueryBuilder<PlayHistory> queryBuilder = mPlayHisDao.queryBuilder();
        queryBuilder.where(de.greenrobot.daoexample.PlayHistoryDao.Properties.PlayId.eq("playId1"));
        List qbList = queryBuilder.list();
        Log.d(tag, "QueryBuilder.list(), result size is "+qbList.size());
        
        List<PlayHistory> lt = new LinkedList<PlayHistory>();
        for(int i=0;i<1000;i++){
            PlayHistory temp = new PlayHistory();
            temp.setPlayId("entity"+i);
            lt.add(temp);
        }
        mPlayHisDao.insertInTx(lt);
        Log.d(tag, "insertInTx(java.lang.Iterable<T> entities)");
        
        PlayHistory[] array = new PlayHistory[1000];
        for(int i=0;i<1000;i++){
            PlayHistory temp = new PlayHistory();
            temp.setPlayId("entity"+i);
            array[i] = temp;
        }
        mPlayHisDao.insertInTx(array);
        Log.d(tag, "insertInTx(T... entities)");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());

        entity = allList.get(0);
        entity.setAlbumName("albumName");
        mPlayHisDao.insertOrReplace(entity);
        Log.d(tag, "insertOrReplace(T... entities), exist");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());
        
        entity = new PlayHistory();
        entity.setAlbumName("albumName");
        mPlayHisDao.insertOrReplace(entity);
        Log.d(tag, "insertOrReplace(T... entities), new");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size());
        
        entity = mPlayHisDao.loadByRowId(allList.get(0).getId());
        Log.d(tag, "loadByRowId(long rowId) , id is "+entity.getId());
        
        List<PlayHistory> updateList = new LinkedList<PlayHistory>();
        for(int i=0;i<1000;i++){
            entity = allList.get(i);
            entity.setPassport("passport"+i);
            updateList.add(entity);
        }
        mPlayHisDao.updateInTx(updateList);
        Log.d(tag, "updateInTx(T... entities)");
        
        allList = mPlayHisDao.loadAll();
        Log.d(tag, "loadAll(), result size is "+allList.size()+" and the 500th entity's passport is "+allList.get(499).getPassport());
        
        entity = mPlayHisDao.load(allList.get(499).getId());
        entity.setAlbumName("albumName499");
        System.out.println(entity);
        entity = mPlayHisDao.load(allList.get(499).getId());
        Log.d(tag, "AlbumName is "+entity.getAlbumName());
        System.out.println(entity);
        PlayHistory entity2 = mPlayHisDao.load(allList.get(499).getId());
        System.out.println(entity2);
        
        mPlayHisDao.refresh(entity);
        entity = mPlayHisDao.load(allList.get(499).getId());
        Log.d(tag, "AlbumName is "+entity.getAlbumName());
        PlayHistory entity3 = mPlayHisDao.load(allList.get(499).getId());
        System.out.println(entity3);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

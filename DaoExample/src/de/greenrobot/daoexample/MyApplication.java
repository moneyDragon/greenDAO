package de.greenrobot.daoexample;

import android.app.Application;

import de.greenrobot.daoexample.DaoMaster.CustomOpenHelper;



public class MyApplication extends Application{
    
    private static MyApplication instance = null;
    
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public MyApplication() {
        super();
        instance = this;
    }

    public static MyApplication getInstance() {
        if(instance == null){
            instance = new MyApplication();
        }
        return instance;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        CustomOpenHelper helper = new DaoMaster.CustomOpenHelper(this, "notes-db", null);
        daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
    
}

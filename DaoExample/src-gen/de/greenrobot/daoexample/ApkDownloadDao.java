package de.greenrobot.daoexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daoexample.ApkDownload;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table APK_DOWNLOAD.
*/
public class ApkDownloadDao extends AbstractDao<ApkDownload, Void> {

    public static final String TABLENAME = "APK_DOWNLOAD";

    /**
     * Properties of entity ApkDownload.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Package_name = new Property(0, String.class, "package_name", false, "PACKAGE_NAME");
        public final static Property Version = new Property(1, Integer.class, "version", false, "VERSION");
        public final static Property Tip = new Property(2, String.class, "tip", false, "TIP");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property Downing_state = new Property(4, Integer.class, "downing_state", false, "DOWNING_STATE");
        public final static Property Total_filesize = new Property(5, Integer.class, "total_filesize", false, "TOTAL_FILESIZE");
        public final static Property Download_beginning = new Property(6, Integer.class, "download_beginning", false, "DOWNLOAD_BEGINNING");
        public final static Property Downloaded_size = new Property(7, Integer.class, "downloaded_size", false, "DOWNLOADED_SIZE");
        public final static Property Download_percent = new Property(8, Integer.class, "download_percent", false, "DOWNLOAD_PERCENT");
        public final static Property Create_time = new Property(9, Integer.class, "create_time", false, "CREATE_TIME");
        public final static Property Download_url = new Property(10, String.class, "download_url", false, "DOWNLOAD_URL");
        public final static Property Save_dir = new Property(11, String.class, "save_dir", false, "SAVE_DIR");
        public final static Property Save_name = new Property(12, String.class, "save_name", false, "SAVE_NAME");
    };


    public ApkDownloadDao(DaoConfig config) {
        super(config);
    }
    
    public ApkDownloadDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'APK_DOWNLOAD' (" + //
                "'PACKAGE_NAME' TEXT," + // 0: package_name
                "'VERSION' INTEGER," + // 1: version
                "'TIP' TEXT," + // 2: tip
                "'NAME' TEXT," + // 3: name
                "'DOWNING_STATE' INTEGER," + // 4: downing_state
                "'TOTAL_FILESIZE' INTEGER," + // 5: total_filesize
                "'DOWNLOAD_BEGINNING' INTEGER," + // 6: download_beginning
                "'DOWNLOADED_SIZE' INTEGER," + // 7: downloaded_size
                "'DOWNLOAD_PERCENT' INTEGER," + // 8: download_percent
                "'CREATE_TIME' INTEGER," + // 9: create_time
                "'DOWNLOAD_URL' TEXT," + // 10: download_url
                "'SAVE_DIR' TEXT," + // 11: save_dir
                "'SAVE_NAME' TEXT);"); // 12: save_name
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'APK_DOWNLOAD'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ApkDownload entity) {
        stmt.clearBindings();
 
        String package_name = entity.getPackage_name();
        if (package_name != null) {
            stmt.bindString(1, package_name);
        }
 
        Integer version = entity.getVersion();
        if (version != null) {
            stmt.bindLong(2, version);
        }
 
        String tip = entity.getTip();
        if (tip != null) {
            stmt.bindString(3, tip);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        Integer downing_state = entity.getDowning_state();
        if (downing_state != null) {
            stmt.bindLong(5, downing_state);
        }
 
        Integer total_filesize = entity.getTotal_filesize();
        if (total_filesize != null) {
            stmt.bindLong(6, total_filesize);
        }
 
        Integer download_beginning = entity.getDownload_beginning();
        if (download_beginning != null) {
            stmt.bindLong(7, download_beginning);
        }
 
        Integer downloaded_size = entity.getDownloaded_size();
        if (downloaded_size != null) {
            stmt.bindLong(8, downloaded_size);
        }
 
        Integer download_percent = entity.getDownload_percent();
        if (download_percent != null) {
            stmt.bindLong(9, download_percent);
        }
 
        Integer create_time = entity.getCreate_time();
        if (create_time != null) {
            stmt.bindLong(10, create_time);
        }
 
        String download_url = entity.getDownload_url();
        if (download_url != null) {
            stmt.bindString(11, download_url);
        }
 
        String save_dir = entity.getSave_dir();
        if (save_dir != null) {
            stmt.bindString(12, save_dir);
        }
 
        String save_name = entity.getSave_name();
        if (save_name != null) {
            stmt.bindString(13, save_name);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public ApkDownload readEntity(Cursor cursor, int offset) {
        ApkDownload entity = new ApkDownload( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // package_name
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // version
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // tip
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // downing_state
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // total_filesize
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // download_beginning
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // downloaded_size
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // download_percent
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // create_time
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // download_url
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // save_dir
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12) // save_name
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ApkDownload entity, int offset) {
        entity.setPackage_name(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setVersion(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setTip(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDowning_state(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setTotal_filesize(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setDownload_beginning(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setDownloaded_size(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setDownload_percent(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setCreate_time(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setDownload_url(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSave_dir(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setSave_name(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(ApkDownload entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(ApkDownload entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

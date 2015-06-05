package de.greenrobot.daoexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daoexample.LocalPlayHistory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LOCAL_PLAY_HISTORY.
*/
public class LocalPlayHistoryDao extends AbstractDao<LocalPlayHistory, Long> {

    public static final String TABLENAME = "LOCAL_PLAY_HISTORY";

    /**
     * Properties of entity LocalPlayHistory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property VideoTitle = new Property(1, String.class, "videoTitle", false, "VIDEO_TITLE");
        public final static Property PlayedTime = new Property(2, String.class, "playedTime", false, "PLAYED_TIME");
        public final static Property TvLength = new Property(3, Integer.class, "tvLength", false, "TV_LENGTH");
        public final static Property LastWatchTime = new Property(4, String.class, "lastWatchTime", false, "LAST_WATCH_TIME");
        public final static Property LocalUrl = new Property(5, String.class, "localUrl", false, "LOCAL_URL");
    };


    public LocalPlayHistoryDao(DaoConfig config) {
        super(config);
    }
    
    public LocalPlayHistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LOCAL_PLAY_HISTORY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'VIDEO_TITLE' TEXT," + // 1: videoTitle
                "'PLAYED_TIME' TEXT," + // 2: playedTime
                "'TV_LENGTH' INTEGER," + // 3: tvLength
                "'LAST_WATCH_TIME' TEXT," + // 4: lastWatchTime
                "'LOCAL_URL' TEXT);"); // 5: localUrl
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LOCAL_PLAY_HISTORY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, LocalPlayHistory entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String videoTitle = entity.getVideoTitle();
        if (videoTitle != null) {
            stmt.bindString(2, videoTitle);
        }
 
        String playedTime = entity.getPlayedTime();
        if (playedTime != null) {
            stmt.bindString(3, playedTime);
        }
 
        Integer tvLength = entity.getTvLength();
        if (tvLength != null) {
            stmt.bindLong(4, tvLength);
        }
 
        String lastWatchTime = entity.getLastWatchTime();
        if (lastWatchTime != null) {
            stmt.bindString(5, lastWatchTime);
        }
 
        String localUrl = entity.getLocalUrl();
        if (localUrl != null) {
            stmt.bindString(6, localUrl);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public LocalPlayHistory readEntity(Cursor cursor, int offset) {
        LocalPlayHistory entity = new LocalPlayHistory( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // videoTitle
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // playedTime
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // tvLength
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // lastWatchTime
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // localUrl
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, LocalPlayHistory entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setVideoTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPlayedTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTvLength(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setLastWatchTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLocalUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(LocalPlayHistory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(LocalPlayHistory entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
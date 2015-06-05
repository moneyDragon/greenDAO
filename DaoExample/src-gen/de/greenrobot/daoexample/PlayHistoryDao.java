package de.greenrobot.daoexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daoexample.PlayHistory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PLAY_HISTORY.
*/
public class PlayHistoryDao extends AbstractDao<PlayHistory, Long> {

    public static final String TABLENAME = "PLAY_HISTORY";

    /**
     * Properties of entity PlayHistory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PlayId = new Property(1, String.class, "playId", false, "PLAY_ID");
        public final static Property SubjectId = new Property(2, String.class, "subjectId", false, "SUBJECT_ID");
        public final static Property VideoTitle = new Property(3, String.class, "videoTitle", false, "VIDEO_TITLE");
        public final static Property PlayedTime = new Property(4, String.class, "playedTime", false, "PLAYED_TIME");
        public final static Property ClientType = new Property(5, String.class, "clientType", false, "CLIENT_TYPE");
        public final static Property Definition = new Property(6, String.class, "definition", false, "DEFINITION");
        public final static Property Episode = new Property(7, String.class, "episode", false, "EPISODE");
        public final static Property PicPath = new Property(8, String.class, "picPath", false, "PIC_PATH");
        public final static Property CategoryId = new Property(9, String.class, "categoryId", false, "CATEGORY_ID");
        public final static Property TvLength = new Property(10, Integer.class, "tvLength", false, "TV_LENGTH");
        public final static Property IsSynchronized = new Property(11, Integer.class, "isSynchronized", false, "IS_SYNCHRONIZED");
        public final static Property AlbumName = new Property(12, String.class, "albumName", false, "ALBUM_NAME");
        public final static Property NextplayId = new Property(13, Integer.class, "nextplayId", false, "NEXTPLAY_ID");
        public final static Property LastWatchTime = new Property(14, String.class, "lastWatchTime", false, "LAST_WATCH_TIME");
        public final static Property Passport = new Property(15, String.class, "passport", false, "PASSPORT");
        public final static Property LocalUrl = new Property(16, String.class, "localUrl", false, "LOCAL_URL");
        public final static Property Tvisfee = new Property(17, Integer.class, "tvisfee", false, "TVISFEE");
        public final static Property Real_playorder = new Property(18, Integer.class, "real_playorder", false, "REAL_PLAYORDER");
        public final static Property Site = new Property(19, Integer.class, "site", false, "SITE");
    };


    public PlayHistoryDao(DaoConfig config) {
        super(config);
    }
    
    public PlayHistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PLAY_HISTORY' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'PLAY_ID' TEXT," + // 1: playId
                "'SUBJECT_ID' TEXT," + // 2: subjectId
                "'VIDEO_TITLE' TEXT," + // 3: videoTitle
                "'PLAYED_TIME' TEXT," + // 4: playedTime
                "'CLIENT_TYPE' TEXT," + // 5: clientType
                "'DEFINITION' TEXT," + // 6: definition
                "'EPISODE' TEXT," + // 7: episode
                "'PIC_PATH' TEXT," + // 8: picPath
                "'CATEGORY_ID' TEXT," + // 9: categoryId
                "'TV_LENGTH' INTEGER," + // 10: tvLength
                "'IS_SYNCHRONIZED' INTEGER," + // 11: isSynchronized
                "'ALBUM_NAME' TEXT," + // 12: albumName
                "'NEXTPLAY_ID' INTEGER," + // 13: nextplayId
                "'LAST_WATCH_TIME' TEXT," + // 14: lastWatchTime
                "'PASSPORT' TEXT," + // 15: passport
                "'LOCAL_URL' TEXT," + // 16: localUrl
                "'TVISFEE' INTEGER," + // 17: tvisfee
                "'REAL_PLAYORDER' INTEGER," + // 18: real_playorder
                "'SITE' INTEGER);"); // 19: site
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_PLAY_HISTORY_PLAY_ID ON PLAY_HISTORY" +
                " (PLAY_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PLAY_HISTORY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PlayHistory entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String playId = entity.getPlayId();
        if (playId != null) {
            stmt.bindString(2, playId);
        }
 
        String subjectId = entity.getSubjectId();
        if (subjectId != null) {
            stmt.bindString(3, subjectId);
        }
 
        String videoTitle = entity.getVideoTitle();
        if (videoTitle != null) {
            stmt.bindString(4, videoTitle);
        }
 
        String playedTime = entity.getPlayedTime();
        if (playedTime != null) {
            stmt.bindString(5, playedTime);
        }
 
        String clientType = entity.getClientType();
        if (clientType != null) {
            stmt.bindString(6, clientType);
        }
 
        String definition = entity.getDefinition();
        if (definition != null) {
            stmt.bindString(7, definition);
        }
 
        String episode = entity.getEpisode();
        if (episode != null) {
            stmt.bindString(8, episode);
        }
 
        String picPath = entity.getPicPath();
        if (picPath != null) {
            stmt.bindString(9, picPath);
        }
 
        String categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindString(10, categoryId);
        }
 
        Integer tvLength = entity.getTvLength();
        if (tvLength != null) {
            stmt.bindLong(11, tvLength);
        }
 
        Integer isSynchronized = entity.getIsSynchronized();
        if (isSynchronized != null) {
            stmt.bindLong(12, isSynchronized);
        }
 
        String albumName = entity.getAlbumName();
        if (albumName != null) {
            stmt.bindString(13, albumName);
        }
 
        Integer nextplayId = entity.getNextplayId();
        if (nextplayId != null) {
            stmt.bindLong(14, nextplayId);
        }
 
        String lastWatchTime = entity.getLastWatchTime();
        if (lastWatchTime != null) {
            stmt.bindString(15, lastWatchTime);
        }
 
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(16, passport);
        }
 
        String localUrl = entity.getLocalUrl();
        if (localUrl != null) {
            stmt.bindString(17, localUrl);
        }
 
        Integer tvisfee = entity.getTvisfee();
        if (tvisfee != null) {
            stmt.bindLong(18, tvisfee);
        }
 
        Integer real_playorder = entity.getReal_playorder();
        if (real_playorder != null) {
            stmt.bindLong(19, real_playorder);
        }
 
        Integer site = entity.getSite();
        if (site != null) {
            stmt.bindLong(20, site);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PlayHistory readEntity(Cursor cursor, int offset) {
        PlayHistory entity = new PlayHistory( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // playId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // subjectId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // videoTitle
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // playedTime
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // clientType
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // definition
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // episode
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // picPath
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // categoryId
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // tvLength
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // isSynchronized
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // albumName
            cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13), // nextplayId
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // lastWatchTime
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // passport
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // localUrl
            cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17), // tvisfee
            cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18), // real_playorder
            cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19) // site
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PlayHistory entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPlayId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSubjectId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setVideoTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPlayedTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setClientType(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDefinition(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEpisode(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPicPath(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setCategoryId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTvLength(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setIsSynchronized(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setAlbumName(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setNextplayId(cursor.isNull(offset + 13) ? null : cursor.getInt(offset + 13));
        entity.setLastWatchTime(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setPassport(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setLocalUrl(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTvisfee(cursor.isNull(offset + 17) ? null : cursor.getInt(offset + 17));
        entity.setReal_playorder(cursor.isNull(offset + 18) ? null : cursor.getInt(offset + 18));
        entity.setSite(cursor.isNull(offset + 19) ? null : cursor.getInt(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(PlayHistory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(PlayHistory entity) {
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
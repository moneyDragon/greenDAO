package de.greenrobot.daoexample;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daoexample.Note;
import de.greenrobot.daoexample.Customer;
import de.greenrobot.daoexample.Order;
import de.greenrobot.daoexample.LocalMedia;
import de.greenrobot.daoexample.LocalPlayHistory;
import de.greenrobot.daoexample.AmericanNeighbour;
import de.greenrobot.daoexample.ApkDownload;
import de.greenrobot.daoexample.PlayHistory;

import de.greenrobot.daoexample.NoteDao;
import de.greenrobot.daoexample.CustomerDao;
import de.greenrobot.daoexample.OrderDao;
import de.greenrobot.daoexample.LocalMediaDao;
import de.greenrobot.daoexample.LocalPlayHistoryDao;
import de.greenrobot.daoexample.AmericanNeighbourDao;
import de.greenrobot.daoexample.ApkDownloadDao;
import de.greenrobot.daoexample.PlayHistoryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig noteDaoConfig;
    private final DaoConfig customerDaoConfig;
    private final DaoConfig orderDaoConfig;
    private final DaoConfig localMediaDaoConfig;
    private final DaoConfig localPlayHistoryDaoConfig;
    private final DaoConfig americanNeighbourDaoConfig;
    private final DaoConfig apkDownloadDaoConfig;
    private final DaoConfig playHistoryDaoConfig;

    private final NoteDao noteDao;
    private final CustomerDao customerDao;
    private final OrderDao orderDao;
    private final LocalMediaDao localMediaDao;
    private final LocalPlayHistoryDao localPlayHistoryDao;
    private final AmericanNeighbourDao americanNeighbourDao;
    private final ApkDownloadDao apkDownloadDao;
    private final PlayHistoryDao playHistoryDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        noteDaoConfig = daoConfigMap.get(NoteDao.class).clone();
        noteDaoConfig.initIdentityScope(type);

        customerDaoConfig = daoConfigMap.get(CustomerDao.class).clone();
        customerDaoConfig.initIdentityScope(type);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        localMediaDaoConfig = daoConfigMap.get(LocalMediaDao.class).clone();
        localMediaDaoConfig.initIdentityScope(type);

        localPlayHistoryDaoConfig = daoConfigMap.get(LocalPlayHistoryDao.class).clone();
        localPlayHistoryDaoConfig.initIdentityScope(type);

        americanNeighbourDaoConfig = daoConfigMap.get(AmericanNeighbourDao.class).clone();
        americanNeighbourDaoConfig.initIdentityScope(type);

        apkDownloadDaoConfig = daoConfigMap.get(ApkDownloadDao.class).clone();
        apkDownloadDaoConfig.initIdentityScope(type);

        playHistoryDaoConfig = daoConfigMap.get(PlayHistoryDao.class).clone();
        playHistoryDaoConfig.initIdentityScope(type);

        noteDao = new NoteDao(noteDaoConfig, this);
        customerDao = new CustomerDao(customerDaoConfig, this);
        orderDao = new OrderDao(orderDaoConfig, this);
        localMediaDao = new LocalMediaDao(localMediaDaoConfig, this);
        localPlayHistoryDao = new LocalPlayHistoryDao(localPlayHistoryDaoConfig, this);
        americanNeighbourDao = new AmericanNeighbourDao(americanNeighbourDaoConfig, this);
        apkDownloadDao = new ApkDownloadDao(apkDownloadDaoConfig, this);
        playHistoryDao = new PlayHistoryDao(playHistoryDaoConfig, this);

        registerDao(Note.class, noteDao);
        registerDao(Customer.class, customerDao);
        registerDao(Order.class, orderDao);
        registerDao(LocalMedia.class, localMediaDao);
        registerDao(LocalPlayHistory.class, localPlayHistoryDao);
        registerDao(AmericanNeighbour.class, americanNeighbourDao);
        registerDao(ApkDownload.class, apkDownloadDao);
        registerDao(PlayHistory.class, playHistoryDao);
    }
    
    public void clear() {
        noteDaoConfig.getIdentityScope().clear();
        customerDaoConfig.getIdentityScope().clear();
        orderDaoConfig.getIdentityScope().clear();
        localMediaDaoConfig.getIdentityScope().clear();
        localPlayHistoryDaoConfig.getIdentityScope().clear();
        americanNeighbourDaoConfig.getIdentityScope().clear();
        apkDownloadDaoConfig.getIdentityScope().clear();
        playHistoryDaoConfig.getIdentityScope().clear();
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public LocalMediaDao getLocalMediaDao() {
        return localMediaDao;
    }

    public LocalPlayHistoryDao getLocalPlayHistoryDao() {
        return localPlayHistoryDao;
    }

    public AmericanNeighbourDao getAmericanNeighbourDao() {
        return americanNeighbourDao;
    }

    public ApkDownloadDao getApkDownloadDao() {
        return apkDownloadDao;
    }

    public PlayHistoryDao getPlayHistoryDao() {
        return playHistoryDao;
    }

}

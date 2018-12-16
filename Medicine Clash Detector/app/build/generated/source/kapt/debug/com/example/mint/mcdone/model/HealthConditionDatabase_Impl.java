package com.example.mint.mcdone.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class HealthConditionDatabase_Impl extends HealthConditionDatabase {
  private volatile HealthConditionDao _healthConditionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `addHConditionTbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `condition` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"e4db82e5462dd0f58f5b4ca3f1ba366d\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `addHConditionTbl`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddHConditionTbl = new HashMap<String, TableInfo.Column>(2);
        _columnsAddHConditionTbl.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsAddHConditionTbl.put("condition", new TableInfo.Column("condition", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddHConditionTbl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddHConditionTbl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddHConditionTbl = new TableInfo("addHConditionTbl", _columnsAddHConditionTbl, _foreignKeysAddHConditionTbl, _indicesAddHConditionTbl);
        final TableInfo _existingAddHConditionTbl = TableInfo.read(_db, "addHConditionTbl");
        if (! _infoAddHConditionTbl.equals(_existingAddHConditionTbl)) {
          throw new IllegalStateException("Migration didn't properly handle addHConditionTbl(com.example.mint.mcdone.model.HealthCondition).\n"
                  + " Expected:\n" + _infoAddHConditionTbl + "\n"
                  + " Found:\n" + _existingAddHConditionTbl);
        }
      }
    }, "e4db82e5462dd0f58f5b4ca3f1ba366d", "7073d1555031a4f5f8c2286a11c48aa7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "addHConditionTbl");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `addHConditionTbl`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public HealthConditionDao healthConditionDao() {
    if (_healthConditionDao != null) {
      return _healthConditionDao;
    } else {
      synchronized(this) {
        if(_healthConditionDao == null) {
          _healthConditionDao = new HealthConditionDao_Impl(this);
        }
        return _healthConditionDao;
      }
    }
  }
}

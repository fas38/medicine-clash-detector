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
public class AddMedicineSingleton_Impl extends AddMedicineSingleton {
  private volatile addMedicineDao _addMedicineDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `addMedicineTbl` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `bName` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"dccd11c3e876974ca92e3b831a3cc2a8\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `addMedicineTbl`");
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
        final HashMap<String, TableInfo.Column> _columnsAddMedicineTbl = new HashMap<String, TableInfo.Column>(2);
        _columnsAddMedicineTbl.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsAddMedicineTbl.put("bName", new TableInfo.Column("bName", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddMedicineTbl = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddMedicineTbl = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddMedicineTbl = new TableInfo("addMedicineTbl", _columnsAddMedicineTbl, _foreignKeysAddMedicineTbl, _indicesAddMedicineTbl);
        final TableInfo _existingAddMedicineTbl = TableInfo.read(_db, "addMedicineTbl");
        if (! _infoAddMedicineTbl.equals(_existingAddMedicineTbl)) {
          throw new IllegalStateException("Migration didn't properly handle addMedicineTbl(com.example.mint.mcdone.model.AddMedicine).\n"
                  + " Expected:\n" + _infoAddMedicineTbl + "\n"
                  + " Found:\n" + _existingAddMedicineTbl);
        }
      }
    }, "dccd11c3e876974ca92e3b831a3cc2a8", "d8eee91638d94fb52e1af5ce7abc6f9c");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "addMedicineTbl");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `addMedicineTbl`");
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
  public addMedicineDao addMedicineDao() {
    if (_addMedicineDao != null) {
      return _addMedicineDao;
    } else {
      synchronized(this) {
        if(_addMedicineDao == null) {
          _addMedicineDao = new addMedicineDao_Impl(this);
        }
        return _addMedicineDao;
      }
    }
  }
}

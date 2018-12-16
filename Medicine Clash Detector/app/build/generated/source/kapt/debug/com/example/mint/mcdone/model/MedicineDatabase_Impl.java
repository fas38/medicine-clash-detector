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
public class MedicineDatabase_Impl extends MedicineDatabase {
  private volatile MedicineDao _medicineDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Medicine` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `brandName` TEXT NOT NULL, `genericName` TEXT NOT NULL, `clashMed` TEXT NOT NULL, `conditions` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"83cd6883abbdc78065c2918bfdfe0358\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Medicine`");
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
        final HashMap<String, TableInfo.Column> _columnsMedicine = new HashMap<String, TableInfo.Column>(5);
        _columnsMedicine.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsMedicine.put("brandName", new TableInfo.Column("brandName", "TEXT", true, 0));
        _columnsMedicine.put("genericName", new TableInfo.Column("genericName", "TEXT", true, 0));
        _columnsMedicine.put("clashMed", new TableInfo.Column("clashMed", "TEXT", true, 0));
        _columnsMedicine.put("conditions", new TableInfo.Column("conditions", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMedicine = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMedicine = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMedicine = new TableInfo("Medicine", _columnsMedicine, _foreignKeysMedicine, _indicesMedicine);
        final TableInfo _existingMedicine = TableInfo.read(_db, "Medicine");
        if (! _infoMedicine.equals(_existingMedicine)) {
          throw new IllegalStateException("Migration didn't properly handle Medicine(com.example.mint.mcdone.model.Medicine).\n"
                  + " Expected:\n" + _infoMedicine + "\n"
                  + " Found:\n" + _existingMedicine);
        }
      }
    }, "83cd6883abbdc78065c2918bfdfe0358", "bc757c7fd2aae2458d173bce696d9aa1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Medicine");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Medicine`");
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
  public MedicineDao medicineDao() {
    if (_medicineDao != null) {
      return _medicineDao;
    } else {
      synchronized(this) {
        if(_medicineDao == null) {
          _medicineDao = new MedicineDao_Impl(this);
        }
        return _medicineDao;
      }
    }
  }
}

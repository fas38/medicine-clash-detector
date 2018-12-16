package com.example.mint.mcdone.model;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MedicineDao_Impl implements MedicineDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMedicine;

  public MedicineDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedicine = new EntityInsertionAdapter<Medicine>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Medicine`(`id`,`brandName`,`genericName`,`clashMed`,`conditions`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Medicine value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getBrandName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrandName());
        }
        if (value.getGenericName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGenericName());
        }
        if (value.getClashMed() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getClashMed());
        }
        if (value.getConditions() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getConditions());
        }
      }
    };
  }

  @Override
  public void insertMedicine(List<Medicine> medicine) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMedicine.insert(medicine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Medicine> getMedicines() {
    final String _sql = "SELECT * FROM Medicine";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfBrandName = _cursor.getColumnIndexOrThrow("brandName");
      final int _cursorIndexOfGenericName = _cursor.getColumnIndexOrThrow("genericName");
      final int _cursorIndexOfClashMed = _cursor.getColumnIndexOrThrow("clashMed");
      final int _cursorIndexOfConditions = _cursor.getColumnIndexOrThrow("conditions");
      final List<Medicine> _result = new ArrayList<Medicine>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Medicine _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpBrandName;
        _tmpBrandName = _cursor.getString(_cursorIndexOfBrandName);
        final String _tmpGenericName;
        _tmpGenericName = _cursor.getString(_cursorIndexOfGenericName);
        final String _tmpClashMed;
        _tmpClashMed = _cursor.getString(_cursorIndexOfClashMed);
        final String _tmpConditions;
        _tmpConditions = _cursor.getString(_cursorIndexOfConditions);
        _item = new Medicine(_tmpId,_tmpBrandName,_tmpGenericName,_tmpClashMed,_tmpConditions);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

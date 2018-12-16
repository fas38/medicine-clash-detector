package com.example.mint.mcdone.model;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class addMedicineDao_Impl implements addMedicineDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAddMedicine;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfAddMedicine;

  private final SharedSQLiteStatement __preparedStmtOfNukeTable;

  public addMedicineDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddMedicine = new EntityInsertionAdapter<AddMedicine>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `addMedicineTbl`(`id`,`bName`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddMedicine value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getBName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBName());
        }
      }
    };
    this.__deletionAdapterOfAddMedicine = new EntityDeletionOrUpdateAdapter<AddMedicine>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `addMedicineTbl` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddMedicine value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfNukeTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM addmedicinetbl";
        return _query;
      }
    };
  }

  @Override
  public void insert(AddMedicine addMedicine) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddMedicine.insert(addMedicine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(AddMedicine addMedicine) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddMedicine.handle(addMedicine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void nukeTable() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeTable.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeTable.release(_stmt);
    }
  }

  @Override
  public List<AddMedicine> allAddMedicine() {
    final String _sql = "SELECT * FROM addmedicinetbl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfBName = _cursor.getColumnIndexOrThrow("bName");
      final List<AddMedicine> _result = new ArrayList<AddMedicine>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddMedicine _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpBName;
        _tmpBName = _cursor.getString(_cursorIndexOfBName);
        _item = new AddMedicine(_tmpId,_tmpBName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

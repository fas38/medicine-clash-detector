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
public class HealthConditionDao_Impl implements HealthConditionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfHealthCondition;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfHealthCondition;

  private final SharedSQLiteStatement __preparedStmtOfNukeTable;

  public HealthConditionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHealthCondition = new EntityInsertionAdapter<HealthCondition>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `addHConditionTbl`(`id`,`condition`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HealthCondition value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getCondition() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCondition());
        }
      }
    };
    this.__deletionAdapterOfHealthCondition = new EntityDeletionOrUpdateAdapter<HealthCondition>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `addHConditionTbl` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HealthCondition value) {
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
        final String _query = "DELETE FROM addHConditionTbl";
        return _query;
      }
    };
  }

  @Override
  public void insert(HealthCondition healthCondition) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfHealthCondition.insert(healthCondition);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(HealthCondition healthCondition) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfHealthCondition.handle(healthCondition);
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
  public List<HealthCondition> allconditions() {
    final String _sql = "SELECT * FROM addHConditionTbl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfCondition = _cursor.getColumnIndexOrThrow("condition");
      final List<HealthCondition> _result = new ArrayList<HealthCondition>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HealthCondition _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final String _tmpCondition;
        _tmpCondition = _cursor.getString(_cursorIndexOfCondition);
        _item = new HealthCondition(_tmpId,_tmpCondition);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}

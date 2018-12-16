package com.example.mint.mcdone.model;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'J\b\u0010\t\u001a\u00020\u0006H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/mint/mcdone/model/HealthConditionDao;", "", "allconditions", "", "Lcom/example/mint/mcdone/model/HealthCondition;", "delete", "", "healthCondition", "insert", "nukeTable", "app_debug"})
public abstract interface HealthConditionDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM addHConditionTbl")
    public abstract java.util.List<com.example.mint.mcdone.model.HealthCondition> allconditions();
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.mint.mcdone.model.HealthCondition healthCondition);
    
    @android.arch.persistence.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.mint.mcdone.model.HealthCondition healthCondition);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM addHConditionTbl")
    public abstract void nukeTable();
}
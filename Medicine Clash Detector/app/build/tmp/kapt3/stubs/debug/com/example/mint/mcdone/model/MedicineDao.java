package com.example.mint.mcdone.model;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/mint/mcdone/model/MedicineDao;", "", "getMedicines", "", "Lcom/example/mint/mcdone/model/Medicine;", "insertMedicine", "", "medicine", "app_debug"})
public abstract interface MedicineDao {
    
    @android.arch.persistence.room.Insert()
    public abstract void insertMedicine(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mint.mcdone.model.Medicine> medicine);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM Medicine")
    public abstract java.util.List<com.example.mint.mcdone.model.Medicine> getMedicines();
}
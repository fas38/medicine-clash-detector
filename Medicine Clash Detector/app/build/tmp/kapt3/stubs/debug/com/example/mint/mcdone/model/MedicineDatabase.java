package com.example.mint.mcdone.model;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {com.example.mint.mcdone.model.Medicine.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/mint/mcdone/model/MedicineDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "medicineDao", "Lcom/example/mint/mcdone/model/MedicineDao;", "Companion", "app_debug"})
public abstract class MedicineDatabase extends android.arch.persistence.room.RoomDatabase {
    private static volatile com.example.mint.mcdone.model.MedicineDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.example.mint.mcdone.model.Medicine> PREPOPULATE_DATA = null;
    public static final com.example.mint.mcdone.model.MedicineDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mint.mcdone.model.MedicineDao medicineDao();
    
    public MedicineDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/example/mint/mcdone/model/MedicineDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/mint/mcdone/model/MedicineDatabase;", "PREPOPULATE_DATA", "", "Lcom/example/mint/mcdone/model/Medicine;", "getPREPOPULATE_DATA", "()Ljava/util/List;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mint.mcdone.model.MedicineDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.example.mint.mcdone.model.MedicineDatabase buildDatabase(android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.example.mint.mcdone.model.Medicine> getPREPOPULATE_DATA() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
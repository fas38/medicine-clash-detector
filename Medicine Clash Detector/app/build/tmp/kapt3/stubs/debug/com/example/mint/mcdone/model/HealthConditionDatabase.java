package com.example.mint.mcdone.model;

import java.lang.System;

@android.arch.persistence.room.Database(entities = {com.example.mint.mcdone.model.HealthCondition.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/mint/mcdone/model/HealthConditionDatabase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "healthConditionDao", "Lcom/example/mint/mcdone/model/HealthConditionDao;", "Companion", "app_debug"})
public abstract class HealthConditionDatabase extends android.arch.persistence.room.RoomDatabase {
    private static com.example.mint.mcdone.model.HealthConditionDatabase INSTANCE;
    public static final com.example.mint.mcdone.model.HealthConditionDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mint.mcdone.model.HealthConditionDao healthConditionDao();
    
    public HealthConditionDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/mint/mcdone/model/HealthConditionDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/mint/mcdone/model/HealthConditionDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mint.mcdone.model.HealthConditionDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
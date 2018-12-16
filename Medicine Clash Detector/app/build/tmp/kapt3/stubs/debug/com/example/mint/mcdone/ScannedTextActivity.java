package com.example.mint.mcdone;

import java.lang.System;

/**
 * This activity process the scanned image to the text for saving
 * it in the database. This class is responsible for converting image
 * to text.
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/example/mint/mcdone/ScannedTextActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "mDb", "Lcom/example/mint/mcdone/model/AddMedicineSingleton;", "prePopulatedDB", "Lcom/example/mint/mcdone/model/MedicineDatabase;", "s", "", "getS", "()Ljava/lang/String;", "setS", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ScannedTextActivity extends android.support.v7.app.AppCompatActivity {
    private com.example.mint.mcdone.model.MedicineDatabase prePopulatedDB;
    private com.example.mint.mcdone.model.AddMedicineSingleton mDb;
    private boolean flag;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String s;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getFlag() {
        return false;
    }
    
    public final void setFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getS() {
        return null;
    }
    
    public final void setS(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public ScannedTextActivity() {
        super();
    }
}
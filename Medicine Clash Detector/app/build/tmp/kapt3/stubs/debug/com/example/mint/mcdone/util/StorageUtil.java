package com.example.mint.mcdone.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ1\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00110\u0015R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/example/mint/mcdone/util/StorageUtil;", "", "()V", "currentUserRef", "Lcom/google/firebase/storage/StorageReference;", "getCurrentUserRef", "()Lcom/google/firebase/storage/StorageReference;", "storageInstance", "Lcom/google/firebase/storage/FirebaseStorage;", "getStorageInstance", "()Lcom/google/firebase/storage/FirebaseStorage;", "storageInstance$delegate", "Lkotlin/Lazy;", "pathToReference", "path", "", "uploadProfilePhoto", "", "imageBytes", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "imagePath", "app_debug"})
public final class StorageUtil {
    private static final kotlin.Lazy storageInstance$delegate = null;
    public static final com.example.mint.mcdone.util.StorageUtil INSTANCE = null;
    
    private final com.google.firebase.storage.FirebaseStorage getStorageInstance() {
        return null;
    }
    
    private final com.google.firebase.storage.StorageReference getCurrentUserRef() {
        return null;
    }
    
    public final void uploadProfilePhoto(@org.jetbrains.annotations.NotNull()
    byte[] imageBytes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference pathToReference(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    private StorageUtil() {
        super();
    }
}
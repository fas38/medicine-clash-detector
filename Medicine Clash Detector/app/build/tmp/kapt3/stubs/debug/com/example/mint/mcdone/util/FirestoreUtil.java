package com.example.mint.mcdone.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000eJ\u001c\u0010\u001c\u001a\u00020\u00172\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00170\u001eJ\u0014\u0010 \u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170!J&\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010%\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/example/mint/mcdone/util/FirestoreUtil;", "", "()V", "currentUserDocRef", "Lcom/google/firebase/firestore/DocumentReference;", "getCurrentUserDocRef", "()Lcom/google/firebase/firestore/DocumentReference;", "firestoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreInstance$delegate", "Lkotlin/Lazy;", "health", "", "getHealth", "()Ljava/lang/String;", "setHealth", "(Ljava/lang/String;)V", "med", "getMed", "setMed", "addCurrentUserMedicine", "", "medicine", "deleteCurrentUserCondition", "healthCondition", "deleteCurrentUserMedicine", "getCurrentUser", "onComplete", "Lkotlin/Function1;", "Lcom/example/mint/mcdone/model/User;", "initCurrentUserIfFirstTime", "Lkotlin/Function0;", "updateCurrentUser", "name", "profilePicturePath", "updateCurrentUserCondition", "app_debug"})
public final class FirestoreUtil {
    private static final kotlin.Lazy firestoreInstance$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String health;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String med;
    public static final com.example.mint.mcdone.util.FirestoreUtil INSTANCE = null;
    
    private final com.google.firebase.firestore.FirebaseFirestore getFirestoreInstance() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHealth() {
        return null;
    }
    
    public final void setHealth(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMed() {
        return null;
    }
    
    public final void setMed(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    private final com.google.firebase.firestore.DocumentReference getCurrentUserDocRef() {
        return null;
    }
    
    public final void initCurrentUserIfFirstTime(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    public final void updateCurrentUser(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String healthCondition, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePicturePath) {
    }
    
    public final void updateCurrentUserCondition(@org.jetbrains.annotations.NotNull()
    java.lang.String healthCondition) {
    }
    
    public final void deleteCurrentUserCondition(@org.jetbrains.annotations.NotNull()
    java.lang.String healthCondition) {
    }
    
    public final void addCurrentUserMedicine(@org.jetbrains.annotations.NotNull()
    java.lang.String medicine) {
    }
    
    public final void deleteCurrentUserMedicine(@org.jetbrains.annotations.NotNull()
    java.lang.String medicine) {
    }
    
    public final void getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.mint.mcdone.model.User, kotlin.Unit> onComplete) {
    }
    
    private FirestoreUtil() {
        super();
    }
}
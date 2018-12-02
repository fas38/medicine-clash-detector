package com.example.mint.mcdone.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u000e0\u0010J\u0014\u0010\u0012\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J&\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/example/mint/mcdone/util/FirestoreUtil;", "", "()V", "currentUserDocRef", "Lcom/google/firebase/firestore/DocumentReference;", "getCurrentUserDocRef", "()Lcom/google/firebase/firestore/DocumentReference;", "firestoreInstance", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestoreInstance", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreInstance$delegate", "Lkotlin/Lazy;", "getCurrentUser", "", "onComplete", "Lkotlin/Function1;", "Lcom/example/mint/mcdone/model/User;", "initCurrentUserIfFirstTime", "Lkotlin/Function0;", "updateCurrentUser", "name", "", "healthCondition", "profilePicturePath", "app_debug"})
public final class FirestoreUtil {
    private static final kotlin.Lazy firestoreInstance$delegate = null;
    public static final com.example.mint.mcdone.util.FirestoreUtil INSTANCE = null;
    
    private final com.google.firebase.firestore.FirebaseFirestore getFirestoreInstance() {
        return null;
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
    
    public final void getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.mint.mcdone.model.User, kotlin.Unit> onComplete) {
    }
    
    private FirestoreUtil() {
        super();
    }
}
package com.example.tarix.Class;

import android.util.ArrayMap;

import androidx.annotation.NonNull;

import com.example.tarix.Model.CategoryModel;
import com.example.tarix.Model.ProfileModel;
import com.example.tarix.Model.QuestionModel;
import com.example.tarix.Model.TestModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DbQuery {

    public static FirebaseFirestore g_firstore;
    public static List<CategoryModel> g_catList = new ArrayList<>();
    public static List<TestModel> g_testList = new ArrayList<>();
    public static List<QuestionModel> g_quetionlist = new ArrayList<>();
    public static int g_selected_cat_index = 0;
    public static ProfileModel myProfile = new ProfileModel("NA", null);

    public static void creatUserData(String email, String name, MyComplectListener complectListener) {

        Map<String, Object> userData = new ArrayMap<>();

        userData.put("EMAIL_ID", email);
        userData.put("NAME", name);
        userData.put("TOTAL_SCORE", 0);

        DocumentReference userDoc = g_firstore.collection("USERS").document(FirebaseAuth.getInstance().getCurrentUser().getUid());

        WriteBatch batch = g_firstore.batch();
        batch.set(userDoc, userData);

        DocumentReference counDoc = g_firstore.collection("USERS").document("TOTAL_USERS");
        batch.update(counDoc, "COUNT", FieldValue.increment(1));

        batch.commit()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        complectListener.onSuccess();
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        complectListener.onFailere();
                    }
                });

    }

    public static void getUserData(final MyComplectListener complectListener) {
        g_firstore.collection("USERS").document(FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        myProfile.setName(documentSnapshot.getString("NAME"));
                        myProfile.setEmail(documentSnapshot.getString("EMAIL_ID"));

                        complectListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        complectListener.onFailere();
                    }
                });
    }

    public static void loadCategories(MyComplectListener complectListener) {
        g_catList.clear();

        g_firstore.collection("QUIZ").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Map<String, QueryDocumentSnapshot> docList = new ArrayMap<>();

                        for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                            docList.put(doc.getId(), doc);
                        }
                        QueryDocumentSnapshot catListDoc = docList.get("Categories");

                        long catCount = catListDoc.getLong("COUNT");
                        for (int i = 1; i <= catCount; i++) {
                            String catId = catListDoc.getString("CAT" + String.valueOf(i) + "_ID");
                            QueryDocumentSnapshot catDoc = docList.get(catId);

                            int toOfTests = catDoc.getLong("TO_OF_TESTS").intValue();
                            String catName = catDoc.getString("NAME");

                            g_catList.add(new CategoryModel(catId, catName, toOfTests));
                        }
                        complectListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        complectListener.onFailere();
                    }
                });
    }

    public static void loadTestData(final MyComplectListener complectListener) {
        g_testList.clear();

        g_firstore.collection("QUIZ").document(g_catList.get(g_selected_cat_index).getDocId())
                .collection("TESTS_LIST").document("TEST_INFO")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                        int toofTests = g_catList.get(g_selected_cat_index).getNoofTests();
                        for (int i = 1; i <= toofTests; i++) {
                            g_testList.add(new TestModel(
                                    documentSnapshot.getString("TEST" + String.valueOf(i) + "_ID"), 0,
                                    documentSnapshot.getLong("TEST" + String.valueOf(i) + "_TIME").intValue()
                            ));
                        }

                        complectListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        complectListener.onFailere();
                    }
                });
    }

    public static void loadData(final MyComplectListener complectListener) {
        loadCategories(new MyComplectListener() {
            @Override
            public void onSuccess() {
                getUserData(complectListener);
            }

            @Override
            public void onFailere() {
                complectListener.onFailere();
            }
        });
    }

    public static void loadquestions(MyComplectListener complectListener) {
        g_quetionlist.clear();
        g_firstore.collection("Questions")
                .whereEqualTo("CATEGORY", g_catList.get(g_selected_cat_index).getDocId())
                .whereEqualTo("TEST", g_testList.get(g_selected_cat_index).getTestId())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                            g_quetionlist.add(new QuestionModel(
                                    doc.getString("QUESTION"),
                                    doc.getString("A"),
                                    doc.getString("B"),
                                    doc.getString("C"),
                                    doc.getString("D"),
                                    doc.getLong("JAVOB").intValue()
                            ));
                        }
                        complectListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        complectListener.onFailere();
                    }
                });
    }
}

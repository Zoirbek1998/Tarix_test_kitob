package com.example.tarix.Model;

public class CategoryModel  {
    String  docId;
    String name;
    int noofTests;

    public CategoryModel(String docId, String name, int noofTests) {
        this.docId = docId;
        this.name = name;
        this.noofTests = noofTests;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoofTests() {
        return noofTests;
    }

    public void setNoofTests(int noofTests) {
        this.noofTests = noofTests;
    }
}

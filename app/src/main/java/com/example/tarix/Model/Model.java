package com.example.tarix.Model;

public class Model {
    int image;
    String titel1;
   String titel2;

    public Model(int image, String titel1, String titel2) {
        this.image = image;
        this.titel1 = titel1;
        this.titel2 = titel2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitel1() {
        return titel1;
    }

    public void setTitel1(String titel1) {
        this.titel1 = titel1;
    }

    public String getTitel2() {
        return titel2;
    }

    public void setTitel2(String titel2) {
        this.titel2 = titel2;
    }
}

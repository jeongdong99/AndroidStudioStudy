package com.example.exam2;

public class Items {
    private int imgID;
    private String titleStr;
    private int imgID2;

    Items(int img){
        this.imgID = img;

    }

    Items(int img,int img2){
        this.imgID = img;
        this.imgID2 = img2;
    }

    Items(int img, String title){
        this.imgID = img;
        this.titleStr = title;
    }

    public void setImgID(int img) {imgID = img;}
    public  void setTitle(String title) {titleStr = title;}
    public void setImgID2(int img2) {imgID2 = img2;}

    public int getImageID() {return imgID;};
    public String getTitle() {return titleStr;}
    public int getImageID2() {return imgID2;};

}

package com.example.recycleview;

public class Items {
    private int imgID;
    private String titleStr;
    private String krStr;

    Items(int img, String title, String kr){
        this.imgID = img;
        this.titleStr = title;
        this.krStr = kr;
    }

    public void setImgID(int img) {imgID = img;}
    public  void setTitle(String title) {titleStr = title;}
    public void setKrStr(String kr) {krStr = kr;}

    public int getImageID() {return imgID;};
    public String getTitle() {return titleStr;}
    public String getKrStr() {return krStr;}
}

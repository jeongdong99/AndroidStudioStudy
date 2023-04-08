package com.example.finalbtnfrag;

public class Items {
    private String nameStr;
    private String emailStr;
    private String phoneStr;

    Items(String nameStr,String emailStr,String phoneStr){
        this.nameStr = nameStr;
        this.emailStr = emailStr;
        this.phoneStr = phoneStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public void setPhoneStr(String phoneStr) {
        this.phoneStr = phoneStr;
    }

    public String getEmailStr() {
        return emailStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public String getPhoneStr() {
        return phoneStr;
    }
}

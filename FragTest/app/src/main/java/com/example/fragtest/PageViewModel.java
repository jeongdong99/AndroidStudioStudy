package com.example.fragtest;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<String> mName = new MutableLiveData<>();
    public void setName(String name) {mName.setValue(name);}
    public LiveData<String> getName() {return mName;}

    private MutableLiveData<String> mId = new MutableLiveData<>();
    public void setId(String id) {mId.setValue(id);}
    public LiveData<String> getId() {return mId;}

    private MutableLiveData<Integer> mCount = new MutableLiveData<>();
    public void setCount(int cnt) {mCount.setValue(cnt);}
    public  LiveData<Integer> getCount() {return  mCount;}


}

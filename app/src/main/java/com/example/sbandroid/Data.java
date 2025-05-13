package com.example.sbandroid;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable { // Класс хранящий в себе данные, необходимые для добавления/обновления/редактирования/вывода и т.д
    int id;
    String number;
    String description;
    String suspects;
    public Data(int id, String number, String description, String suspects){
        this.id = id;
        this.number = number;
        this.description = description;
        this.suspects = suspects;
    }
    protected Data(Parcel in){
        id = in.readInt();
        number = in.readString();
        description = in.readString();
        suspects = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in){
            return new Data(in);
        }
        @Override
        public Data[] newArray(int size){
            return new Data[size];
        }
    };
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSuspects(String suspects) {
        this.suspects = suspects;
    }

    public String getSuspects() {
        return suspects;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}

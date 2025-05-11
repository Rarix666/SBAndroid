package com.example.sbandroid;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataCivil implements Parcelable {
    int id;
    String fio;
    int pasport;
    String place;
    int medkarta;
    public DataCivil(int id, String fio, int pasport, String place, int medkarta){
        this.id = id;
        this.fio = fio;
        this.pasport = pasport;
        this.place = place;
        this.medkarta = medkarta;
    }
    protected DataCivil(Parcel in){
        id = in.readInt();
        fio = in.readString();
        pasport = in.readInt();
        place = in.readString();
        medkarta = in.readInt();
    }

    public static final Creator<DataCivil> CREATOR = new Creator<DataCivil>() {
        @Override
        public DataCivil createFromParcel(Parcel in){
            return new DataCivil(in);
        }
        @Override
        public DataCivil[] newArray(int size){
            return new DataCivil[size];
        }
    };
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setPasport(int pasport) {
        this.pasport = pasport;
    }

    public int getPasport() {
        return pasport;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setMedkarta(int medkarta) {
        this.medkarta = medkarta;
    }

    public int getMedkarta() {
        return medkarta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}

package com.example.sbandroid;

import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Supabase {
    public static void Autorization(Context context, Map<String, Object> arg){ // метод авторизации, предназначенный для обработки получаемых данных
        SupabaseService service = SupabaseClient.getInstance();
        service.autoPost(arg).enqueue(new Callback<List<Map<String, Object>>>() { //Используется для активации SupabaseService, метода autoPost
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    Log.e(TAG, "" + response.body());
                        Log.e(TAG, "" + arg);
                        if(response.body().size() != 0)
                        {
                            Intent intent = new Intent(context, Perehodic.class);
                            startActivity(context, intent, null);
                        }
                        else
                        {
                            Toast toast = Toast.makeText(context, "Данные введены неверно", Toast.LENGTH_LONG);
                            toast.show();
                        }

                }
                else {
                    Log.e(TAG, "" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public static  void getData(RecyclerView recyclerView, FragmentManager manager){ // метод предназначенный для заполнения списка формы инцедентов
        SupabaseService service = SupabaseClient.getInstance();
        List<Data> dataList = new ArrayList<>();
        service.getDataView().enqueue(new Callback<List<Map<String, Object>>>() { //Используется для активации SupabaseService, метода getDataView
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    for(Map<String, Object> item: response.body()){
                        int id = ((Double) item.get("id")).intValue();
                        String number = (String) item.get("Number");
                        String description = (String) item.get("Description");
                        String suspects = (String) item.get("Suspects");
                        dataList.add(new Data(id, number, description, suspects));
                        Log.e(TAG, "" + number + " " + id + " " + description + " " + suspects);
                    }
                    DataAdapter adapter = new DataAdapter(dataList, manager);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Log.e(TAG, "" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public  static  void getDataCivil(RecyclerView recyclerView){
        SupabaseService service = SupabaseClient.getInstance();
        List<DataCivil> dataCivilList = new ArrayList<>(); // Тут может быть ошибка!
        service.getDataViewCivil().enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    for(Map<String, Object> item: response.body()){
                        int id = ((Double) item.get("id")).intValue();
                        String fio = (String) item.get("FIO");
                        int pasport = ((Double) item.get("Pasport")).intValue();
                        String place = (String) item.get("Place");
                        int medkarta = ((Double) item.get("Medkarta")).intValue();
                        dataCivilList.add(new DataCivil(id, fio, pasport, place, medkarta));
                        Log.e(TAG,"" + fio + "" + id + " " + pasport + " " + place + " " + medkarta);
                    }
                    DataAdapterCivil adapterCivil = new DataAdapterCivil(dataCivilList);
                    recyclerView.setAdapter(adapterCivil);
                }
                else {
                    Log.e(TAG, "" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });
    }

    public static void SearchInc(RecyclerView recyclerView, Map<String, Object> params, FragmentManager manager){ //Метод предназначенный для поиска происшаствий по ID, Номеру, Описанию и подозреваемым
        SupabaseService service = SupabaseClient.getInstance();
        List<Data> dataList = new ArrayList<>();
        service.search(params).enqueue(new Callback<List<Map<String, Object>>>() { //Используется для активации SupabaseService, метода search
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    for(Map<String, Object> item: response.body()){
                        int id = ((Double) item.get("id")).intValue();
                        String number = (String) item.get("Number");
                        String description = (String) item.get("Description");
                        String suspects = (String) item.get("Suspects");
                        dataList.add(new Data(id, number, description, suspects));
                        Log.e(TAG, "" + number + " " + id + " " + description + " " + suspects);
                    }
                    DataAdapter adapter = new DataAdapter(dataList, manager);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Log.e(TAG, "" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void SearchCivil(RecyclerView recyclerView, Map<String, Object> params){
        SupabaseService service = SupabaseClient.getInstance();
        List<DataCivil> dataCivilList = new ArrayList<>();
        service.searchCivil(params).enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    for(Map<String, Object> item: response.body()){
                        int id = ((Double) item.get("id")).intValue();
                        String fio = (String) item.get("FIO");
                        int pasport = ((Double) item.get("Pasport")).intValue();
                        String place = (String) item.get("Place");
                        int medkarta = ((Double) item.get("Medkarta")).intValue();
                        dataCivilList.add(new DataCivil(id, fio, pasport, place, medkarta));
                        Log.e(TAG, "" + fio + " " + id + " " + pasport + " " + medkarta);
                    }
                    DataAdapterCivil adapter = new DataAdapterCivil(dataCivilList);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Log.e(TAG, "" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });
    }

    public static void deleteInc(Map<String, Object> arg, FragmentManager manager, Map<String, Object> argument){
        SupabaseService service = SupabaseClient.getInstance();
        service.deleteInc(arg).enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"Данные успешно обновлены");
                    if(argument.get("arg") != null){
                        SearchInc(TabLayout_inc.recyclerView, argument, manager);
                    }
                    else {
                        getData(TabLayout_inc.recyclerView, manager);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });
    }

    public static void updateInc(Map<String, Object> params, FragmentManager manager, Map<String, Object> argument){
        SupabaseService service = SupabaseClient.getInstance();
        service.updateInc(params).enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"Данные успешно обновлены");
                    if(argument.get("arg") != null){
                        SearchInc(TabLayout_inc.recyclerView, argument, manager);
                    }
                    else {
                        getData(TabLayout_inc.recyclerView, manager);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });
    }

    public static void addInc(Map<String, Object> params, FragmentManager manager){
        SupabaseService service = SupabaseClient.getInstance();
        service.addInc(params).enqueue(new Callback<List<Map<String, Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String, Object>>> call, Response<List<Map<String, Object>>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "Данные успешно добавлены!");
                    getData(TabLayout_inc.recyclerView, manager);
                }
                else {
                    Log.e(TAG, "При добавлении данных произшла ошибка!" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<List<Map<String, Object>>> call, Throwable t) {

            }
        });
    }
}

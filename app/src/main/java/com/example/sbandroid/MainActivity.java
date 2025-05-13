package com.example.sbandroid;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.example.sbandroid.Supabase.getData;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity { //Класс авторизации
    public static Map<String, Object> arg = new HashMap<>();
    EditText Login, Password;
    User user;

    public static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.editTextText);
        Password = findViewById(R.id.editTextTextPassword);
    }

    public void Perehod(View view){ //Слушатель для кнопки авторизации

        arg.put("AName", Login.getText().toString());
        arg.put("APassword", Password.getText().toString());
        Log.e(TAG, "" + Login + "" + Password);
        Supabase.Autorization( this, arg);
    }

}
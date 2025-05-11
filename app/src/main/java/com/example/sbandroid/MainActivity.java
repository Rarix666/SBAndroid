package com.example.sbandroid;

import static com.example.sbandroid.Supabase.getData;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    EditText Login, Password;
    public static RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.editTextText);
        Password = findViewById(R.id.editTextTextPassword);

    }

    public void Perehod(View view){ //Слушатель для кнопки авторизации
        Supabase.Autorization(Login.getText().toString(), Password.getText().toString(), this);
    }

}
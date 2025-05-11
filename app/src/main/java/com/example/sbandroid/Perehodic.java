package com.example.sbandroid;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class Perehodic extends AppCompatActivity { //Класс отвечающий за переход из авторизации в основную форму и перемещение между формами Инциденты и граждане
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.osnov_forma);

        TabLayout tabLayout = findViewById(R.id.Tablayout21);
        ViewPager2 pager2 = findViewById(R.id.viewpager21);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TabLayout_inc());
        fragmentList.add(new TabLayot_civil());

        pager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return fragmentList.size();
            }
        });
        new TabLayoutMediator(tabLayout, pager2, ((tab, position) -> {
            if(position == 0){
                tab.setText("Инциденты");
            }
            else {
                tab.setText("Граждане");
            }
        })).attach();

    }
}

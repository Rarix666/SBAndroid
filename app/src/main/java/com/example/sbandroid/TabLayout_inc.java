package com.example.sbandroid;

import static com.example.sbandroid.Supabase.getData;
import static com.example.sbandroid.Supabase.SearchInc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public class TabLayout_inc extends Fragment {
    public static Map<String, Object> argument = new HashMap<>();
    public static RecyclerView recyclerView;
    EditText DeloSearch;
    ImageButton searchbutton;
    ImageButton createIncbutton;

    @NonNull
    @Override

    public View onCreateView(@NonNull LayoutInflater flater, ViewGroup group, @Nullable Bundle bund){ //Метод отвечающий за вызов списка и его вывод, а также работу поиска
          View view = flater.inflate(R.layout.incidets_forma, group, false);
          DeloSearch = view.findViewById(R.id.Delo_EditText);
          createIncbutton = view.findViewById(R.id.buttonCreateInc);
          createIncbutton.setOnClickListener(v -> onAddClick());
        searchbutton = view.findViewById(R.id.button2);
        searchbutton.setOnClickListener(v -> onSearchClick());
        recyclerView = view.findViewById(R.id.Recycle_Incedent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getData(recyclerView, getActivity().getSupportFragmentManager());
          return view;
    }

    public void onSearchClick(){ //Метод активности поиска, по нажатию на кнопку поиска
        String filter = DeloSearch.getText().toString();
        argument.clear();
        if (filter.length() != 0) {
            argument.put("arg", filter);
            SearchInc(recyclerView, argument, getActivity().getSupportFragmentManager());
        }
        else {
            getData(recyclerView, getActivity().getSupportFragmentManager());
        }
    }

    public void onAddClick(){
        AddDialogFragment fragment = new AddDialogFragment();
        fragment.show(getActivity().getSupportFragmentManager(), "custom");
    }
}

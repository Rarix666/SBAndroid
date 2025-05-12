package com.example.sbandroid;

import static com.example.sbandroid.Supabase.SearchInc;
import static com.example.sbandroid.Supabase.SearchCivil;
import static com.example.sbandroid.Supabase.getData;
import static com.example.sbandroid.Supabase.getDataCivil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public class TabLayot_civil extends Fragment {
    public static Map<String, Object> argument = new HashMap<>();
    public static RecyclerView recyclerView;
    EditText FIO_EditText, Pasport_EditText, Place_EditText, MedKarta_EditText;

    Button searchbutton;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater flater, ViewGroup group, @Nullable Bundle bund){
        View view = flater.inflate(R.layout.civilian_forma, group, false);
        FIO_EditText = view.findViewById(R.id.FIO_EditText);
        Pasport_EditText = view.findViewById(R.id.Pasport_EditText);
        Place_EditText = view.findViewById(R.id.Jitel_EditText);
        MedKarta_EditText = view.findViewById(R.id.Kod_EditText);
        searchbutton = view.findViewById(R.id.Poisk_Button);
        searchbutton.setOnClickListener(v -> onSearchClick());
        recyclerView = view.findViewById(R.id.Recycle_Civil);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getDataCivil(recyclerView);
        return view;
    }

    public void onSearchClick(){ //Метод активности поиска, по нажатию на кнопку поиска
        String filterFIO = FIO_EditText.getText().toString();
        String filterPasport = Pasport_EditText.getText().toString();
        String filterPlace = Place_EditText.getText().toString();
        String filterMed = MedKarta_EditText.getText().toString();
        argument.clear();
        if (filterFIO.length() != 0 || filterPasport.length() != 0 || filterPlace.length() != 0 || filterMed.length() != 0) {
            argument.put("fio", filterFIO);
            argument.put("pasport", filterPasport);
            argument.put("place", filterPlace);
            argument.put("medkarta", filterMed);
            SearchCivil(recyclerView, argument);
        }
        else {
            getDataCivil(recyclerView);
        }
    }
}

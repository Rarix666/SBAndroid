package com.example.sbandroid;

import static com.example.sbandroid.Supabase.addInc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.HashMap;
import java.util.Map;

public class AddDialogFragment extends DialogFragment {
    EditText CreateNumberText, CreateDescriptionText, CreateSuspectsText;
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){ //Метод создания диалогового окна для функции добавления
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Добавить новое происшествие");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_dataview, null);
        builder.setView(view);

        CreateNumberText = view.findViewById(R.id.numberEditCreate);
        CreateDescriptionText = view.findViewById(R.id.descriptionEditCreate);
        CreateSuspectsText = view.findViewById(R.id.suspectsEditCreate);

        builder.setPositiveButton("Добавить", ((dialog, which) -> addClick()));
        builder.setNegativeButton("Отмена", ((dialog, which) -> dismiss()));

        return builder.create();
    }
    public void addClick(){ //Метод отвечающий за добавление данных в БД
        String createNumber = CreateNumberText.getText().toString();
        String createDescription = CreateDescriptionText.getText().toString();
        String createSuspects = CreateSuspectsText.getText().toString();
        Map<String, Object> newData = new HashMap<>();
        if(!createNumber.isEmpty() && !createDescription.isEmpty() && !createSuspects.isEmpty()){
            newData.put("IncNumber", createNumber);
            newData.put("IncDescription", createDescription);
            newData.put("IncSuspects", createSuspects);
            addInc(newData, getParentFragmentManager());
        }
        else {
            Toast toast = Toast.makeText(getActivity(),
                    "Все поля должны быть заполнены!",
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }
}

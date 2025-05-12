package com.example.sbandroid;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.util.HashMap;
import java.util.Map;

public class EditDialogFragment  extends DialogFragment {
    EditText idText, NumberText, DescriptionText, SuspectsText;
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Редактировать запись");

        View view = getLayoutInflater().inflate(R.layout.dialog_edit_dataview, null);
        builder.setView(view);


        Data data = getArguments().getParcelable("Data");

        idText = view.findViewById(R.id.idEdit);
        NumberText = view.findViewById(R.id.numberEdit);
        DescriptionText = view.findViewById(R.id.descriptionEdit);
        SuspectsText = view.findViewById(R.id.suspectsEdit);


        idText.setText(String.valueOf(data.id));

        builder.setPositiveButton("Сохранить", ((dialog, which) -> updateData(data)));
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.dismiss());
        builder.setNeutralButton("Удалить", ((dialog, which) -> deleteData(data)));

        return builder.create();
    }
    public void deleteData(Data data){
        FragmentManager manager = getParentFragmentManager();
        AlertDialog.Builder confirmDialog = new AlertDialog.Builder(getActivity());
        confirmDialog.setTitle("Подтверждение");
        confirmDialog.setMessage("Вы точно хотите удалить запись?");
        confirmDialog.setNegativeButton("Отмена", ((dialog1, which1) -> dialog1.dismiss()));
        confirmDialog.setPositiveButton("Удалить", ((dialog1, which1) -> {
            Map<String, Object> params = new HashMap<>();
            params.put("IncID", data.getId());
            Supabase.deleteInc(params, manager, TabLayout_inc.argument);
        }));
        confirmDialog.create().show();
    }

    public void updateData(Data data){
        String number = NumberText.getText().toString();
        String description = DescriptionText.getText().toString();
        String suspects = SuspectsText.getText().toString();
        if (!idText.getText().toString().isEmpty() && !NumberText.getText().toString().isEmpty() && !DescriptionText.getText().toString().isEmpty() && !SuspectsText.getText().toString().isEmpty()) {
            Map<String, Object> updateData = new HashMap<>();
            updateData.put("IncID",  data.getId());
            updateData.put("IncNumber", number);
            updateData.put("IncDescription", description);
            updateData.put("IncSuspects", suspects);
            Supabase.updateInc(updateData, getParentFragmentManager(), TabLayout_inc.argument);
        }
        else{
            Toast toast = Toast.makeText(getActivity(), "Заполните вес поля!", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}

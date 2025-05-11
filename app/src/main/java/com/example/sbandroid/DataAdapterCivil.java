package com.example.sbandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapterCivil extends RecyclerView.Adapter<DataAdapterCivil.DataViewHolder> {
    private List<DataCivil> dataList;  // Используем DataCivil

    public DataAdapterCivil(List<DataCivil> dataList) { // Используем DataCivil
        this.dataList = dataList == null ? new java.util.ArrayList<>() : dataList; // Avoid null
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dataview_civil, parent, false);  // Change to correct layout
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataCivil dataCivil = dataList.get(position);
        holder.idTextView.setText("ID: " + dataCivil.getId());
        holder.fioTextView.setText("ФИО: " + dataCivil.getFio());
        holder.pasportTextView.setText("Паспорт: " + dataCivil.getPasport());
        holder.placeTextView.setText("Место жительства: " + dataCivil.getPlace());
        holder.medkartaTextView.setText("Мед. карта: " + dataCivil.getMedkarta());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView, fioTextView, pasportTextView, placeTextView, medkartaTextView;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.Id);         // Change to correct IDs
            fioTextView = itemView.findViewById(R.id.FIO);       // Change to correct IDs
            pasportTextView = itemView.findViewById(R.id.Pasport); // Change to correct IDs
            placeTextView = itemView.findViewById(R.id.Place);   // Change to correct IDs
            medkartaTextView = itemView.findViewById(R.id.Medkarta);// Change to correct IDs
        }
    }
}

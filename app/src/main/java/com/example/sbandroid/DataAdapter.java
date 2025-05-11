package com.example.sbandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<Data> dataList;
    private FragmentManager manager;
    public DataAdapter(List<Data> dataList, FragmentManager manager){
        this.dataList = dataList;
        this.manager = manager;
    }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dataview, parent, false);
        return new DataViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position){
        Data data = dataList.get(position);
        holder.idTextView.setText("Номер дела: " + data.getId());
        holder.numberTextView.setText("Населённый пункт: " + data.getNumber());
        holder.descriptonTextView.setText("Описание: " + data.getDescription());
        holder.suspectsTextView.setText("Подозреваемые: " + data.getSuspects());
        holder.imageButton.setOnClickListener(v -> showEditDialog(data));
    }
    @Override
    public int getItemCount(){
        return dataList.size();
    }
    static class DataViewHolder extends RecyclerView.ViewHolder{
        TextView idTextView, numberTextView, descriptonTextView, suspectsTextView;
        ImageButton imageButton;
        public DataViewHolder(@NonNull View itemView){
            super(itemView);
            idTextView = itemView.findViewById(R.id.Id);
            numberTextView = itemView.findViewById(R.id.Number);
            descriptonTextView = itemView.findViewById(R.id.Description);
            suspectsTextView = itemView.findViewById(R.id.Suspects);
            imageButton = itemView.findViewById(R.id.buttonEdit);
        }
    }

    private void showEditDialog(Data data) {
        EditDialogFragment editDialogFragment = new EditDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("Data", data);
        editDialogFragment.setArguments(bundle);
        editDialogFragment.show(manager, "custom");
    }
}

package com.example.firstprojectjob.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstprojectjob.R;
import com.example.firstprojectjob.model.Knp;

import java.util.List;

public class Free2Adapter extends RecyclerView.Adapter<Free2Adapter.FreeHolder>{
    private List<Knp> mKnpList;

    public Free2Adapter(List<Knp> mKnpList){
        this.mKnpList = mKnpList;
    }
    @NonNull
    @Override
    public Free2Adapter.FreeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.knp2_row,parent,false);
        return new Free2Adapter.FreeHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull Free2Adapter.FreeHolder holder, int position) {
        Knp knp = mKnpList.get(position);
        holder.name.setText(knp.getName());
        holder.boolVal.setText(String.valueOf(knp.isIs_individuals()));
    }
    @Override
    public int getItemCount() {
        return mKnpList.size();
    }

    public class FreeHolder extends RecyclerView.ViewHolder{
        private TextView name,boolVal;
        public FreeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_txt);
            boolVal = itemView.findViewById(R.id.bool_val);
        }
    }
}

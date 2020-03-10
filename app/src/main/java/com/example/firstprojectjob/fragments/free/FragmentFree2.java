package com.example.firstprojectjob.fragments.free;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstprojectjob.R;
import com.example.firstprojectjob.adapters.Free2Adapter;
import com.example.firstprojectjob.adapters.FreeAdapter;
import com.example.firstprojectjob.model.Knp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentFree2 extends Fragment implements IFreeView{
    RecyclerView recyclerView;
    private Free2Adapter freeAdapter;
    private List<Knp> mKnpList = new ArrayList<>();
    private IFreePresenter freePresenter = new FreePresenter(this);
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_free,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        freeAdapter = new Free2Adapter(mKnpList);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(freeAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),LinearLayoutManager.VERTICAL));

        freePresenter.getKnps();

        return v;
    }
    @Override
    public void modifyKnps(Knp[] knps){
        mKnpList.addAll(Arrays.asList(knps));
        freeAdapter.notifyDataSetChanged();
    }
}

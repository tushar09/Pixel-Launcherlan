package com.captaindroid.lan.test;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.captaindroid.lan.MainActivity;
import com.captaindroid.lan.R;
import com.captaindroid.lan.databinding.RowAppAdaptiveBinding;
import com.captaindroid.lan.databinding.RowAppBinding;
import com.captaindroid.lan.models.AppModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class TestListAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<TestModel> applIst;


    public TestListAdapter(Context context, ArrayList<TestModel> applIst){
        this.context = context;
        this.applIst = applIst;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        if(viewType == 0){
            RowAppBinding binding = RowAppBinding.inflate(LayoutInflater.from(context), parent, false);
            return new Holder(binding);
        }else {
            RowAppAdaptiveBinding binding = RowAppAdaptiveBinding.inflate(LayoutInflater.from(context), parent, false);
            return new HolderCircle(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position){
        if(holder.getItemViewType() == 0){
            Log.e("type", holder.getItemViewType() + "");
            Holder h = (Holder) holder;
            h.binding.tvName.setText("");
            Glide.with(context)
                    .load(applIst.get(position).getImage())
                    .into(h.binding.ivIcon);
        }

    }

    @Override
    public int getItemCount(){
        return applIst.size();
    }

    @Override
    public int getItemViewType(int position){
        return 0;
    }

    private class Holder extends RecyclerView.ViewHolder{

        RowAppBinding binding;

        public Holder(@NonNull RowAppBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private class HolderCircle extends RecyclerView.ViewHolder{

        RowAppAdaptiveBinding binding;

        public HolderCircle(@NonNull RowAppAdaptiveBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

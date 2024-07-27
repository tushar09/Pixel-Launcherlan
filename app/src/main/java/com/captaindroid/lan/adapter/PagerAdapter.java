package com.captaindroid.lan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.captaindroid.lan.MainActivity;
import com.captaindroid.lan.databinding.DesktopBinding;
import com.captaindroid.lan.models.DesktopAppModel;
import com.captaindroid.lan.utils.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder>{

    private List<Integer> colorList;
    private Context context;

    public PagerAdapter(List<Integer> colorList, Context context) {
        this.colorList = colorList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DesktopBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.binding.rvApp.setLayoutManager(new GridLayoutManager(context, 5));
//        ViewTreeObserver vto = holder.binding.getRoot().getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
//                    holder.binding.getRoot().getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                } else {
//                    holder.binding.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                }
//                Log.e("height", holder.binding.cvRvAppsHolder.getHeight() + " asdf");
//
//            }
//        });
//
//        ArrayList<DesktopAppModel> dp = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            dp.add(new DesktopAppModel(true));
//        }
//        holder.binding.rvApp.setAdapter(new DesktopAppListAdapter(context, dp));
//        holder.binding.rvApp.setTag(dp);
//        if(MainActivity.ma.desktopRecyclerView == null){
//            MainActivity.ma.desktopRecyclerView = holder.binding.rvApp;
//        }



    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        DesktopBinding binding;
        public ViewHolder(@NonNull DesktopBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

package com.captaindroid.lan.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.captaindroid.lan.R;
import com.captaindroid.lan.databinding.ActivityTestViewBinding;
import com.captaindroid.lan.interfaces.ItemFinder;
import com.captaindroid.lan.utils.GridLayoutManager;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class TestViewActivity extends AppCompatActivity {

    public static TestViewActivity tva;

    public ActivityTestViewBinding binding;

    public CardView v;

    public Vibrator vibe;

    public Bitmap b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tva = this;

        //b = createBitmapFromView(this, binding.fab);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v = binding.ivFloat;

        binding.holder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    //Log.e("cool", event.getX() + " " + event.getY());
                    binding.holder.showSuggestionPosition((int) (event.getX() - 200), (int) (event.getY() - 300));
                }

                return true;
            }
        });

        //binding.holder.loadView();
//        ArrayList<TestModel> images = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            images.add(new TestModel("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"));
//        }
//        GridLayoutManager layoutManager=new GridLayoutManager(this,5);
//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if(position == 0){
//                    return 3;
//                }else {
//                    return 1;
//                }
//            }
//        });
//        TestListAdapter adapter = new TestListAdapter(this, images);
//        binding.rv.setLayoutManager(layoutManager);
//        binding.rv.setAdapter(adapter);

    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if(event.getAction() == MotionEvent.ACTION_MOVE){
//            posX = (int) event.getX() - 200;
//            posY = (int) event.getY() - 300;
//
//            if(desktopRecyclerView != null && binding.ivFloat.getVisibility() == View.VISIBLE){
//                if(desktopRecyclerView.findChildViewUnder(posX, posY) != null){
//                    View v = desktopRecyclerView.findChildViewUnder(posX, posY);
//                    ((ItemFinder)desktopRecyclerView.getAdapter()).findItem((Integer) ((MaterialCardView)v.findViewById(R.id.cv)).getTag());
//                    Log.e("Touch", "not null");
//                }else{
//                    Log.e("Touch", "null");
//                    ((ItemFinder)desktopRecyclerView.getAdapter()).findItem(-1);
//                }
//            }
//        }else if(event.getAction() == MotionEvent.ACTION_UP){
//            if(desktopRecyclerView != null){
//                ((ItemFinder)desktopRecyclerView.getAdapter()).findItem(-1);
//            }
//        }
//
//        if(v != null){
//            v.setX(event.getX() - 200);
//            v.setY(event.getY() - 300);
//        }
//        return super.dispatchTouchEvent(event);
//    }

    private Bitmap createBitmapFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
}
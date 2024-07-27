package com.captaindroid.lan.test;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.captaindroid.lan.databinding.AppPlaceSuggestionBinding;

public class DeskTopper extends RelativeLayout {

    //file renamed

    private int [] x = new int[]{0, 216, 432, 648, 864};
    private int [] y = new int[]{0, 416, 832, 1248, 1664};

    private int xFact = 20;
    private int yFact = 40;

    private int xPos;
    private int yPos;

    int finalx;
    int finaly;

    private AppPlaceSuggestionBinding floater;

    public DeskTopper(Context context) {
        super(context);
        init(null);
    }

    public DeskTopper(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DeskTopper(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public DeskTopper(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        loadView();
    }

    public void loadView(){

        floater = AppPlaceSuggestionBinding.inflate(LayoutInflater.from(getContext()));



        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        addView(floater.getRoot());
        floater.getRoot().setLayoutParams(lp2);
        //floater.getRoot().setVisibility(View.GONE);

        for (int i = 0; i < 1080; i += 216) {

            AppPlaceSuggestionBinding appPlaceSuggestionBinding = AppPlaceSuggestionBinding.inflate(LayoutInflater.from(getContext()));


            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            addView(appPlaceSuggestionBinding.getRoot());


            int finalI = i;
            appPlaceSuggestionBinding.getRoot().post(new Runnable() {
                @Override
                public void run() {
                    lp.setMargins(finalI + ((216 - appPlaceSuggestionBinding.getRoot().getHeight()) / 2), (216 - appPlaceSuggestionBinding.getRoot().getHeight()) / 2, 0, 0);
                    appPlaceSuggestionBinding.getRoot().setLayoutParams(lp);
                    Log.e("i",  appPlaceSuggestionBinding.getRoot().getHeight() + " asdf");
                    setTouchListener(appPlaceSuggestionBinding.getRoot());
                }
            });

        }

//        Button b = new Button(getContext());
//        b.setWidth(216 * 5);
//        b.setHeight(216 * 2);
//        b.setBackgroundColor(Color.WHITE);
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(0, 216, 0, 0);
//        addView(b);
//        b.post(new Runnable() {
//            @Override
//            public void run() {
//                b.setLayoutParams(lp);
//            }
//        });
    }

    private void setTouchListener(View fab) {


        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                xPos = (int) fab.getX();
                yPos = (int) fab.getY();
                Log.e("ok", xPos + " " + yPos);
                return false;
            }
        });

        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    xPos = 0;
                    yPos = 0;
                }else {
                    if(xPos != 0){
                        Log.e("ok 2", xPos + " " + yPos);
                        int difx = (int) Math.abs(Math.abs(Math.abs(xPos) - Math.abs(TestViewActivity.tva.v.getX())));
                        int difY = (int) Math.abs(Math.abs(Math.abs(yPos) - Math.abs(TestViewActivity.tva.v.getY())));
                        if(difx > 30 || difY > 30){
                            TestViewActivity.tva.v.setX(xPos);
                            TestViewActivity.tva.v.setY(yPos);

                            TestViewActivity.tva.binding.ivIconFront.setImageBitmap(TestViewActivity.tva.b);
                            TestViewActivity.tva.binding.ivIconBack.setImageBitmap(TestViewActivity.tva.b);
                            TestViewActivity.tva.binding.ivFloat.setVisibility(View.VISIBLE);
                            Log.e("touch", "done");
                        }
                    }

                }

                return false;
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("drawsinf", "asdf");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.e("height", h + "");
        Log.e("width", w + "");
    }

    public void showSuggestionPosition(int x, int y) {

        floater.getRoot().setVisibility(VISIBLE);
        RelativeLayout.LayoutParams lp = (LayoutParams) floater.getRoot().getLayoutParams();

//        if(finalx > 0 && finalx < xFact){
//            finalx = 0;
//        }else if(finalx > 216 - xFact && finalx < 216 + xFact){
//            finalx = 216;
//        }else if(finalx > (216 * 2) - xFact && finalx < (216 * 2) + xFact){
//            finalx = 216 * 2;
//        }else if(finalx > (216 * 3) - xFact && finalx < (216 * 3) + xFact){
//            finalx = 216 * 3;
//        }else if(finalx > (216 * 4) - xFact && finalx < (216 * 4) + xFact){
//            finalx = 216 * 4;
//        }else if(finalx > (216 * 5) - xFact){
//            finalx = 216 * 5;
//        }
//
//        if(finaly > 0 && finaly < yFact){
//            finaly = 0;
//        }else if(finaly > 416 - yFact && finaly < 416 + yFact){
//            finaly = 416;
//        }else if(finaly > (416 * 2) - yFact && finaly < (416 * 2) + yFact){
//            finaly = 416 * 2;
//        }else if(finaly > (416 * 3) - yFact && finaly < (416 * 3) + yFact){
//            finaly = 416 * 3;
//        }else if(finaly > (416 * 4) - yFact && finaly < (416 * 4) + yFact){
//            finaly = 416 * 4;
//        }else if(finaly > (416 * 5) - yFact){
//            finaly = 416 * 5;
//        }

        finalx = getClosestX(x);
        finaly = getClosetY(y);


        lp.setMargins(finalx, finaly, 0, 0);
        floater.getRoot().setLayoutParams(lp);
        //((RelativeLayout.LayoutParams)floater.getRoot().getLayoutParams()).setMargins(finalI + ((216 - appPlaceSuggestionBinding.getRoot().getHeight()) / 2), (216 - appPlaceSuggestionBinding.getRoot().getHeight()) / 2, 0, 0);

    }

    private int getClosestX(int xpos){
        int distance = Math.abs(x[0] - xpos);
        int idx = 0;
        for(int c = 1; c < x.length; c++){
            int cdistance = Math.abs(x[c] - xpos);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        int theNumber = x[idx];
        return theNumber;
    }

    private int getClosetY(int ypos){
        int distance = Math.abs(y[0] - ypos);
        int idx = 0;
        for(int c = 1; c < y.length; c++){
            int cdistance = Math.abs(y[c] - ypos);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        int theNumber = y[idx];
        return theNumber;
    }

    public Pair<Integer, Integer> getChoosenPositionLocation(){
        floater.getRoot().setVisibility(View.GONE);
        return new Pair<>(finalx, finaly);
    }
}

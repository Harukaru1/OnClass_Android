package com.example.week3_th;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;


public class GraphicsView extends View {

    int x=0;
    int y=0;
    int d=100;
    int r=50;

    Bitmap[] frames = new Bitmap[36];
    int i = 0;
    long last_tick=0;
    long period=200;
    Context ctext;
    MediaPlayer mPlayer;
    public GraphicsView(Context context) {
        super(context);

        ctext = context;
        frames[0]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_01);
        frames[1] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_02);
        frames [2]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_03);
        frames[3]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_04);
        frames [4]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_05);
        frames [5] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_06);
        frames [6]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_07);
        frames[7]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_08);
        frames[8] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_09);
        frames [9]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_10);
        frames[10]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_11);
        frames [11]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_12);
        frames [12] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_13);
        frames [13]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_14);
        frames[14]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_15);
        frames[15] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_16);
        frames [16]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_17);
        frames[17]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_18);
        frames [18]= BitmapFactory.decodeResource(getResources (), R.drawable.frame_19);
        frames [19] = BitmapFactory.decodeResource(getResources (), R.drawable.frame_00);
        mPlayer = MediaPlayer.create(ctext, R.raw.keyboardcat);
        mPlayer.start();
    }

    //Bài 1
   /* @Override
    protected void onDraw(Canvas canvas){

        Rect r=new Rect(40, 40, 400, 200);
        paint paint = new Paint();
        paint.setStyle (Paint.Style. FILL);
        paint.setColor(Color.RED);
        canvas.drawRect (r, paint);

        invalidate();

    } */

    //Bài 2
   /* @Override
    protected void onDraw(Canvas canvas){

        if (x!=0&&y!=0) {
            int right=x+d;
            int bottom=y+r;
            Rect r=new Rect(x, y, right, bottom);
            Paint paint = new Paint();
            paint.setStyle (Paint.Style. FILL);
            paint.setColor(Color.RED);
            canvas.drawRect (r, paint);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        x= (int) event.getX();
        y= (int) event.getY();
        return super.onTouchEvent (event);
    }*/

    //Bài 3
   /* @Override
    protected void onDraw(Canvas canvas){

        if (i<36) {
            canvas.drawBitmap (frames [i], 40, 40,  new Paint());
        }
        else{
            i=0;
        }
        invalidate();
    }


    @Override
    public boolean onTouchEvent (MotionEvent event) {
        i++;
        return true;
    }*/

    //Bài 4
    @Override
    protected void onDraw(Canvas canvas){

        if (i<36) {
            long time = (System.currentTimeMillis() - last_tick);
            if (time >= period) //the delay time has passed. set next frame
            {
                last_tick = System.currentTimeMillis();
                canvas.drawBitmap (frames[i], 40, 40, new Paint());
                i++;
                // Again call onDraw method
                postInvalidate();
            }
            else //still within delay. redraw current frame
            {
                canvas.drawBitmap (frames [i], 40, 40, new Paint()); // Again call onDraw method
                postInvalidate();
            }
        }
        else{
            i=0;
            postInvalidate();
        }
    }

}

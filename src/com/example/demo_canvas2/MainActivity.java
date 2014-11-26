package com.example.demo_canvas2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
    List<PointF> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class MyView extends View{
        Paint paint=new Paint();
		public MyView(Context context) {
			super(context);
			list=new ArrayList<PointF>();
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(5);
		}
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			for(PointF f : list){
				canvas.drawPoint(f.x,f.y,paint);
			}
		}
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			PointF point=new PointF(event.getX(),event.getY());
			list.add(point);
			invalidate();
			return true;
		}
	}

}

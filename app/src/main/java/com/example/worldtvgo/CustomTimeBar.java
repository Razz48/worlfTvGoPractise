//package com.example.worldtvgo;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.View;
//
//public class CustomTimeBar extends View {
//    private Paint paint;
//    private long duration;
//    private long position;
//
//    public CustomTimeBar(Context context) {
//        super(context);
//        init();
//    }
//
//    public CustomTimeBar(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public CustomTimeBar(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init() {
//        paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(5);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        // Draw the time bar
//        // Example: Draw a simple line representing the time bar
//        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
//        // Draw the current position
//        float positionRatio = (float) position / duration;
//        canvas.drawLine(0, getHeight() / 2, getWidth() * positionRatio, getHeight() / 2, paint);
//    }
//
//    public void setDuration(long duration) {
//        this.duration = duration;
//        invalidate();
//    }
//
//    public void setPosition(long position) {
//        this.position = position;
//        invalidate();
//    }
//
//    public interface OnScrubberPositionChangedListener {
//        void onScrubberPositionChanged(long newPosition);
//    }
//
//
//
//    public void setOnScrubberPositionChangedListener(OnScrubberPositionChangedListener listener) {
//        this.listener = listener;
//    }
//
//}

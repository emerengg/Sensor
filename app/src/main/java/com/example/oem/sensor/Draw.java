package com.example.oem.sensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;

public class Draw extends View {

    private Paint paint;
    private int cWidth;
    private int cHeight;
    private int x;
    private int y;
    private int size;

    public Draw(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        size = 200;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        cWidth = w;
        cHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void updateRect (SensorEvent event) {
        x = x - (int) event.values[0];
        y = y + (int) event.values[1];

        if (x <= 0)
        {
            x = 0;
        }
        if (y <= 0)
        {
            y = 0;
        }
        if (x >= cWidth - size)
        {
            x = cWidth - size;
        }
        if (y >= cHeight - size)
        {
            y = cHeight - size;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(x, y, x + size, y + size, paint);
        invalidate();
    }
}

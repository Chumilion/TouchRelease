package chumilion.touchrelease;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by 2016esison on 9/25/2015.
 */
public class MyTextView extends View
{
    Paint paint;
    private int[] myValues;

    public MyTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setupAttributes(attrs);
        update();
    }

    private void setupAttributes(AttributeSet attrs)
    {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, 0, 0);
        int startValue = 0;
        try
        {
            startValue = a.getInt(R.styleable.MyTextView_initialValue, 0);
            Arrays.fill(myValues, startValue);
        }
        finally
        {
            a.recycle();
        }
    }

    public void update()
    {
        invalidate();
    }

    public int[] getValues()
    {
        return myValues;
    }

    public void setValues(int[] arr)
    {
        myValues = arr;
    }
    public void setValues(int ind, int val)
    {
        myValues[ind] = val;
    }

    public void incrementAndUpdate(int ind)
    {
        myValues[ind]++;
        update();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(myValues[0] + "", getHeight()/4, getWidth()/4, paint);
        canvas.drawText(myValues[1] + "", getHeight()/4, getWidth()*3/4, paint);
        canvas.drawText(myValues[2] + "", getHeight()*3/4, getWidth()/4, paint);
        canvas.drawText(myValues[3] + "", getHeight()*3/4, getWidth()*3/4, paint);
    }
}

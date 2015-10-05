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
    private int[] myValues;
    private int myTxtSize;
    private boolean myPass;
    private boolean myInside;

    public MyTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setupAttributes(attrs);
        myPass = false;
        update();
    }

    private void setupAttributes(AttributeSet attrs)
    {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyTextView, 0, 0);
        int startValue = 0;
        myValues = new int[4];
        try
        {
            startValue = a.getInt(R.styleable.MyTextView_initialValue, 0);
            Arrays.fill(myValues, startValue);
            myTxtSize = a.getInt(R.styleable.MyTextView_textSize, 30);
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
    public int getTxtSize()
    {
        return myTxtSize;
    }
    public boolean getPass()
    {
        return myPass;
    }
    public boolean getInside()
    {
        return myInside;
    }

    public void setValues(int[] arr)
    {
        myValues = arr;
    }
    public void setValues(int ind, int val)
    {
        myValues[ind] = val;
    }
    public void setTxtSize(int s)
    {
        myTxtSize = s;
    }
    public void setPass(boolean tf)
    {
        myPass = tf;
    }
    public void setInside(boolean tf)
    {
        myInside = tf;
    }

    public void incrementAndUpdate(int ind)
    {
        myValues[ind]++;
        update();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(myTxtSize);
        paint.setTextAlign(Paint.Align.CENTER);
        float shift = (paint.descent() + paint.ascent()) / 2;
        canvas.drawText(myValues[0] + "", getWidth()/4, getHeight()/4 - shift, paint);
        canvas.drawText(myValues[1] + "", getWidth()*3/4, getHeight()/4 - shift, paint);
        canvas.drawText(myValues[2] + "", getWidth()/4, getHeight()*3/4 - shift, paint);
        canvas.drawText(myValues[3] + "", getWidth()*3/4, getHeight()*3/4 - shift, paint);
    }
}

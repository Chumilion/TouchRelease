package chumilion.touchrelease;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by 2016esison on 10/2/2015.
 */
public class MyLayout extends RelativeLayout
{
    private View myUp;
    public MyLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        myUp = null;
    }

    public View getUp()
    {
        return myUp;
    }
    public void setUp(View v)
    {
        myUp = v;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        if(ev.getAction() == MotionEvent.ACTION_UP)
        {
            myUp = under(ev);
        }
        return false;
    }

    public View under(MotionEvent ev)
    {
        Rect viewRect = new Rect();
        int[] loc = new int[2];
        int rx = (int) ev.getRawX();
        int ry = (int) ev.getRawY();
        for(int i = 0; i < ((ViewGroup) this).getChildCount(); i++)
        {
            View child = ((ViewGroup) this).getChildAt(i);
            child.getDrawingRect(viewRect);
            child.getLocationOnScreen(loc);
            viewRect.offset(loc[0], loc[1]);
            if(viewRect.contains(rx, ry))
                return child;
        }
        return null;
    }
}

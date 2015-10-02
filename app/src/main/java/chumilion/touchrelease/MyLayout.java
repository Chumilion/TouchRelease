package chumilion.touchrelease;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by 2016esison on 10/2/2015.
 */
public class MyLayout extends RelativeLayout
{
    public MyLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        if(ev.getAction() == MotionEvent.ACTION_UP)
        {
            for (int i = 0; i < getChildCount(); i++)
            {
                View child = getChildAt(i);
                child.dispatchTouchEvent(ev);
            }
            return true;
        }
        return false;
    }
}

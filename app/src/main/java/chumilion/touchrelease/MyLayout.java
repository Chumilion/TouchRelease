package chumilion.touchrelease;

import android.content.Context;
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
    public MyLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        if(ev.getAction() == MotionEvent.ACTION_DOWN)
        {
            for(int i = 0; i < ((ViewGroup) this).getChildCount(); i++)
            {
                MyTextView child = (MyTextView) ((ViewGroup) this).getChildAt(i);
                child.setPass(true);
                child.dispatchTouchEvent(ev);
                child.setPass(false);
            }
            return false;
        }
        //for(int i = 0; i < ((ViewGroup) this).getChildCount(); i++)
        //{
        //    MyTextView child = (MyTextView) ((ViewGroup) this).getChildAt(i);
        //    child.dispatchTouchEvent(ev);
        //}
        return false;
    }
}

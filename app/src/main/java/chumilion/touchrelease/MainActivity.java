package chumilion.touchrelease;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    private int press = 0;
    protected MyTextView[] textViews;
    protected ViewGroup layout;
    protected MyOnTouchListener listener;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mySP = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor mySPEditor = mySP.edit();


        textViews = new MyTextView[] {(MyTextView) findViewById(R.id.tl_textView),
                (MyTextView) findViewById(R.id.tr_textView),
                (MyTextView) findViewById(R.id.bl_textView),
                (MyTextView) findViewById(R.id.br_textView)};

        layout = (ViewGroup) findViewById(R.id.layout);
        listener = new MyOnTouchListener();
        //layout.setOnTouchListener(listener);

        for(int x = 0; x < textViews.length; x++)
        {
            final int y = x;
            final MyTextView[] textViewz = textViews;
            textViews[x].setOnTouchListener(listener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyOnTouchListener implements View.OnTouchListener
    {
        public boolean onTouch(View v, MotionEvent event)
        {
            if(event.getAction() == MotionEvent.ACTION_DOWN)
            {
                press = Arrays.asList(textViews).indexOf(v);
                Log.i("onCreate", "press: " + press);
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_CANCEL)
            {
                return false;
            }
            if(event.getAction() == MotionEvent.ACTION_UP)
            {
                press = Arrays.asList(textViews).indexOf(v);
                Log.i("release",press+"");
                //((MyTextView) v).incrementAndUpdate(press);

                return false;
            }
            return true;
        }
    }
}
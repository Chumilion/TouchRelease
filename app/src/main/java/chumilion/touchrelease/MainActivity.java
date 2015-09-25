package chumilion.touchrelease;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mySP = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor mySPEditor = mySP.edit();


        MyTextView[] textViews = {(MyTextView) findViewById(R.id.tl_textView),
                (MyTextView) findViewById(R.id.tr_textView),
                (MyTextView) findViewById(R.id.bl_textView),
                (MyTextView) findViewById(R.id.br_textView)};


        for(int x = 0; x < textViews.length; x++)
        {
            final int y = x;
            final MyTextView[] textViewz = textViews;
            textViews[x].setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v)
                {
                    textViewz[y].incrementAndUpdate();
                    String timez;
                    if(textViewz[y].getText()) == 1)
                        timez = " time.";
                    else
                        timez = " times.";
                    Toast.makeText(MainActivity.this, "Pressed " + textViewz[y].getText() + timez,
                            Toast.LENGTH_SHORT).show();
                    Log.i("onCreate", textViewz[y].getText() + " was pressed " +
                            textViewz[y].getText() + timez);
                    mySPEditor.putInt("textViews_" + y,
                            Integer.parseInt((String) textViewz[y].getText()));

                    mySPEditor.commit();
                }
            });
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
}
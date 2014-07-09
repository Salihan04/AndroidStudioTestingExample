package com.dashsell.androidtestingproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.dashsell.androidtestingproject.R;

public class MyActivity2 extends Activity {
    public static final String KEY_MESSAGE = "com.dashsell.androidtestingproject.MESSAGE";
    public static final String TAG = MyActivity2.class.getSimpleName();
    private TextView text;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_activity2);

        text = (TextView) findViewById(R.id.intent_text);

        if(getIntent().getStringExtra(KEY_MESSAGE)!=null){
            message = getIntent().getStringExtra(KEY_MESSAGE);
            Log.e(TAG,"The message was: "+message);
        }else{
            String e = "no message is given in the intent";
            Log.e(TAG,e);
            message = "";
            return;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        text.setText(message);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_MESSAGE, message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent makeIntent(Context context, String message){
        Intent intent = new Intent(context, MyActivity2.class);
        intent = intent.putExtra(KEY_MESSAGE,message);
        return intent;
    }
}

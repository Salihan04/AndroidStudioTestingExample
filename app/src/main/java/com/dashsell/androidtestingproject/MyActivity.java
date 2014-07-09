package com.dashsell.androidtestingproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


public class MyActivity extends Activity {
    public static final String TAG = MyActivity.class.getSimpleName();
    public static final String KEY = "state number key";
    public static final int INVALID_STATE_NUMBER = -1;
    private int stateNumber;

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.d(TAG,"onCreate");

        editText = (EditText) findViewById(R.id.editText);
        if(savedInstanceState!=null){
            stateNumber = savedInstanceState.getInt(KEY,INVALID_STATE_NUMBER);

        }else {
            stateNumber = 0;
        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MyActivity2.makeIntent(getApplicationContext(), null);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
//        stateNumber = 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        editText.setText(String.valueOf(stateNumber));
//        stateNumber = 2;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
        stateNumber = Integer.valueOf(editText.getEditableText().toString());
//        stateNumber = 3;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
//        stateNumber = 4;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
//        stateNumber = 5;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
//        stateNumber = 6;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState");
        outState.putInt(KEY, stateNumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,"onRestoreInstanceState");
        stateNumber = savedInstanceState.getInt(KEY,INVALID_STATE_NUMBER);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public int getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(int stateNumber) {
        this.stateNumber = stateNumber;
    }
}

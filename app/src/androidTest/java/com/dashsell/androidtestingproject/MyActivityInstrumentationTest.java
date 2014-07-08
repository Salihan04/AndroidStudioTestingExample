package com.dashsell.androidtestingproject;

import android.app.Instrumentation;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

/**
 * Created by dashsell on 7/7/14.
 * This is an android instrumentation test
 * It required a real device or an emulated device to run the test
 */
public class MyActivityInstrumentationTest extends ActivityInstrumentationTestCase2<MyActivity> {

    //you can do alot of things with Solo
    //check the following tutorial
    //https://code.google.com/p/robotium/wiki/RobotiumTutorials
    private Solo solo;

    public MyActivityInstrumentationTest(){
        super(MyActivity.class);
    }

    //in Android Studio,
    //you can write this using short hand method
    //using ctrl+N
    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        setActivityInitialTouchMode(false);
    }


    public void testString() throws Exception {

        TextView textView = (TextView) solo.getView(R.id.hello_world);
        String text = textView.getText().toString();

        assertEquals("They are not equal","Hello world!",text);
    }

    /**
     * this test will fail
     * @throws Exception
     */
    public void testSaveState() throws Exception {
        MyActivity activity = getActivity();

        //set the edit text box to 1
        EditText editText = solo.getEditText(0);
        solo.clearEditText(editText);
        solo.enterText(editText, "1");

        int restoreStateNumber;

        Log.d("TEST","stateNumber: " + 1);

        //restart the activity
        activity.finish();
        setActivity(null);
        activity = this.getActivity();

        //check whether the state is being save
        restoreStateNumber = activity.getStateNumber();

        Log.d("TEST","restoreStateNumber: " + restoreStateNumber);

        //test
        assertEquals("The state is not saved",1,restoreStateNumber);
    }

    /**
     * this test will pass
     * @throws Exception
     */
    public void testStatePause() throws Exception{
        Instrumentation instrumentation = getInstrumentation();
        MyActivity activity = getActivity();

        //set the edit text box to 1
        EditText editText = solo.getEditText(0);
        solo.clearEditText(editText);
        solo.enterText(editText, "1");

        //change the orientation
        solo.setActivityOrientation(Solo.LANDSCAPE);
        solo.setActivityOrientation(Solo.PORTRAIT);

        //test
        assertEquals("The state is not saved", 1, activity.getStateNumber());

    }
}

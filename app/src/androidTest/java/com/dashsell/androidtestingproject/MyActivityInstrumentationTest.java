package com.dashsell.androidtestingproject;

import android.test.ActivityInstrumentationTestCase2;
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
    }


    public void testString() throws Exception {

        TextView textView = (TextView) solo.getView(R.id.hello_world);
        String text = textView.getText().toString();

        assertEquals("They are not equal","Hello World!",text);
    }


}

package com.dashsell.androidtestingproject;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

import org.mockito.MockitoAnnotations;

import java.util.Objects;

/**
 * Created by dashsell on 9/7/14.
 */
public class MyActivity2InstrumentationTest extends ActivityInstrumentationTestCase2<MyActivity2> {
    public static final String TAG = MyActivity2InstrumentationTest.class.getSimpleName();

    public MyActivity2InstrumentationTest() {
        super(MyActivity2.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
    }

    public void testIntent1() throws Exception {
        try {
            Intent intent = MyActivity2.makeIntent(getInstrumentation().getContext(), "Hello world");
            setActivityIntent(intent);

            MyActivity2 activity2 = getActivity();
            Instrumentation instrumentation = getInstrumentation();
            Solo solo = new Solo(instrumentation, activity2);

            assertNotNull("Activity is null", activity2);
            TextView message = solo.getText(1);

            assertEquals("Hello world", message.getText().toString());

            activity2.finish();
            setActivity(null);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    public void testIntent2() throws Exception {
        Intent intent = MyActivity2.makeIntent(getInstrumentation().getContext(), null);
        setActivityIntent(intent);

        MyActivity2 activity2 = getActivity();
        Instrumentation instrumentation = getInstrumentation();
        Solo solo = new Solo(instrumentation, activity2);

        assertNotNull("Activity is not null", activity2);
        TextView message = solo.getText(1);

        assertEquals("",message.getText().toString());

        activity2.finish();
        setActivity(null);
    }

    public void testIntent3() throws Exception {
        try {
            Intent intent = MyActivity2.makeIntent(getInstrumentation().getContext(), "");
            setActivityIntent(intent);

            MyActivity2 activity2 = getActivity();
            Instrumentation instrumentation = getInstrumentation();
            Solo solo = new Solo(instrumentation, activity2);

            assertNotNull("Activity is null", activity2);
            TextView message = solo.getText(1);

            assertEquals("",message.getText().toString());

            activity2.finish();
            setActivity(null);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }
}

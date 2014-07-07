package com.dashsell.androidtestingproject;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

/**
 * Created by dashsell on 7/7/14.
 */
public class SimpleUnitTesting extends TestCase {
    public SimpleUnitTesting() {
    }

    @SmallTest
    public void testSimpleAddition() throws Exception {
        assertEquals(0,1-1);
    }

    @SmallTest
    public void testFail() throws Exception {
        fail("Im fail");
    }
}

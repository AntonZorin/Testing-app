package com.az.testing.ui.activity;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.lifecycle.ActivityLifecycleCallback;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;
import android.view.ViewGroup;

import com.az.testing.BaseTest;
import com.az.testing.R;
import com.az.testing.network.request.LoginRequest;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by zorin.a on 02.11.2017.
 */

public class MainActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Override
    public void setUp() throws Exception {
        super.setUp();
        ActivityLifecycleMonitorRegistry.getInstance().addLifecycleCallback(new ActivityLifecycleCallback() {
            @Override
            public void onActivityLifecycleChanged(Activity activity, Stage stage) {
                Log.v(MainActivity.class.getSimpleName(), "stage name: " + stage.name());
            }
        });

    }

    @Test
    public void checkFragmentContainerExists() {
        ViewGroup container = rule.getActivity().findViewById(R.id.container);
        assertNotNull(container);
    }

    @Test
    public void assertContextNotNull() {
        assertEquals("com.az.testing", context.getPackageName());
        assertNotNull(context);
    }

    @Test
    public void assertLoginNotNull() {
        LoginRequest request = new LoginRequest();
        request.setLogin("Ivanov");
        request.setPassword("3as24sd2");

        apiService.login(request).subscribe(result -> {
            assertNotNull(result.getToken());
            assertTrue(!result.getToken().isEmpty());
            if (!result.getToken().isEmpty()) {
                prefManager.seveToken(result.getToken());
            }
        });
    }


    @After
    public void tearDown() throws Exception {
    }

}
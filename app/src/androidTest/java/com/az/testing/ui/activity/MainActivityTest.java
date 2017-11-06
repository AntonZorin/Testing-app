package com.az.testing.ui.activity;

import android.support.test.rule.ActivityTestRule;
import android.view.ViewGroup;

import com.az.testing.BaseTest;
import com.az.testing.R;
import com.az.testing.network.request.LoginRequest;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

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
    }

    @Test
    public void checkFragmentContainerExists() {
        ViewGroup container = rule.getActivity().findViewById(R.id.container);
        assertNotNull(container);
    }

    @Test
    public void assertContextNotNull() {
        assertNotNull(context);
    }

    @Test
    public void assertloginNotNull() {
        LoginRequest request = new LoginRequest();
        request.setLogin("Ivanov");
        request.setPassword("3as24sd2");
        apiService.login(request).subscribe(result -> {
            assertNotNull("TokenTest", result.getToken());
        });
    }

    @After
    public void tearDown() throws Exception {
    }

}
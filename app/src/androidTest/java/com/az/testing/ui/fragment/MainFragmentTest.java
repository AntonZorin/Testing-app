package com.az.testing.ui.fragment;

import com.az.testing.BaseTest;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by zorin.a on 02.11.2017.
 */
public class MainFragmentTest extends BaseTest {

    @Test
    public void assertUserExists() {
        apiService.getUser(prefManager.getToken(), 0).subscribe(user -> {
            assertNotNull(user);
        });
    }

    @Test
    public void assertCarsExists() {
        apiService.getCars(prefManager.getToken(), 0, 100, 0).subscribe(cars -> {
            assertNotNull(cars.getCars());
        });
    }

    @Test
    public void assertCarsListNotEmpty() {
        apiService.getCars(prefManager.getToken(), 0, 100, 0).subscribe(cars -> {
            assertTrue(cars.getCars().size() > 0);
            assertTrue(cars.getCars().get(0).getImage() instanceof String);
        });
    }
}
package com.az.testing.ui.fragment;

import com.az.testing.BaseTest;
import com.az.testing.mvp.model.Car;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by zorin.a on 02.11.2017.
 */
public class MainFragmentTest extends BaseTest {

    @Test
    public void assertUserExists() {
        apiService.getUser(prefManager.getToken(), 0).subscribe(response -> {
            assertNotNull(response);
            assertThat(response.getUser().getId(), is(Integer.class));
            assertThat(response.getUser().getName(), is(String.class));
            assertThat(response.getUser().getAge(), is(Integer.class));
            assertTrue(!response.getUser().getName().isEmpty());
        });
    }

    @Test
    public void assertCarsExists() {
        apiService.getCars(prefManager.getToken(), 0, 100, 0).subscribe(response -> {
            assertNotNull(response.getCars());
        });
    }

    @Test
    public void assertCarsListNotEmpty() {
        apiService.getCars(prefManager.getToken(), 0, 100, 0).subscribe(response -> {
            List<Car> cars = response.getCars();
            assertTrue(cars.size() > 0);
            assertTrue(cars.get(0).getImage() instanceof String);
        });
    }
}
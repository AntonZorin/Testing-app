package com.az.testing.injection.module;

import com.az.testing.injection.scopes.FragmentScope;
import com.az.testing.ui.fragment.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by zorin.a on 01.11.2017.
 */

@Module
public interface ActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = FragmentModule.class)
    MainFragment mainFragmentInjector();
}

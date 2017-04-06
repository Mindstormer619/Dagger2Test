package me.darthsid.dagger2test;

import android.widget.ArrayAdapter;

import javax.inject.Named;

import dagger.Subcomponent;

/**
 * Created by darthsid on 5/4/17.
 */


@MainActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivitySubcomponent {

    @Named("exampleList")
    ArrayAdapter<String> mainArrayAdapter();

    void inject(MainActivity mainActivity);
}

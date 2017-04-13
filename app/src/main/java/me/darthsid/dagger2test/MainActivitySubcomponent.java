package me.darthsid.dagger2test;

import dagger.Subcomponent;

/**
 * Created by darthsid on 5/4/17.
 */


@ActivityScope
@Subcomponent(modules = {MainActivityModule.class, PerActivityModule.class})
public interface MainActivitySubcomponent {
    void inject(MainActivity mainActivity);
}

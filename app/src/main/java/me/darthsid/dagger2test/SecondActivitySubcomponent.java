package me.darthsid.dagger2test;

import dagger.Subcomponent;

/**
 * Created by darthsid on 14/4/17.
 */

@ActivityScope
@Subcomponent(modules = {PerActivityModule.class})
public interface SecondActivitySubcomponent {
    void inject(SecondScreen s);
}

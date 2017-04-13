package me.darthsid.dagger2test;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darthsid on 14/4/17.
 */

@Module
public class PerActivityModule {
    @Provides @ActivityScope
    Adder providesAdder() {
        return new Adder();
    }
}

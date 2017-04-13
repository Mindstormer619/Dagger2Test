package me.darthsid.dagger2test;

import android.app.Application;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darthsid on 1/4/17.
 */

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides @Singleton
    Random providesRandom() {
        return new Random();
    }

    @Provides @Singleton
    Multiplier providesMultiplier() {
        return new Multiplier();
    }
}

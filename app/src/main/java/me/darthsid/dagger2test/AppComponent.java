package me.darthsid.dagger2test;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by darthsid on 1/4/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    MainActivitySubcomponent newMainActivitySubcomponent(MainActivityModule m);
    SecondActivitySubcomponent newSecondActivitySubcomponent(PerActivityModule m);
}

package me.darthsid.dagger2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class SecondScreen extends AppCompatActivity {

    @Inject
    Adder adder;

    @Inject Multiplier multiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        ((MyApp) getApplication())
                .getAppComponent()
                .newSecondActivitySubcomponent(new PerActivityModule())
                .inject(this);

        Log.d("Dagger2Test", "Single Multiplier: SecondScreen: " + multiplier.hashCode());
        Log.d("Dagger2Test", "PerActivity Adder: SecondScreen: " + adder.hashCode());
    }


}

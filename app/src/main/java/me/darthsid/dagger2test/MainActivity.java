package me.darthsid.dagger2test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences preferences;

    @Inject
    Random rnd;

    @Inject @Named("exampleList")
    ArrayAdapter<String> adapter;

    @Inject
    Multiplier multiplier;

    @Inject Adder adder;

    @Inject @Named("mainActivityListView")
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) getApplication())
                .getAppComponent()
                .newMainActivitySubcomponent(new MainActivityModule(this))
                .inject(this);

        Log.d("Dagger2Test", "Single Multiplier: MainActivity: " + multiplier.hashCode());
        Log.d("Dagger2Test", "PerActivity Adder: MainActivity: " + adder.hashCode());

        setList();
        populateList();
    }

    private void setList() {
        listView.setAdapter(adapter);
    }

    private void populateList() {
        adapter.addAll("Hello", "Is it", "Me", "You're Looking", "For");
    }


    public void randomizeSavedText(View view) {
        String s = getRandomString();
        preferences.edit().putString("R_STRING", s).apply();
    }

    public void updateTextBox(View view) {
        String s = preferences.getString("R_STRING", "Placeholder");

        double result = multiplier.multiply(5, 6);
        ((TextView) findViewById(R.id.sharedPrefDisplay)).setText(s + " " + result);
    }

    private String getRandomString() {
        final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomStringBuilder = new StringBuilder();
        while (randomStringBuilder.length() < 18) {
            int index = (int) (rnd.nextFloat() * ALLOWED_CHARS.length());
            randomStringBuilder.append(ALLOWED_CHARS.charAt(index));
        }

        return randomStringBuilder.toString();
    }

    public void gotoSecondScreen(View view) {
        Intent intent = new Intent(this, SecondScreen.class);
        startActivity(intent);
    }
}

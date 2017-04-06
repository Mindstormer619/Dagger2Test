package me.darthsid.dagger2test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Inject @Named("mainActivityListView")
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) getApplication())
                .getNetComponent()
                .newMainActivitySubcomponent(new MainActivityModule(this))
                .inject(this);

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
        ((TextView) findViewById(R.id.sharedPrefDisplay)).setText(s);
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
}

package me.darthsid.dagger2test;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by darthsid on 5/4/17.
 */

@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides @ActivityScope @Named("exampleList")
    public ArrayAdapter<String> providesMainAdapter() {
        return new ArrayAdapter<>(mainActivity, android.R.layout.simple_list_item_1);
    }

    @Provides @ActivityScope @Named("mainActivityListView")
    public ListView providesListView() {
        return (ListView) mainActivity.findViewById(R.id.listView);
    }
}

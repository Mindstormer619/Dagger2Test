package me.darthsid.dagger2test;

import android.app.Application;

/**
 * Created by darthsid on 1/4/17.
 */

public class MyApp extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}

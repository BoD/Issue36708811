package org.jraf.android.issue36708811;

import android.os.Handler;
import android.os.StrictMode;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupStrictMode();
    }

    private void setupStrictMode() {
        // Do this in a Handler.post because of this issue: http://code.google.com/p/android/issues/detail?id=35298
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
            }
        });
    }
}

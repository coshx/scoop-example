package com.coshx.scoopexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.coshx.scoopexample.routers.AppRouter;
import com.coshx.scoopexample.screens.PistachioScreen;
import com.lyft.scoop.Scoop;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private Scoop rootScoop;

    @Inject
    AppRouter appRouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScoopExampleApplication.getApplicationComponent().inject(this);

        setContentView(R.layout.activity_main);

        // Create scoops
        rootScoop = new Scoop.Builder("root").build();
        // Declare R.id.main_layout on the root layout into activity_main
        rootScoop.inflate(R.layout.root, (ViewGroup) findViewById(R.id.main_layout), true);

        // First screen to load
        if (!appRouter.hasActiveScreen()) {
            appRouter.goTo(new PistachioScreen());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        rootScoop.destroy(); // Good practice
    }

    @Override
    public void onBackPressed() {
        if (!appRouter.goBack()) {
            // No more element in history, end the app
            finish();
        }
    }
}

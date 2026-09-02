/*
 * WelcomeActivity.java is part of Zahin ar YouTube (PipePipe fork).
 *
 * Shows a first-launch welcome screen exactly once. Once the user taps
 * "Get Started", a persistent SharedPreferences flag is set and this
 * screen is never shown again unless app data is cleared or the app
 * is reinstalled. It is intentionally independent of the existing
 * "isFirstRun" flag used elsewhere for the update-checker dialog, so
 * that flow is left completely untouched.
 */

package org.schabi.newpipe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class WelcomeActivity extends AppCompatActivity {

    private static final String PREF_WELCOME_SHOWN = "welcome_screen_shown_once";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs =
                PreferenceManager.getDefaultSharedPreferences(this);

        if (prefs.getBoolean(PREF_WELCOME_SHOWN, false)) {
            // Already shown once, ever. Skip straight to MainActivity.
            goToMainActivity();
            return;
        }

        setContentView(R.layout.activity_welcome);

        findViewById(R.id.welcomeGetStartedButton).setOnClickListener(v -> {
            prefs.edit().putBoolean(PREF_WELCOME_SHOWN, true).apply();
            goToMainActivity();
        });
    }

    private void goToMainActivity() {
        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

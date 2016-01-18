package fr.epitez.android_tutorial;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static boolean is_full_screen = false;
    static Button notre_bouton;
    static String message_vers_plein_ecran;
    static String message_sortir_du_plein_ecran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notre_bouton = (Button)findViewById(R.id.button);
        Resources res = getResources();
        message_vers_plein_ecran = res.getString(R.string.full_screen);
        message_sortir_du_plein_ecran = res.getString(R.string.not_full_screen);
        is_full_screen = (getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) != 0;
    }

    public void onClick(View view) {
        if(is_full_screen) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            notre_bouton.setText(message_vers_plein_ecran);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            notre_bouton.setText(message_sortir_du_plein_ecran);
        }
        is_full_screen = !is_full_screen;
    }
}

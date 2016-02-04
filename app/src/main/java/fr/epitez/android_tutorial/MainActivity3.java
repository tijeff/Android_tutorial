package fr.epitez.android_tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends Activity {

    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        Log.i("EPITEZ", "Create activity 3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button but_prev = (Button) findViewById(R.id.Button04);
        but_prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent();
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}
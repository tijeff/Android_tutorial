package fr.epitez.android_tutorial;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    private String[] androidVersion = { "Cupcake", "Donut", "Eclair", "Froyo", "GingerBread", "Honycom", "Ice Cream Sandwish", "Jelly Bean", "Kitkat" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.androidVersion);
        this.setListAdapter(adapter);
    }
}

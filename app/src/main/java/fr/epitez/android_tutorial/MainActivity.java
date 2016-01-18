package fr.epitez.android_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private WebView la_webview;
    private EditText l_url;

    private void loadUrl() {
        if(la_webview != null && l_url != null) {
            la_webview.setWebViewClient(new WebViewClient());
            la_webview.loadUrl(l_url.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        la_webview = (WebView)findViewById(R.id.webView);
        l_url = (EditText)findViewById(R.id.l_url);

        loadUrl();

    }

    public void onClick(View v) {
        loadUrl();
    }
}

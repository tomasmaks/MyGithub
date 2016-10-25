package my.github.tomas.mygithub.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import my.github.tomas.mygithub.R;

/**
 * Created by Tomas on 24/10/2016.
 */

public class RepositoryWebviewActivity extends AppCompatActivity {

    private WebView mWebViewCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_webview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String mUrl = intent.getStringExtra(RepositoryActivity.CODE_URL);

        mWebViewCode = (WebView) findViewById(R.id.webViewRepositoryCode);
        mWebViewCode.loadUrl(mUrl);
    }
}

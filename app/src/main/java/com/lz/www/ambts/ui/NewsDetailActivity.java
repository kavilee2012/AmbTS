package com.lz.www.ambts.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lz.www.ambts.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Administrator on 2016/5/28.
 */
public class NewsDetailActivity extends AppCompatActivity {
    @InjectView(R.id.wvNews)
    WebView webView;
    @InjectView(R.id.myTool)
    Toolbar toolbar;

    String url,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        ButterKnife.inject(this);

        Intent it=getIntent();
        url = it.getStringExtra("url");
        title=it.getStringExtra("title");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new MyWebViewClient());

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(R.drawable.left2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView.canGoBack())
                    webView.goBack();
                else
                    finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_newsinfo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuShare:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            case R.id.menuOpenLink:
                //浏览器中打开网页
                Intent intent=new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri uri= Uri.parse(url);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
        return true;
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}

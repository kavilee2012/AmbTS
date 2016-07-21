package com.lz.www.ambts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.lz.www.ambts.R;


/**
 * Created by Administrator on 2016/5/28.
 */
public class NewsDetailActivity extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);

        webView=(WebView)findViewById(R.id.wvNews);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.simchn.com/");
        webView.setWebViewClient(new MyWebViewClient());

        TextView tvTitle=(TextView)findViewById(R.id.tvTitle);
        tvTitle.setText("新闻详细");

        Button btnBack=(Button)findViewById(R.id.btnGoBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView.canGoBack())
                    webView.goBack();
                else
                    finish();
            }
        });

        Button btnAhead=(Button)findViewById(R.id.btnForward);
        btnAhead.setVisibility(View.VISIBLE);
        btnAhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goForward();
            }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack()){
//            webView.goBack();
//            return true;
//        }
//        return false;
//    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}

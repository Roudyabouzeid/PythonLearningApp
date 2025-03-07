package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Lesson_Quiz extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_quiz);

        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        if(intent != null){
            webView.getSettings().setJavaScriptEnabled(true);

            String url = intent.getStringExtra("url");

            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient()
            );
        }
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else
            super.onBackPressed();
    }

}
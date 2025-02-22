package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Lesson8 extends AppCompatActivity {
    private WebView webView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8);
        webView = findViewById(R.id.webView);
        button = findViewById(R.id.button);

        System.out.println("Reached");
        Intent intent = getIntent();
        if(intent != null){
            webView.getSettings().setJavaScriptEnabled(true);
            String url = intent.getStringExtra("url8");
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson8.this, Lesson8_Quiz.class);
                intent.putExtra("url", "https://realpython.com/quizzes/python-lambda/");

                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else
            super.onBackPressed();
    }


}
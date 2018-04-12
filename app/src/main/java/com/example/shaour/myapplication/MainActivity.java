package com.example.shaour.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    public EditText URL;
    public ToggleButton Connect1;
    public ProgressBar progressBar;
    public WebView webView;
    String welcomeToast = "Welcome to my Assignment";
    String loadingToast = "Loading....";
    String loadedToast = "Loaded!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.web1);
        webView.getSettings().setJavaScriptEnabled(true);
        progressBar=(ProgressBar)findViewById(R.id.prg);
        Toast.makeText(getApplicationContext(),welcomeToast,Toast.LENGTH_LONG).show();

        URL=(EditText)findViewById(R.id.Text1);
        Connect1=(ToggleButton)findViewById(R.id.toggleButton);


        Connect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection(URL.getText().toString());
            }
        });

    }
    public void connection(String urlid){
        WebView web=(WebView)findViewById(R.id.web1);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),loadingToast,Toast.LENGTH_SHORT).show();
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),loadedToast,Toast.LENGTH_SHORT).show();
                setTitle(view.getTitle());
            }

        });
        web.loadUrl(urlid);
    }



}

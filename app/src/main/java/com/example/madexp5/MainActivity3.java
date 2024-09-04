package com.example.madexp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        EditText url = findViewById(R.id.et1);
        Button loadButton = findViewById(R.id.bt1);
        Button backButton = findViewById(R.id.bt2);
        WebView webView = findViewById(R.id.wb1);
        webView.setWebViewClient(new WebViewClient());
        loadButton.setOnClickListener(v -> validateAndLoadUrl());
        backButton.setOnClickListener(v -> goBack());
    }

    public void validateAndLoadUrl() {
        EditText url = findViewById(R.id.et1);
        WebView webView = findViewById(R.id.wb1);
        String urlText = url.getText().toString().trim();

        if (urlText.isEmpty()) {
            showAlert("Please enter a website URL.");
        } else {
            webView.loadUrl(urlText);
        }
    }

    public void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
    private void goBack() {
        Intent intent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }
}

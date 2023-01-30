package com.example.openpyokopyoko;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean initFlg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (!initFlg) {
            return;
        }
        initFlg = false;

        String url = "http://pyokopyoko.php.xdomain.jp/twitter/";

        // クリップボードの中身取得
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String clipData = "";
        if (clipboard.hasPrimaryClip()) {
            clipData = "?url=" + clipboard.getPrimaryClip().getItemAt(0).getText().toString();
        }

        // ツイッターコピペツールをブラウザで開く
        Uri uri = Uri.parse(url + clipData);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
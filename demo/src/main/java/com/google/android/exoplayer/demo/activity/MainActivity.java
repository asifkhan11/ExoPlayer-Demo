package com.google.android.exoplayer.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.exoplayer.demo.R;
import com.google.android.exoplayer.util.Util;

/**
 * An activity for selecting from a number of samples.
 */
public class MainActivity extends Activity {
    EditText editText_url;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        editText_url = (EditText) findViewById(R.id.editText_url);
        button = (Button) findViewById(R.id.play);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class)
                        .setData(Uri.parse(editText_url.getText().toString()))
                        .putExtra(PlayerActivity.CONTENT_ID_EXTRA, "Live Streaming")
                        .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, Util.TYPE_HLS);
                startActivity(intent);
            }
        });
    }
}

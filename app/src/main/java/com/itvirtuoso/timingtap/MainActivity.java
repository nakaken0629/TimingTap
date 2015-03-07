package com.itvirtuoso.timingtap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView mDebugText;
    private SoundPool mPool;
    private int mkaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View root = findViewById(R.id.root_layout);
        root.setOnTouchListener(new RootTouch());
        mDebugText = (TextView) findViewById(R.id.debug_text);

        mPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mkaId = mPool.load(this, R.raw.ka, 1);
    }

    private class RootTouch implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            mDebugText.setText(Long.toString(System.currentTimeMillis()));
            mPool.play(mkaId, 1, 1, 0, 0, 1);
            return false;
        }
    }
}

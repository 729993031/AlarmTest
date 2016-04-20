package com.example.AlarmTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/4/20.
 */
public class AlarmActivity extends Activity {
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mediaPlayer=MediaPlayer.create(this,R.raw.alarm);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        new AlertDialog.Builder(AlarmActivity.this).setTitle("闹钟").setMessage("闹钟响了，GO！GO!GO!")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mediaPlayer.stop();
                        AlarmActivity.this.finish();
                    }
                }).show();
    }
}

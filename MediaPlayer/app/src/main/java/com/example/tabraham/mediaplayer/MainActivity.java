package com.example.tabraham.mediaplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mPlayButton;
    Button mPauseButton;
    Button mStopButton;
    Button mSeekButton;
    Button mPositionButton;
    Button mDurationButton;
    SeekBar mSeekBar;
    MediaPlayer mp;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayButton = (Button) findViewById(R.id.buttonPlay);
        mPauseButton = (Button) findViewById(R.id.buttonPause);
        mStopButton = (Button) findViewById(R.id.buttonStop);
        mSeekButton = (Button) findViewById(R.id.buttonSeek);
        mPositionButton = (Button) findViewById(R.id.buttonPosition);
        mDurationButton = (Button) findViewById(R.id.buttonDuration);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mHandler = new Handler();

        System.out.println("TA-> all inited");
        //mp = MediaPlayer.create(this, R.raw.q01);//for raw
        //mSeekBar.setMax(mp.getDuration()/1000);
        mp = new MediaPlayer();
        System.out.println("TA-> all inited");

        initializeAudioPlayer();

        mPlayButton.setOnClickListener(this);
        mPauseButton.setOnClickListener(this);

        mStopButton.setOnClickListener(this);

        mSeekButton.setOnClickListener(this);

        mPositionButton.setOnClickListener(this);

        mDurationButton.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mp.seekTo(progress * 1000);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mSeekBar.setProgress(0);
            }
        });

    }

    void prepareAudio() {
        try {
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                System.out.println("TA-> Audio prepared");
                mSeekBar.setMax(mp.getDuration() / 1000);

            }
        });
    }


    public void initializeAudioPlayer() {
        System.out.println("TA->  initializeAudioPlayer");

        mp.reset();
        try {
            mp.setDataSource("/data/data/com.example.tabraham.mediaplayer/q01.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        prepareAudio();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                if (!mp.isPlaying()) {
                    System.out.println("Playing");
                    mp.start();


                    mHandler.postDelayed(mediaPlayerThread, 100);
                    //mPlayButton.setEnabled(false);
                }
                break;
            case R.id.buttonPause:
                if (mp.isPlaying()) {
                    System.out.println("Pause");
                    mp.pause();
                }
                break;
            case R.id.buttonStop:
                System.out.println("Stop");
                mp.stop();
                //prepareAudio();
                break;
            case R.id.buttonPosition:
                System.out.println("Position" + mp.getCurrentPosition());
                break;
            case R.id.buttonSeek:
                System.out.println("Seeking" + 200000);
                mp.seekTo(200000);
                break;
            case R.id.buttonDuration:
                System.out.println("Duration : " + mp.getDuration());
                break;

        }
    }

    Runnable mediaPlayerThread = new Runnable() {
        @Override
        public void run() {
            mSeekBar.setProgress(mp.getCurrentPosition() / 1000);
            mHandler.postDelayed(this, 100);

        }
    };
}

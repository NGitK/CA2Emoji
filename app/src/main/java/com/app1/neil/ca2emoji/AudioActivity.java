package com.app1.neil.ca2emoji;

        import android.media.MediaPlayer;
        import android.media.MediaRecorder;
        import android.os.Bundle;
        import android.os.Environment;
        import android.app.Activity;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;


public class AudioActivity extends Activity {

    MediaRecorder myRecorder;
    MediaPlayer myPlayer;
    String outputFile = null;
    Button startBtn;
    Button stopBtn;
    Button playBtn;
    Button stopPlayBtn;
    TextView tv1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_voice);


        tv1 = (TextView) findViewById(R.id.record_yourself_textView);
        // store it to sd card
        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/MyNewAudioRecording.3gpp";

        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);

        startBtn = (Button) findViewById(R.id.button_record_now);
        startBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                start(v);
            }
        });

        stopBtn = (Button) findViewById(R.id.button_stop_record);
        stopBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                stop(v);

            }
        });

        playBtn = (Button) findViewById(R.id.button_play_now);
        playBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                play(v);
            }
        });

        stopPlayBtn = (Button) findViewById(R.id.button_stop_play);
        stopPlayBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                stopPlay(v);
            }
        });
    }

    public void start(View view) {
        myRecorder.start();


        tv1.setText("Recording Point: Recording");
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Start recording...",
                Toast.LENGTH_SHORT).show();
    }

    public void stop(View view){
            myRecorder.stop();
            myRecorder.release();
            myRecorder = null;
            stopBtn.setEnabled(false);
            playBtn.setEnabled(true);
            tv1.setText("Recording Point: Stop recording");

            Toast.makeText(getApplicationContext(), "Stop recording...",
                    Toast.LENGTH_SHORT).show();

    }

    public void play(View view) {

            myPlayer = new MediaPlayer();
            myPlayer.start();
            playBtn.setEnabled(false);
            stopPlayBtn.setEnabled(true);
            tv1.setText("Recording Point: Playing");
            Toast.makeText(getApplicationContext(), "Start play the recording...",
                    Toast.LENGTH_SHORT).show();

    }

    public void stopPlay(View view) {
            if (myPlayer != null) {

                myPlayer.stop();
                myPlayer.release();
                myPlayer = null;
                playBtn.setEnabled(true);
                stopPlayBtn.setEnabled(false);
                tv1.setText("Recording Point: Stop playing");

                Toast.makeText(getApplicationContext(), "Stop playing the recording...",

                        Toast.LENGTH_SHORT).show();
            }



        }

    }



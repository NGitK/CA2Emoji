package com.app1.neil.ca2emoji;

        import android.content.pm.PackageManager;
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

        import java.io.File;
        import java.io.IOException;


public class AudioActivity extends Activity {
    protected boolean hasMicrophone() {
        PackageManager pmanager = this.getPackageManager();
        return pmanager.hasSystemFeature(
                PackageManager.FEATURE_MICROPHONE);
    }


    MediaRecorder myRecorder;
    MediaPlayer myPlayer;
    String outputFile = null;
    Button startBtn, stopBtn, playBtn, stopPlayBtn;
    private boolean isRecording = false;
    TextView tv1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_record_voice);


        tv1 = (TextView) findViewById(R.id.record_yourself_textView);
        // store it to sd card


       // File mediaStorageDir = new File(Environment.getExternalStorageDirectory() + File.separator
              //  + Environment.DIRECTORY_DCIM + File.separator + "FILE_NAME");

        startBtn = (Button) findViewById(R.id.button_record_now);
        stopBtn = (Button) findViewById(R.id.button_stop_record);
        playBtn = (Button) findViewById(R.id.button_play_now);

       // startBtn.setEnabled(false);
        //stopBtn.setEnabled(false);
       // playBtn.setEnabled(false);
       // stopPlayBtn.setEnabled(false);


        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);
        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/MyNewAudioRecording.3gpp";

    }

    public void startRecord(View view) throws IOException{
        isRecording = true;
        try {
            myRecorder.prepare();
            myRecorder.start();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);
        Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
        myRecorder.stop();
    }


    public void stopRecord(View view){

            myRecorder.stop();
            myRecorder.reset();
            myRecorder.release();
           // myRecorder = null;
            stopBtn.setEnabled(true);
            playBtn.setEnabled(true);

            Toast.makeText(getApplicationContext(), "Stop recording...",
                    Toast.LENGTH_SHORT).show();

    }

    public void onPlayClick(View view) {

            myPlayer = new MediaPlayer();
            myPlayer.start();
            playBtn.setEnabled(false);
            stopPlayBtn.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Start play the recording...",
                    Toast.LENGTH_SHORT).show();

    }

    public void onStopClick(View view) {
            if (myPlayer != null) {

                myPlayer.stop();
                myPlayer.release();
                myPlayer = null;
                playBtn.setEnabled(true);
                stopPlayBtn.setEnabled(false);

                Toast.makeText(getApplicationContext(), "Stop playing the recording...",

                        Toast.LENGTH_SHORT).show();
            }



        }

    }



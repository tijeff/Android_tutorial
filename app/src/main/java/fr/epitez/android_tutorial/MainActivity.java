package fr.epitez.android_tutorial;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgress;
    private Button mButton;
    private int progressValue = 0;
    private ThreadProgress mThreadProgress;
    private boolean isStarted = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar)findViewById(R.id.theProgressBar);
        mButton = (Button)findViewById(R.id.theButton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressValue = 0;

    }

    private void startThread() {
        progressValue = 0;
        mButton.setText("Stop");
        mProgress.setProgress(progressValue);
        mThreadProgress = new ThreadProgress();
        mThreadProgress.start();
        // mProgress.setVisibility(View.VISIBLE);
    }

    private void stopThread() {
        mThreadProgress.interrupt();
        // mProgress.setVisibility(View.GONE);
        mButton.setText("Start");
    }

    public void onClick(View v) {
        if(isStarted){
            startThread();
        } else {
            stopThread();
        }
        isStarted = !isStarted;
    }

    Handler handler = new Handler(new Callback() {

        @Override
        public boolean handleMessage(final Message msg) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Log.d("EPITEZ","run " + msg.arg1);
                    mProgress.setProgress(msg.arg1);
                    if(msg.arg1 == 15) {
                        mButton.setText("Start");
                    }
                }
            });
            return false;
        }
    });



    public class ThreadProgress extends Thread implements Runnable {
        @Override
        public void run() {
            while(progressValue <= 15) {
                try {
                    Log.d("unicorn", "in while loop");
                    progressValue++;
                    Message message = new Message();
                    message.arg1 = progressValue;
                    handler.sendMessage(message);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}

package bit.batch1234.widgetstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //circular and horizontal progressbar
    ProgressBar progressBar1, progressBar2;

    //Seekbar normal and discrete
    SeekBar seekBar1, seekBar2;

    TextView tvProgressStatus, tvSeekbarValue;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);

        tvProgressStatus = findViewById(R.id.tvProgressStatus);
        tvSeekbarValue = findViewById(R.id.tvSeekbarValue);


        //progressb

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                progressBar2.setProgress(progress);
                if (progressBar2.getProgress() >= progressBar2.getMax()) {
                    tvProgressStatus.setText("Task Complete..");
                    progressBar1.setVisibility(View.INVISIBLE);
                }
                progress = progress + 1;
            }
        }, 1000, 500);




        //seekbar
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekbarValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekbarValue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

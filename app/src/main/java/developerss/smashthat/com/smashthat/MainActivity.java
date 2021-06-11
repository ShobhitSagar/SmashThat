package developerss.smashthat.com.smashthat;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button ClickBtn;
    TextView scoreTv;
    Random rand;
    int numx, numy;
    int x; // max x = 720/1080 : 360
    int y; // max y = 1500/1920 : 420
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ClickBtn = findViewById(R.id.click_btn);
        scoreTv = findViewById(R.id.score_tv);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        x = displayMetrics.widthPixels - 360;
        y = displayMetrics.heightPixels - 420;

        rand = new Random();
        numx = rand.nextInt(x);
        numy = rand.nextInt(y);
        ClickBtn.setX(numx);
        ClickBtn.setY(numy);

        delay();

        ClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                scoreTv.setText("SCORE : "+i);

            }
        });

    }

    public void toast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void delay(){

        final Handler han = new Handler();

        han.postDelayed(new Runnable() {
            @Override
            public void run() {

                numx = rand.nextInt(x);
                numy = rand.nextInt(y);

                ClickBtn.setX(numx);
                ClickBtn.setY(numy);

                delay();
            }
        }, 300);
    }
}

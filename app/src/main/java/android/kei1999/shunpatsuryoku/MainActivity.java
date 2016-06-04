package android.kei1999.shunpatsuryoku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    Handler mHandler;
    int num1;
    Timer mTimer;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);

        iv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    seni();
                    //押したとき
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //離したとき
                }
                // trueにすると他のリスナーが呼ばれない
                return false;
            }
        });

        // IDを元にImageViewオブジェクトを取得
        mHandler = new Handler();

        Random random1 = new Random();
        num1 = random1.nextInt(800) + 200;
        mTimer = new Timer(false);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        num1--;
                        Log.d("CountTime", String.valueOf(num1));
                        if (num1 == 0) {
                            // drawableフォルダにある任意のイメージを設定
                            iv.setImageResource(R.drawable.temp);
                        }
                    }
                });
            }
        }, 0, 10);
    }

    public void seni(){

        mTimer.cancel();
        Intent intent2 = new Intent(this, RecodeActivity.class);
        intent2.putExtra("num1",num1);
        startActivity(intent2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();

    }
}
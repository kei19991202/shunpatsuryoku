package android.kei1999.shunpatsuryoku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    double num1;
    double num2;//ハイスコア
//    int[] num;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        tv = (TextView)findViewById(R.id.textView7);

        Intent intent3= getIntent();
        num1 = intent3.getDoubleExtra("num1",999);
//        int[] num = { 23, 46, 15, 78, 6, 95, 30 };
//        Arrays.sort(num);
//        tv.setText(num[0] +  "");

        num1 = -num1;
        Log.d("num1" , String.valueOf(num1));

        SharedPreferences pref= getSharedPreferences("number2", Context.MODE_PRIVATE);
        num2 = pref.getInt("NuM2", 999);
        Log.d("num2",String.valueOf(num2));

        if (num2==999) {
            tv.setText("ハイスコアはありません");
            Log.d("CountTime222", "通過");
            num2=9999;
        }else{
            Log.d("CountTime", "通過");
            if (num1>0) {
                if (num1 <= num2) {
                    num2 = num1;
                    Log.d("num2",String.valueOf(num2));
                }
            }
            tv.setText("ハイスコア:" + num2/100 + "秒");


        }
        SharedPreferences preferences = getSharedPreferences("number2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("NuM2", (int)num2);
        editor.commit();
    }

    public void start(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

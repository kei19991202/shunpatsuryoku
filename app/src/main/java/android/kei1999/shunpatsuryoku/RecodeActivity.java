package android.kei1999.shunpatsuryoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class RecodeActivity extends AppCompatActivity {

    TextView textView,textView2;
    double num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recode);

        Intent intent2 = getIntent();
        num1 = intent2.getIntExtra("num1",0);

        textView = (TextView)findViewById(R.id.textView3);
        textView2 = (TextView)findViewById(R.id.textView6);

        if (num1<=-1){

            textView.setText(-num1/100+"秒");

            if (-num1<50){
                textView2.setText("判定は..."+"もう少し頑張りましょう！");
                if(-num1<40) {
                    textView2.setText("判定は..." + "感覚を研ぎ澄ませて！");
                }else if(-num1<35) {
                    textView2.setText("判定は..." + "いい感じです。まだいけます。");
                }else if(-num1<30) {
                    textView2.setText("判定は..." + "あとすこし！");
                }else if (-num1 < 25) {
                    textView2.setText("判定は..." + "OK");
                }else if (-num1 == 0) {
                    textView2.setText("判定は..." + "あなたにはもう何も言うことはありません。");
                }
            }else{
                textView2.setText("判定は..."+"気が散り過ぎです。努力しましょう。");
            }
        }else if (num1==0){
            textView.setText("おめでとう!ピッタリです。");
            textView2.setText("判定は..."+"あなたにはもう何も言うことはありません。");
        }else if (num1>=1){
            textView.setText("早い!!");
        }
        Log.d("num1Recode",String.valueOf(num1));
    }

    public void oneMore(View v){
        Intent intent3 = new Intent(this, StartActivity.class);
        intent3.putExtra("num1",num1);
        startActivity(intent3);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //==== キーコード判定 ====//
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //-==- Backキー -==-//
            // 以降の処理をキャンセルする。
            //
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}

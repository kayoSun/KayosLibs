package com.kayo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

import com.kayo.zutils.BarUtil;
import com.kayo.zutils.DateUtils;
import com.kayo.zutils.SizeUtil;
import com.kayo.zutils.SpanUtils;
import com.kayo.zutils.ThreadUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView viewById = findViewById(R.id.textView);
        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                BarUtil.visibility(getWindow(),false);
//                if (BarUtil.statusIsLight(getWindow())) {
//                    BarUtil.statusStyle(getWindow(),BarUtil.ModeStyle.DARK);
//                    BarUtil.navBarImmersive(getWindow());
//                }else {
//                    BarUtil.statusStyle(getWindow(),BarUtil.ModeStyle.LIGHT);
//                    BarUtil.navBarImmersive(getWindow());
//                }
//                BarUtil.statusColor(MainActivity.this,Color.RED);

                SpannableStringBuilder spannableStringBuilder = SpanUtils.getBuilder(
                        MainActivity.this,"AAAAA" )
                        .setRundBackground(Color.RED,
                                SizeUtil.dp2px(MainActivity.this, 3),0 ,0 )
                        .create();


                viewById.setText(spannableStringBuilder);

                ThreadUtils.getSinglePool().execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("县城启动   +++++++++++++");
                    }
                });

                System.out.println(DateUtils.getNowString());

            }
        });
    }
}

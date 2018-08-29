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
import com.kayo.zutils.spans.CustomBackgroundSpan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView viewById = findViewById(R.id.textView);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }
}

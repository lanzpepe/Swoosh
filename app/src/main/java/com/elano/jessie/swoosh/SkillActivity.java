package com.elano.jessie.swoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkillActivity extends AppCompatActivity {
    public static final String KEY_REPLY_TEXT = "key-reply-text";
    private Button mBtnBeginner, mBtnBaller, mBtnFinish;
    private String imAText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        findViews();
        mBtnFinish.setEnabled(false);

        mBtnBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnFinish.setEnabled(true);
                setImAText("Beginner");
            }
        });

        mBtnBaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnFinish.setEnabled(true);
                setImAText("Baller");
            }
        });
    }

    public String getImAText() {
        return imAText;
    }

    public void setImAText(String imAText) {
        this.imAText = imAText;
    }

    public void finish(View view) {
        Intent data = new Intent();

        data.putExtra(KEY_REPLY_TEXT, this.getImAText());
        setResult(Activity.RESULT_OK, data);

        finish();
    }

    private void findViews() {
        mBtnBeginner = (Button) findViewById(R.id.btnBeginner);
        mBtnBaller = (Button) findViewById(R.id.btnBaller);
        mBtnFinish = (Button) findViewById(R.id.btnFinish);
    }
}




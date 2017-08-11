package com.elano.jessie.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LeagueActivity extends AppCompatActivity {
    public static final int REQ_CODE_SECOND_SCREEN = 1;
    private Button mBtnMen, mBtnWomen, mBtnCoEd, mBtnNext;
    private TextView mTvImAText, mTvTextHolder;
    private String leagueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        findViews();

        mBtnNext.setEnabled(false);

        mBtnMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnNext.setEnabled(true);
                setLeagueText(getResources().getString(R.string.text_button_men));
            }
        });

        mBtnWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnNext.setEnabled(true);
                setLeagueText(getResources().getString(R.string.text_button_women));
            }
        });

        mBtnCoEd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mBtnNext.setEnabled(true);
                setLeagueText(getResources().getString(R.string.text_button_co_ed));
            }
        });
    }

    public String getLeagueText() {
        return leagueText;
    }

    public void setLeagueText(String leagueText) {
        this.leagueText = leagueText;
    }

    public void next(View view) {
        Intent intent = new Intent(getApplicationContext(), SkillActivity.class);
        startActivityForResult(intent, REQ_CODE_SECOND_SCREEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE_SECOND_SCREEN) {
                String replyMsg = data.getStringExtra(SkillActivity.KEY_REPLY_TEXT);
                if (this.getLeagueText().equalsIgnoreCase("Mens")) {
                    mTvImAText.setVisibility(View.VISIBLE);
                    mTvTextHolder.setVisibility(View.VISIBLE);
                    mTvTextHolder.setText(replyMsg);
                    mBtnWomen.setEnabled(false);
                    mBtnCoEd.setEnabled(false);
                    mBtnNext.setVisibility(View.INVISIBLE);
                }
                else if (this.getLeagueText().equalsIgnoreCase("Womens")) {
                    mTvImAText.setVisibility(View.VISIBLE);
                    mTvTextHolder.setVisibility(View.VISIBLE);
                    mTvTextHolder.setText(replyMsg);
                    mBtnMen.setEnabled(false);
                    mBtnCoEd.setEnabled(false);
                    mBtnNext.setVisibility(View.INVISIBLE);
                }
                else if (this.getLeagueText().equalsIgnoreCase("Co-ed")) {
                    mTvImAText.setVisibility(View.VISIBLE);
                    mTvTextHolder.setVisibility(View.VISIBLE);
                    mTvTextHolder.setText(replyMsg);
                    mBtnMen.setEnabled(false);
                    mBtnWomen.setEnabled(false);
                    mBtnNext.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    private void findViews() {
        mBtnMen = (Button) findViewById(R.id.btnMen);
        mBtnWomen = (Button) findViewById(R.id.btnWomen);
        mBtnCoEd = (Button) findViewById(R.id.btnCoEd);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mTvImAText = (TextView) findViewById(R.id.tvImAText);
        mTvTextHolder = (TextView) findViewById(R.id.tvTextHolder);
    }
}

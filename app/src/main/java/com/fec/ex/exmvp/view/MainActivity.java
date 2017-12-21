package com.fec.ex.exmvp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fec.ex.exmvp.R;
import com.fec.ex.exmvp.model.PhoneNumInfo;
import com.fec.ex.exmvp.presenter.PhonePresenterImp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PhoneNumInfoView {

    public static final int REQUEST_MSG = 0;
    private EditText phoneNum;
    private Button getPhoneInfo;
    private TextView tvMSG;
    private ProgressBar progressBar;
    private PhonePresenterImp phonePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        phoneNum = findViewById(R.id.etPhoneNum);
        getPhoneInfo = findViewById(R.id.btnClick);
        tvMSG = findViewById(R.id.tvInfo);
        getPhoneInfo.setOnClickListener(this);

        ViewGroup layout = (ViewGroup) this.findViewById(android.R.id.content).getRootView();
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.INVISIBLE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout rl = new RelativeLayout(this);
        rl.setGravity(Gravity.CENTER);
        rl.addView(progressBar);
        layout.addView(rl, params);

        phonePresenter = new PhonePresenterImp(this, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClick:
                phonePresenter.getPhoneNumInfo(phoneNum.getText().toString(), REQUEST_MSG);
                break;
            default:
                Snackbar.make(tvMSG, "ERROR", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
        }
    }

    @Override
    public void showProgress(int requestTag) {
        if (progressBar != null && progressBar.getVisibility() == View.INVISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress(int requestTag) {
        if (progressBar != null && progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void loadDataSuccess(PhoneNumInfo data, int requestTag) {
        tvMSG.setText(data.toString());
    }


    @Override
    public void loadDataError(Throwable e, int requestTag) {
        tvMSG.setText(e.getMessage());
    }

}

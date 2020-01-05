package com.hello.mvpdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hello.mvpdemo.bean.Account;
import com.hello.mvpdemo.callback.CallBack;

import java.util.Random;

/*
 * 无框架
 * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_input;
    private Button btn_anniu;
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edt_input = (EditText) findViewById(R.id.edt_input);
        btn_anniu = (Button) findViewById(R.id.btn_anniu);
        tv_text = (TextView) findViewById(R.id.tv_text);

        btn_anniu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_anniu:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String input = edt_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "请输入", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        getAccount(input, new CallBack() {
            @Override
            public void onSuccess(Account account) {
                showSuccess(account);
            }

            @Override
            public void onFailed() {
                showFaile();
            }
        });
    }

    private String getInput() {
        return edt_input.getText().toString().trim();
    }

    private void showSuccess(Account account) {
        tv_text.setText("账号：" + account.getName() + " 等级：" + account.getLevel());
    }

    private void showFaile() {
        tv_text.setText("获取数据失败！");
    }

    private void getAccount(String name, CallBack callBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.setName(name);
            account.setLevel(100);
            callBack.onSuccess(account);
        } else {
            callBack.onFailed();
        }
    }
}

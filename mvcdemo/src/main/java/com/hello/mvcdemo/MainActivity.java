package com.hello.mvcdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hello.mvcdemo.bean.Account;
import com.hello.mvcdemo.callback.CallBack;
import com.hello.mvcdemo.model.Model;

import java.util.Random;

/*
 * MVC
 * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_input;
    private Button btn_anniu;
    private TextView tv_text;

    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        model = new Model();
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

        model.getAccount(input, new CallBack() {
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
}

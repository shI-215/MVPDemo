package com.hello.mvpdemo2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hello.mvpdemo2.bean.Account;
import com.hello.mvpdemo2.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, com.hello.mvpdemo2.View {

    private EditText edt_input;
    private Button btn_anniu;
    private TextView tv_text;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new Presenter(this);
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

        presenter.getData(input);
    }

    @Override
    public String getInput() {
        return edt_input.getText().toString().trim();
    }

    @Override
    public void showSuccess(Account account) {
        tv_text.setText("账号：" + account.getName() + " 等级：" + account.getLevel());
    }

    @Override
    public void showFaile() {
        tv_text.setText("获取数据失败！");
    }
}

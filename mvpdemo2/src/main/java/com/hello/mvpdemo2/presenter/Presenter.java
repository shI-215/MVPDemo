package com.hello.mvpdemo2.presenter;

import com.hello.mvpdemo2.View;
import com.hello.mvpdemo2.bean.Account;
import com.hello.mvpdemo2.callback.CallBack;
import com.hello.mvpdemo2.model.Model;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
    }


    public void getData(String name) {
        model.getAccount(name, new CallBack() {
            @Override
            public void onSuccess(Account account) {
                view.showSuccess(account);
            }

            @Override
            public void onFailed() {
                view.showFaile();
            }
        });
    }
}

package com.hello.mvcdemo.model;

import com.hello.mvcdemo.bean.Account;
import com.hello.mvcdemo.callback.CallBack;

import java.util.Random;

public class Model {
    public void getAccount(String name, CallBack callBack) {
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

package com.hello.mvcdemo.callback;


import com.hello.mvcdemo.bean.Account;

public interface CallBack {
    void onSuccess(Account account);

    void onFailed();
}

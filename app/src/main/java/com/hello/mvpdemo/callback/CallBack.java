package com.hello.mvpdemo.callback;

import com.hello.mvpdemo.bean.Account;

public interface CallBack {
    void onSuccess(Account account);

    void onFailed();
}

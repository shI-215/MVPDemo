package com.hello.mvpdemo2.callback;


import com.hello.mvpdemo2.bean.Account;

public interface CallBack {
    void onSuccess(Account account);

    void onFailed();
}

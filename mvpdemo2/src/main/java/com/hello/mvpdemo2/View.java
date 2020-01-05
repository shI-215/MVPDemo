package com.hello.mvpdemo2;

import com.hello.mvpdemo2.bean.Account;

public interface View {
    String getInput();

    void showSuccess(Account account);

    void showFaile();
}

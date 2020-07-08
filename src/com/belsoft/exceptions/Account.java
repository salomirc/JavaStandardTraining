package com.belsoft.exceptions;

import java.io.IOException;

public class  Account {

    private float balance;

    // throwing an unchecked exception
    public void deposit(float value) {
        if (value <= 0 )
            throw new IllegalArgumentException();
    }

    // throwing an checked exception
    public void deposit(int value) throws IOException {
        if (value <= 0 )
            throw new IOException();
    }

    public void withdraw(float value) throws AccountException {
        if (value > balance) {
//            var fundsException = new InsufficientFundsException();
//            var accountException = new AccountException();
//            accountException.initCause(fundsException);
//            throw accountException;
            throw new AccountException(new InsufficientFundsException());

        }
    }
}

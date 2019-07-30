package com.devla90.login.interactors;

import android.os.Handler;
import android.util.Log;

import com.devla90.login.interfaces.LoginInteractor;
import com.devla90.login.interfaces.OnLoginFinishListener;

import java.util.logging.LogRecord;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validarUser(final String user, final String password, final OnLoginFinishListener listener) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                if (!user.equals("") && !password.equals("")){
                    listener.successOperation();
                }else {
                    if (user.equals("")){
                        listener.userNameError();
                    }
                    if (password.equals("")){
                        listener.passwordError();
                    }
                }

            }
        }, 3000);


    }
}

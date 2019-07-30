package com.devla90.login.interfaces;

public interface LoginInteractor {

    void validarUser(String user, String password, OnLoginFinishListener listener);

}

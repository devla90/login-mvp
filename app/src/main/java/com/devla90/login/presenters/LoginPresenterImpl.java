package com.devla90.login.presenters;

import com.devla90.login.interactors.LoginInteractorImpl;
import com.devla90.login.interfaces.LoginInteractor;
import com.devla90.login.interfaces.LoginPresenter;
import com.devla90.login.interfaces.LoginView;
import com.devla90.login.interfaces.OnLoginFinishListener;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String password) {
        if (loginView != null){
            loginView.showProgress();
        }
        loginInteractor.validarUser(user,password,this);
    }

    @Override
    public void userNameError() {
        if (loginView != null){
            loginView.hideProgress();
            loginView.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if (loginView != null){
            loginView.hideProgress();
            loginView.setErrorPassword();
        }

    }

    @Override
    public void successOperation() {
        if (loginView != null){
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }
}

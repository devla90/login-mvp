package com.devla90.login.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.devla90.login.R;
import com.devla90.login.interfaces.LoginPresenter;
import com.devla90.login.interfaces.LoginView;
import com.devla90.login.presenters.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editTextUser, editTextPassword;
    private Button buttonLogin;
    private ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = (EditText)findViewById(R.id.editTextUser);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        editTextUser.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPassword() {
        editTextPassword.setError("Campo obligatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, MenuPrincipalActivity.class));
    }

    public void validarLogin(View view) {
        loginPresenter.validarUsuario(editTextUser.getText().toString(), editTextPassword.getText().toString());
    }
}

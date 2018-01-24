package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.LoginPresenter;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class LoginView extends Composite implements LoginPresenter.Display {

    private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

    interface LoginUiBinder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    MaterialTextBox txtUserName;
    @UiField
    MaterialTextBox txtPassword;
    @UiField
    MaterialButton btnSubmit;
    @UiField
    MaterialLabel lblError;

    public LoginView() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public MaterialButton getBtnSubmit() {
	return btnSubmit;
    }

    public void setBtnSubmit(MaterialButton btnSubmit) {
	this.btnSubmit = btnSubmit;
    }

    public MaterialTextBox getTxtUserName() {
	return txtUserName;
    }

    public void setTxtUserName(MaterialTextBox txtUserName) {
	this.txtUserName = txtUserName;
    }

    public MaterialTextBox getTxtPassword() {
	return txtPassword;
    }

    public void setTxtPassword(MaterialTextBox txtPassword) {
	this.txtPassword = txtPassword;
    }

    @Override
    public MaterialLabel getLblError() {
	return lblError;
    }

}

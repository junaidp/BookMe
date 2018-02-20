package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.LoginPresenter;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class LoginDesign extends Composite implements LoginPresenter.Display {

	private static LoginDesignUiBinder uiBinder = GWT.create(LoginDesignUiBinder.class);

	interface LoginDesignUiBinder extends UiBinder<Widget, LoginDesign> {
	}
	
	@UiField
	MaterialTextBox email;
	@UiField
	MaterialTextBox	password;
	@UiField
	MaterialButton btnLogin;
    @UiField
    MaterialLabel lblError;
    
	public LoginDesign() {
		initWidget(uiBinder.createAndBindUi(this));
	}
//	public MaterialTextBox getEmail() {
//		return email;
//	}
//
	public void setEmail(MaterialTextBox email) {
		this.email = email;
	}
//
	public void setPassword(MaterialTextBox password) {
		this.password = password;
	}
//
//	public MaterialButton getBtnLogin() {
//		return btnLogin;
//	}
//
	public void setBtnLogin(MaterialButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	@Override
	public MaterialLabel getLblError() {
		return lblError;
	}

	@Override
	public MaterialTextBox getTxtPassword() {
		return password;
	}

	@Override
	public MaterialTextBox getTxtUserName() {
		return email;
	}
 

	@Override
	public MaterialButton getBtnSubmit() {
		return btnLogin;
	}

}

package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.LoginPresenter;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
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
    @UiField
    MaterialLink linkSignUp;
    
	public LoginDesign() {

		initWidget(uiBinder.createAndBindUi(this));
		linkSignUp.getElement().getStyle().setPaddingLeft(215, Unit.PX);
		linkSignUp.getElement().getStyle().setPaddingTop (10, Unit.PX);
		linkSignUp.getElement().getStyle().setFontSize(15, Unit.PX);
		linkSignUp.getElement().getStyle().setFontStyle(FontStyle.NORMAL);
		btnLogin.getElement().getStyle().setPaddingBottom(10, Unit.PX); 
	}
	
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

	
	

	@Override
	public MaterialLink getlinkSignUp() {
		return linkSignUp;
	}
    
	
	
  
}
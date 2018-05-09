package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.User;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class SignUpView extends Composite {
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


	private static SignUpViewUiBinder uiBinder = GWT.create(SignUpViewUiBinder.class);

	interface SignUpViewUiBinder extends UiBinder<Widget, SignUpView> {
	}

	public SignUpView() {
		initWidget(uiBinder.createAndBindUi(this));
		btnSignUp.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				User user = new User();
				user.setName(email.getText());
				user.setPassword(password.getText());
				
				greetingService.signup(user , new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						Window.alert(result);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				} );
			}
		});
	}
	@UiField
	MaterialTextBox email;
	@UiField
	MaterialTextBox	password;
	@UiField
	MaterialTextBox rePassword;
    @UiField
    MaterialLabel lblError;
    @UiField
    MaterialButton btnSignUp;
	public MaterialTextBox getEmail() {
		return email;
	}
	public void setEmail(MaterialTextBox email) {
		this.email = email;
	}
	public MaterialTextBox getPassword() {
		return password;
	}
	public void setPassword(MaterialTextBox password) {
		this.password = password;
	}
	public MaterialTextBox getRePassword() {
		return rePassword;
	}
	public void setRePassword(MaterialTextBox rePassword) {
		this.rePassword = rePassword;
	}
	public MaterialLabel getLblError() {
		return lblError;
	}
	public void setLblError(MaterialLabel lblError) {
		this.lblError = lblError;
	}
	public MaterialButton getBtnSignUp() {
		return btnSignUp;
	}
	public void setBtnSignUp(MaterialButton btnSignUp) {
		this.btnSignUp = btnSignUp;
	}
	//public GreetingServiceAsync getGreetingService() {
	//	return greetingService;
	//}
    

}

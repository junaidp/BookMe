package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;

public class UserView extends Composite implements HasText {

	private static UserViewUiBinder uiBinder = GWT.create(UserViewUiBinder.class);

	interface UserViewUiBinder extends UiBinder<Widget, UserView> {
	}
  
 
   @UiField
   MaterialTab tab;
   //@UiField
  // MaterialTabItem bookingTab;
   
   
 
	public UserView() {

		initWidget(uiBinder.createAndBindUi(this));
		 
		 
	}
	
	 
//
//	public MaterialButton getBtnLogin() {
//		return btnLogin;
//	}
//
 

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
    
	
	
  
}
package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.window.MaterialWindow;

public class SigninPopUp extends Composite implements HasText {

	private static SigninPopUpUiBinder uiBinder = GWT.create(SigninPopUpUiBinder.class);

	interface SigninPopUpUiBinder extends UiBinder<Widget, SigninPopUp> {
	}
	
	@UiField 
	MaterialWindow window;


	public SigninPopUp() {
		initWidget(uiBinder.createAndBindUi(this));
		MaterialWindow window1 = new MaterialWindow();
		LoginDesign objDesign = new LoginDesign();
		window1.add(objDesign);
		window1.open();
		
	}
		

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

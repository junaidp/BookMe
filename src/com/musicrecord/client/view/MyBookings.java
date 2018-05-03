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
import com.musicrecord.shared.UserBooking;

import gwt.material.design.client.ui.MaterialLabel;

public class MyBookings extends Composite implements HasText {

	private static MyBookingsUiBinder uiBinder = GWT.create(MyBookingsUiBinder.class);

	interface MyBookingsUiBinder extends UiBinder<Widget, MyBookings> {
	}
	@UiField
	MaterialLabel message;
	@UiField
	MaterialLabel phone;
	@UiField
	MaterialLabel email;

	public MyBookings(UserBooking userBooking) {
		initWidget(uiBinder.createAndBindUi(this));
		this.message.setText(userBooking.getMessage());
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

	public MaterialLabel getMessage() {
		return message;
	}

	public void setMessage(MaterialLabel message) {
		this.message = message;
	}

	public MaterialLabel getPhone() {
		return phone;
	}

	public void setPhone(MaterialLabel phone) {
		this.phone = phone;
	}

	public MaterialLabel getEmail() {
		return email;
	}

	public void setEmail(MaterialLabel email) {
		this.email = email;
	}



}

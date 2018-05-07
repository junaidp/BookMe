package com.musicrecord.client.view;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.shared.UserBooking;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class MyBookings extends Composite implements HasText {
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);


	private static MyBookingsUiBinder uiBinder = GWT.create(MyBookingsUiBinder.class);

	interface MyBookingsUiBinder extends UiBinder<Widget, MyBookings> {
	}
	@UiField
	MaterialLabel message;
	@UiField
	MaterialLabel phone;
	@UiField
	MaterialLabel email;
	@UiField
	MaterialLink confirm;
	@UiField
	MaterialLink delete;
	
	//UserBooking userBooking = new UserBooking();
     public MyBookings(UserBooking userBooking) {
		initWidget(uiBinder.createAndBindUi(this));
		message.setText(userBooking.getMessage());
		message.setBackgroundColor(Color.BLUE_ACCENT_3);	

//		confirm.addClickHandler(new ClickHandler() {
//		@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				userBooking.setConfirmed(true);
//			
//				greetingService.bookUser(userBooking, new AsyncCallback<String>() {
//					@Override
//					public void onSuccess(String result) {
//						Window.alert("Confirmed Successfully");
//		
//						
//					}
//					
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//				});
//			}	
//				
//		});
//		delete.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//			userBooking.setActive(false);	
//			greetingService.bookUser(userBooking, new AsyncCallback<String>() {
//				@Override
//				public void onSuccess(String result) {
//					Window.alert("successfully deleted");
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//			});
//			}
//		});
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
	public MaterialLink getConfirm() {
		return confirm;
	}
	public void setConfirm(MaterialLink confirm) {
		this.confirm = confirm;
	}
	public MaterialLink getDelete() {
		return delete;
	}
	public void setDelete(MaterialLink delete) {
		this.delete = delete;
	}
}

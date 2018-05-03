package com.musicrecord.client.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
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
import com.musicrecord.client.presenter.MainPresenter;
import com.musicrecord.client.presenter.TabPresenter;
import com.musicrecord.client.presenter.MainPresenter.Display;
import com.musicrecord.client.view.Footer.FooterUiBinder;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.UserBooking;

import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;

public class Tab extends Composite implements HasText {
	
	private static TabUiBinder uiBinder = GWT.create(TabUiBinder.class);
    
	interface TabUiBinder extends UiBinder<Widget, Tab> {
		
	}
	@UiField
	MaterialColumn tab1Container;
	@UiField
	MaterialTab tab;
	@UiField 
	MaterialLink tab1;
	private GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
	
	public Tab() {
		
		initWidget(uiBinder.createAndBindUi(this));
		fetchUserBooking();
//		tab1.addClickHandler(new  ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Footer uiFooter= new Footer();
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
	
	public void cardUserBooking(ArrayList<UserBooking> result)
	{
		tab1Container.clear();
		for(int i=0 ; i<result.size() ; i++)
		{
			MyBookings myBookings = new MyBookings(result.get(i));
		     tab1Container.add(myBookings);
		}
	}
	
	public void fetchUserBooking()
	{
		rpcService.fetchUserBooking(new AsyncCallback<ArrayList<UserBooking>>() {

			@Override
			public void onSuccess(ArrayList<UserBooking> result) {
				// TODO Auto-generated method stub
				if(result!=null)
					cardUserBooking(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getLocalizedMessage());
				Window.alert("failed to Fetch UserBookings");
				
			}
		});

	}

}

package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.presenter.MainPresenter.Display;
import com.musicrecord.client.view.MyBookings;
import com.musicrecord.client.view.SearchAutoComplete;
import com.musicrecord.shared.UserBooking;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.client.ui.MaterialRow;

public class TabPresenter {
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	UserBooking userBooking = new UserBooking();
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Logger logger = Logger.getLogger("DashBoardPresenter");

	public interface Display {
		Widget asWidget();
		MaterialRow getContainer();
		SearchAutoComplete getSearchAutoComplete();

	}
	public TabPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}
	
	public void cardUserBooking(ArrayList<UserBooking> result)
	{
		display.getContainer().clear();
		for(int i=0 ; i<result.size() ; i++)
		{
			MyBookings myBookings = new MyBookings(result.get(i));
			//display.getContainer().add(myBookings);
			myBookings.getConfirm().addClickHandler(new ClickHandler() {
				@Override
					public void onClick(ClickEvent event) {
						Window.alert("clicked");
						userBooking.setConfirmed(true);
						//bookUser();
					}

				
						
				});
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

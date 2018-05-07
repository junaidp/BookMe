package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.MyBookings;
import com.musicrecord.client.widgets.TabWidget;
import com.musicrecord.shared.UserBooking;
import com.sun.java.swing.plaf.windows.resources.windows;

public class MainTabPresenter implements Presenter {
	
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Logger logger = Logger.getLogger("MainTabPresenter");

	public MainTabPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}
	
	public interface Display {
		Widget asWidget();
		TabWidget getTabWidget();
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
		fetchUserBooking();
		
		display.getTabWidget().getTab().addSelectionHandler(new SelectionHandler<Integer>() {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				if(event.getSelectedItem() == 1){
				fetchConfirmedBookings();
				}
			}
		});
		
//		display.getTabWidget().getTab().addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
				
//			}
//		});
	}

	private void bind() {
	
		
	}
	

	
	public void cardUserBooking(ArrayList<UserBooking> result)
	{
		display.getTabWidget().getTab1Container().clear();
		for(int i=0 ; i<result.size() ; i++)
		{
			final UserBooking userBooking = result.get(i);
			MyBookings myBookings = new MyBookings(userBooking);
			display.getTabWidget().getTab1Container().add(myBookings);
			
			myBookings.getConfirm().addClickHandler(new ClickHandler() {
				@Override
					public void onClick(ClickEvent event) {
						
						
						bookUser(userBooking);
					}

				
						
				});
			myBookings.getDelete().addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
				deleteUser(userBooking);
				}

				private void deleteUser(final UserBooking userBooking) {
					userBooking.setActive(false);	
					rpcService.bookUser(userBooking, new AsyncCallback<String>() {
						@Override
						public void onSuccess(String result) {
							Window.alert("successfully deleted");
							 fetchUserBooking();
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("deletion failed");
							
						}
						
					});
				}
			});
			
		}
	}
	
	private void bookUser(UserBooking userBooking) {
		userBooking.setConfirmed(true);
		rpcService.bookUser(userBooking, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				Window.alert("Confirmed Successfully");
		        fetchUserBooking();
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("booking confirmation failed");
			}
			
		});
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
                            //Booked Users
	public void cardBookedUsers(ArrayList<UserBooking> result)
	{
	    //
		display.getTabWidget().getTab2Container().clear();
		for(int i=0 ; i<result.size() ; i++)
		{
			final UserBooking userBooking = result.get(i);
			MyBookings myBookings = new MyBookings(userBooking);
			myBookings.getConfirm().setVisible(false);
			myBookings.getDelete().setVisible(false);
			display.getTabWidget().getTab2Container().add(myBookings);
			//bookedUsers(userBooking);
		}
	}
		
	public void fetchConfirmedBookings()
		{
			rpcService.fetchConfirmedBookings(new AsyncCallback<ArrayList<UserBooking>>() {

				@Override
				public void onSuccess(ArrayList<UserBooking> result) {
					// TODO Auto-generated method stub
					if(result!=null)
						cardBookedUsers(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Window.alert(caught.getLocalizedMessage());
					Window.alert("failed to Fetch Booked Users");
					
				}
			});
}
	

}

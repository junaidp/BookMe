package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.MyBookings;
import com.musicrecord.client.view.SearchAutoComplete;
import com.musicrecord.client.view.Service;
import com.musicrecord.client.widgets.TabWidget;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.UserBooking;
import com.musicrecord.shared.UserOracle;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.client.ui.MaterialRow;

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
				if(event.getSelectedItem() == 2){
					fetchCategories();
					display.getTabWidget().getTabSearch().getAcList().addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
						@Override
						public void onSelection(SelectionEvent<Suggestion> event) {
							
							fetchRecords(event.getSelectedItem().getDisplayString()+"");		
						}
					});
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
					Window.alert("failed to Fetch Booked Users in Tab");
					
				}
			});
         }
	
	  //Search Tab
	public void cardsDisplay(ArrayList<Records> result)
	{
		//display.getTabWidget().getSearchTabContainer().clear();

		for(int i=0 ; i<result.size() ; i++)
		{
			Service service = new Service(result.get(i));
			//display.getContainer().add(service);
			
			display.getTabWidget().getSearchTabContainer().add(service);
		}
	}
	public void fetchRecords(String data)
	{
		HashMap<String, String> requestInfo = new HashMap<String, String>();
		requestInfo.put("keyWord", data);
		requestInfo.put("searchBy", "");

		rpcService.fetchRecords(requestInfo, new AsyncCallback<ArrayList<Records>>() {

			@Override
			public void onSuccess(ArrayList<Records> result) {
				if(result!=null)
				cardsDisplay(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getLocalizedMessage());
				Window.alert("failed to Fetch Records");

			}
		});

	}
	private void fetchCategories() {
		GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
		rpcService.fetchCategories(new AsyncCallback<ArrayList<Category>>() {
			
		    @Override
		    public void onSuccess(ArrayList<Category> category) {
			 UserOracle oracle = new UserOracle();
			  oracle.addContacts(category);
			  display.getTabWidget().getTabSearch().getAcList().setSuggestions(oracle);
		    }

		    @Override
		    public void onFailure(Throwable caught) {
			Window.alert("fail");

		    }

		});
	    }
}

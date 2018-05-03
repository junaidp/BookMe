package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.MyBookings;
import com.musicrecord.client.view.SearchAutoComplete;
import com.musicrecord.client.view.Service;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.UserBooking;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialRow;

public class MainPresenter implements Presenter

{
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Logger logger = Logger.getLogger("DashBoardPresenter");

	public interface Display {
		Widget asWidget();
		MaterialRow getContainer();
		SearchAutoComplete getSearchAutoComplete();

	}

	public MainPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
	}

	private void bind() {
	
//		fetchRecords("");
		display.getSearchAutoComplete().getAcList().addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				
				fetchRecords(event.getSelectedItem().getDisplayString()+"");		
				fetchReviews(event.getSelectedItem().getDisplayString()+"");
			}
		});
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

	public void cardsDisplay(ArrayList<Records> result)
	{
		display.getContainer().clear();
		for(int i=0 ; i<result.size() ; i++)
		{
			Service service = new Service(result.get(i));
			display.getContainer().add(service);
		}
	}

	public void fetchReviews(String data){
		HashMap<String, String> requestInfo = new HashMap<String, String>();
		requestInfo.put("keyWord",data );
		requestInfo.put("searchBy", "");
		
	    rpcService.fetchReviews(requestInfo,new AsyncCallback<ArrayList<Reviews>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("failed to Fetch Reviews");
			}

			@Override
			public void onSuccess(ArrayList<Reviews> result) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	}

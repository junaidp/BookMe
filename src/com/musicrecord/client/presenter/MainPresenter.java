package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.Service;
import com.musicrecord.shared.Records;

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
    	fetchRecords();
    }
    public void fetchRecords()
    {
    	HashMap<String, String> requestInfo = new HashMap<String, String>();
    	requestInfo.put("keyWord", "");
    	requestInfo.put("searchBy", "");
    	
    	rpcService.fetchRecords(requestInfo, new AsyncCallback<ArrayList<Records>>() {
			
			@Override
			public void onSuccess(ArrayList<Records> result) {
				
				cardsDisplay(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("fail123");
				
			}
		});
    
    }
    
    public void cardsDisplay(ArrayList<Records> result)
	{
		
		for(int i=0 ; i<result.size() ; i++)
		{
			Service service = new Service(result.get(i).getDisplayImage() , result.get(i).getArtist(), result.get(i).getMusicDescription(), "Book" , "Reviews");
			display.getContainer().add(service);
		}
	}

}

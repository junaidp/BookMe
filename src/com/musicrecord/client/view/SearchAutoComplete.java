package com.musicrecord.client.view;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.musicrecord.client.presenter.RecordsPresenter.Display;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.UserOracle;
import com.musicrecord.shared.UserRecord;

import gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle;

import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;

public class SearchAutoComplete extends Composite implements HasText {
	

	private static SearchAutoCompleteUiBinder uiBinder = GWT.create(SearchAutoCompleteUiBinder.class);
	interface SearchAutoCompleteUiBinder extends UiBinder<Widget, SearchAutoComplete> {
		
	}
	
	public SearchAutoComplete() {
		
		initWidget(uiBinder.createAndBindUi(this));
		fetchCategories();
		 
		
	}
	private void fetchCategories() {
		GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
		rpcService.fetchCategories(new AsyncCallback<ArrayList<Category>>() {
			
		    @Override
		    public void onSuccess(ArrayList<Category> category) {
			 UserOracle oracle = new UserOracle();
			  oracle.addContacts(category);
			  acList.setSuggestions(oracle);
		    }

		    @Override
		    public void onFailure(Throwable caught) {
			Window.alert("fail");

		    }

		});
	    }
	@UiField
    MaterialAutoComplete acList;
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
	public MaterialAutoComplete getAcList() {
		return acList;
	}
	


}

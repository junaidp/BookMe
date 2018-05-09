package com.musicrecord.client.widgets;

import java.util.ArrayList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.MyBookings;
import com.musicrecord.client.view.SearchAutoComplete;
import com.musicrecord.shared.UserBooking;

import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;

public class TabWidget extends Composite{
	
	private static TabUiBinder uiBinder = GWT.create(TabUiBinder.class);
    
	interface TabUiBinder extends UiBinder<Widget, TabWidget> {
		
	}
	@UiField
	SearchAutoComplete tabSearch;
	
	@UiField
	MaterialColumn tab1Container;
	@UiField
	MaterialTab tab;
	@UiField 
	MaterialLink tab1;

	@UiField
	MaterialColumn tab2Container;
	@UiField
	MaterialColumn searchTabContainer;
	private GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
	
	public TabWidget() {
		
		initWidget(uiBinder.createAndBindUi(this));
		//tabSearch.setWidth("100%");
//		tab1.addClickHandler(new  ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Footer uiFooter= new Footer();
//			}
//		});
	}

	public MaterialColumn getTab1Container() {
		return tab1Container;
	}

	public void setTab1Container(MaterialColumn tab1Container) {
		this.tab1Container = tab1Container;
	}

	public MaterialColumn getTab2Container() {
		return tab2Container;
	}

	public void setTab2Container(MaterialColumn tab2Container) {
		this.tab2Container = tab2Container;
	}

	public MaterialTab getTab() {
		return tab;
	}

	public void setTab(MaterialTab tab) {
		this.tab = tab;
	}

	public MaterialColumn getSearchTabContainer() {
		return searchTabContainer;
	}

	public void setSearchTabContainer(MaterialColumn searchTabContainer) {
		this.searchTabContainer = searchTabContainer;
	}

	public SearchAutoComplete getTabSearch() {
		return tabSearch;
	}

	public void setTabSearch(SearchAutoComplete tabSearch) {
		this.tabSearch = tabSearch;
	}



	
	}

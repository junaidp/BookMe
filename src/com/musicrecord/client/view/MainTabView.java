package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.MainTabPresenter.Display;
import com.musicrecord.client.widgets.TabWidget;


public class MainTabView extends Composite implements Display {

	private static MainTabViewUiBinder uiBinder = GWT.create(MainTabViewUiBinder.class);
	
	interface MainTabViewUiBinder extends UiBinder<Widget, MainTabView> {
	}
    @UiField
    TabWidget tabWidget;
	public MainTabView() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	public TabWidget getTabWidget() {
		return tabWidget;
	}
	public void setTabWidget(TabWidget tabWidget) {
		this.tabWidget = tabWidget;
	}
	
}

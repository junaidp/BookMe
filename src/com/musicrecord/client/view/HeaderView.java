package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.LoginPresenter;
import com.musicrecord.client.presenter.Presenter;
import com.musicrecord.client.presenter.HeaderPresenter.Display;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialLink;

public class HeaderView extends Composite implements  Display {

	private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

	interface HeaderViewUiBinder extends UiBinder<Widget, HeaderView> {
	}
	
	@UiField
	MaterialLink signin;
	
	
	
	public HeaderView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public MaterialLink getSignin() {
		return signin;
	}
	public void setSignin(MaterialLink signin) {
		this.signin = signin;
	}

	
	

}

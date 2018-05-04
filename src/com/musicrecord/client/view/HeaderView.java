 package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.HeaderPresenter.Display;

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

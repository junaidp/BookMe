package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.MainPresenter.Display;

import gwt.material.design.client.ui.MaterialColumn;

public class Main extends Composite implements Display {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	
	@UiField
	MaterialColumn container;

	public Main() {
		initWidget(uiBinder.createAndBindUi(this));
		
		for(int i=0 ; i<2 ; i++)
		{
			Service service = new Service("cardImage.png" , "Sample" , "I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively." , "Link 1" , "Link 1");
			container.add(service);
		}
	}
}

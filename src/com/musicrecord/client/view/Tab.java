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
import com.musicrecord.client.view.Footer.FooterUiBinder;

import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTab;
import gwt.material.design.client.ui.MaterialTabItem;

public class Tab extends Composite implements HasText {

	private static TabUiBinder uiBinder = GWT.create(TabUiBinder.class);

	interface TabUiBinder extends UiBinder<Widget, Tab> {
	}
	@UiField
	MaterialTab tab;
	@UiField 
	MaterialLink tab1;
	public Tab() {
		initWidget(uiBinder.createAndBindUi(this));
//		tab1.addClickHandler(new  ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				Footer uiFooter= new Footer();
//			}
//		});
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

}

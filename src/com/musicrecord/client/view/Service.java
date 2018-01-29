package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class Service extends Composite{

	private static ServiceUiBinder uiBinder = GWT.create(ServiceUiBinder.class);

	interface ServiceUiBinder extends UiBinder<Widget, Service> {
	}
	
	@UiField
    MaterialImage image;
	
	@UiField
    MaterialCardTitle imageTitle;
	
	@UiField
    MaterialLabel label;
	
	@UiField
	MaterialLink link1, link2;


	public Service() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Service(String imageUrl, String imageTitle, String label, String firstLink, String secondLink) {
		initWidget(uiBinder.createAndBindUi(this));
		image.setUrl(imageUrl);
		this.imageTitle.setText(imageTitle);
		this.label.setText(label);
		link1.setText(firstLink);
		link2.setText(secondLink);
	}

}

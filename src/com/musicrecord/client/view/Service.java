package com.musicrecord.client.view;
import java.util.HashMap;

import com.gargoylesoftware.htmlunit.javascript.host.intl.V8BreakIterator;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.widgets.SubmitReview;
import com.musicrecord.shared.Records;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;

public class Service extends Composite{

	private static ServiceUiBinder uiBinder = GWT.create(ServiceUiBinder.class);

	
	interface ServiceUiBinder extends UiBinder<Widget, Service> {
	}
	@UiField
	MaterialRating rating;
	
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
		
		rating.addValueChangeHandler(new ValueChangeHandler<Integer>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Integer> event) {
				 MaterialToast.fireToast(event.getValue() + " Rate value");
			}
		});
		link2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.alert("OK");
				;
			}
		});			
	}
	

	public Service(Records records) {
		//.getDisplayImage() , result.get(i).getArtist(), result.get(i).getMusicDescription(), "Book" , "Reviews"
		initWidget(uiBinder.createAndBindUi(this));
		image.setUrl(records.getDisplayImage());
		this.imageTitle.setText(records.getArtist());
		this.label.setText(records.getMusicDescription());
		link1.setText("Book");
		link2.setText("Review");		
		rating.setValue(getAvgReview(records));
		link1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				
					MaterialWindow window1 = new MaterialWindow();
					BookMe objDesign = new BookMe();
					window1.add(objDesign);
					window1.open();
					

					
				
			}
		});
		link2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				MaterialWindow windowSubmitReviews = new MaterialWindow();
				SubmitReview submitReview = new SubmitReview(records);
				windowSubmitReviews.add(submitReview);
				windowSubmitReviews.open();
				windowSubmitReviews.setTitle("Comments");
			}
		});	
		
	}
	public int getAvgReview(Records records) {
		int avgReview = 0;
		int sumReview = 0;
		for(int i = 0 ; i<records.getReviews().size() ; i++)
		{
         sumReview = sumReview + records.getReviews().get(i).getReviews();
		}
		avgReview = sumReview/records.getReviews().size();
		return avgReview;
	}

	public MaterialRating getRating() {
		return rating;
	}


	public void setRating(MaterialRating i) {
		this.rating = i;
	}
}

package com.musicrecord.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;

import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.client.ui.MaterialButton;

public class SubmitReview extends Composite implements HasText {

	private static SubmitReviewUiBinder uiBinder = GWT.create(SubmitReviewUiBinder.class);

	interface SubmitReviewUiBinder extends UiBinder<Widget, SubmitReview> {
	}

	public SubmitReview(final Records records) {
		initWidget(uiBinder.createAndBindUi(this));
		richEditorOptions();
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				submitReview(records);				
			}			
		});
	}
	
	private void submitReview(Records records) {
		
		GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
		Reviews review = new Reviews();
		review.setDesc(optionRichEditor.getHTML());
		review.setReviews(ratings.getValue());
		review.setRecordId(records);
		rpcService.saveReviews(review, new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert("Reviews Saved Successfully" );
			}
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Reviews Saved failed" + caught.getLocalizedMessage());
				
			}
		});
		
	}
	
	@UiField
	MaterialRichEditor optionRichEditor;

	@UiField
	MaterialButton button;
	@UiField 
	MaterialRating ratings;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}
	public void richEditorOptions(){
		optionRichEditor.setStyleOptions( ToolbarButton. BOLD , ToolbarButton. ITALIC, ToolbarButton.UNDERLINE ); 
		optionRichEditor.setParaOptions();
		optionRichEditor.setMiscOptions();
		optionRichEditor.setUndoOptions();
		optionRichEditor.setColorOptions();
		optionRichEditor.setFontOptions();
		optionRichEditor.setHeightOptions();
		
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

}

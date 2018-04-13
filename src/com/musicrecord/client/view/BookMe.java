package com.musicrecord.client.view;


import java.util.Date;

import org.eclipse.jdt.core.dom.ThisExpression;
import org.springframework.instrument.classloading.tomcat.TomcatInstrumentableClassLoader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.shared.Records;

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;

public class BookMe extends Composite{


	private static bookMeUiBinder uiBinder = GWT.create(bookMeUiBinder.class);

	interface bookMeUiBinder extends UiBinder<Widget, BookMe> {
	}
	@UiField
	MaterialButton btnMessage;
	@UiField
	MaterialButton btnBookMe;
	@UiField
	MaterialTimePicker timePicker;
	@UiField
	MaterialDatePicker datePicker;

	GreetingServiceAsync rpcService = GWT.create(GreetingService.class);


	public BookMe(Records record) {

		initWidget(uiBinder.createAndBindUi(this));

		btnBookMe.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("button is clicked");
				bookUser(record);

			}
		});
	}



	public void MaterialDatePicker(){


	}
	public void TimePicker() {

	}

	public interface Display {
		Widget asWidget();

		Object getHtmlErrorMessage = null;



		HasClickHandlers getbtnBookMe();


	}

	
	
	public void bookUser(Records record){

		Date bookDate = datePicker.getDate();
		Date bookTime = timePicker.getValue();


		rpcService.bookUser(record, bookDate, bookTime, new AsyncCallback<String>() {
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("fail");
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Window.alert(result);

			}
		});


	}

}

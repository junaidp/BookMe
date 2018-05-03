//package com.musicrecord.client.view;
//
//import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.event.dom.client.ClickEvent;
//import com.google.gwt.maps.client.MapOptions;
//import com.google.gwt.maps.client.MapTypeId;
//import com.google.gwt.maps.client.base.LatLng;
//import com.google.gwt.maps.client.impl.MapOptionsImpl;
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.uibinder.client.UiHandler;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.FormPanel;
//import com.google.gwt.user.client.ui.HasText;
//import com.google.gwt.user.client.ui.Widget;
//
//public class Maps extends Composite implements EntryPoint {
//
//	private static MapsUiBinder uiBinder = GWT.create(MapsUiBinder.class);
//
//	interface MapsUiBinder extends UiBinder<Widget, Maps> {
//	}
//
//	public Maps() {
//		initWidget(uiBinder.createAndBindUi(this));
//	}
//
//	@Override
//	public void onModuleLoad() {
//		// TODO Auto-generated method stub
//		    
//		    FormPanel panel = new FormPanel();
//	        panel.setWidth("100%");
//	        panel.setHeight("100%");
//	        
//	        MapOptions options = MapOptions.create();
//	        options.setCenter(LatLng.create(23,-151));
//	        options.setZoom(2);
//	        options.setMapTypeId(MapTypeId.ROADMAP);
//	        options.setDraggable(true);
//	        options.setMapTypeControl(true);
//	        options.setScaleControl(true);
//	        options.setScrollWheel(true);
//	        Button btn = new Button();
//	        GoogleMaps gMap = GoogleMap.create(panel.getElement(), options);
//	        RootPanel.get().add(panel);
//	        RootPanel.get().add(btn);
//
//	        gMap.addIdleListener(new GoogleMap.IdleHandler() {
//
//	            public void handle() {
//	                Window.alert("Idle");
//
//	            }
//	        });
//	}
//
//	@UiField
//	Button button;
//
//	public Maps(String firstName) {
//		initWidget(uiBinder.createAndBindUi(this));
//		button.setText(firstName);
//	}
//
//	@UiHandler("button")
//	void onClick(ClickEvent e) {
//		Window.alert("Hello!");
//	}
//
//	public void setText(String text) {
//		button.setText(text);
//	}
//
//	public String getText() {
//		return button.getText();
//	}
//
//}

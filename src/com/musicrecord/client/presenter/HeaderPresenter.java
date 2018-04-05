package com.musicrecord.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.RangeChangeEvent;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.view.BookMe;
import com.musicrecord.client.view.LoginDesign;
import com.musicrecord.client.widgets.SaveEditRecordWidget;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialLink;

public class HeaderPresenter implements Presenter

{
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;


	public interface Display {
		Widget asWidget();
		MaterialLink getSignin();
		

	}

	public HeaderPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;

	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
	}

	private void bind() {

		display.getSignin().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MaterialWindow window1 = new MaterialWindow();
				LoginDesign objDesign = new LoginDesign();
				Presenter presenter = new LoginPresenter(rpcService, eventBus, window1, objDesign);
				presenter.go(window1);
				window1.add(objDesign);
				window1.open();
				

			}
		});
		
		
	}

}




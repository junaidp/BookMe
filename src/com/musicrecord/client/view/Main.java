package com.musicrecord.client.view;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.MainPresenter.Display;

import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialRow;

public class Main extends Composite implements Display {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	@UiField
	MaterialRow container;
	@UiField
	SearchAutoComplete searchAutoComplete;


	public Main() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public MaterialRow getContainer() {
		return container;
	}

	public void setContainer(MaterialRow container) {
		this.container = container;
	}

	public SearchAutoComplete getSearchAutoComplete() {
		return searchAutoComplete;
	}

}

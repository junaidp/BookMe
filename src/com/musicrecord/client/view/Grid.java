package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.presenter.GridPresenter.Display;

public class Grid extends Composite implements Display {

    private static GridUiBinder uiBinder = GWT.create(GridUiBinder.class);

    interface GridUiBinder extends UiBinder<Widget, Grid> {
    }

    public Grid() {
	initWidget(uiBinder.createAndBindUi(this));
	Window.alert("dd");
    }

}

package com.musicrecord.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MaterialTabCustom extends Composite {

	private static MaterialTabCustomUiBinder uiBinder = GWT.create(MaterialTabCustomUiBinder.class);

	interface MaterialTabCustomUiBinder extends UiBinder<Widget, MaterialTabCustom> {
	}

	public MaterialTabCustom() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

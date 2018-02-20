package com.musicrecord.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MaterialLogin extends Composite {

	private static MaterialLoginUiBinder uiBinder = GWT.create(MaterialLoginUiBinder.class);

	interface MaterialLoginUiBinder extends UiBinder<Widget, MaterialLogin> {
	}

	public MaterialLogin() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

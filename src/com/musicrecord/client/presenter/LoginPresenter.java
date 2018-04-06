package com.musicrecord.client.presenter;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingServiceAsync;
import com.musicrecord.client.event.RecordsAdminEvent;
import com.musicrecord.client.event.RecordsUserEvent;
import com.musicrecord.client.view.LoadingPopup;
import com.musicrecord.client.view.SignUpView;
import com.musicrecord.shared.User;
import com.sun.java.swing.plaf.windows.resources.windows;

import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialTextBox;

public class LoginPresenter implements Presenter

{
	private final GreetingServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Logger logger = Logger.getLogger("DashBoardPresenter");
	private MaterialWindow signInpopup ;

	public interface Display {
		Widget asWidget();

		Object getHtmlErrorMessage = null;

		MaterialTextBox getTxtPassword();

		MaterialTextBox getTxtUserName();

		HasClickHandlers getBtnSubmit();
		
		      // ListBox getListYears();
		MaterialLabel getLblError();

		//MaterialButton getBtnSignUp();
		MaterialLink getlinkSignUp();

		//MaterialButton getBtnSignUp();

	}

	public LoginPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, MaterialWindow signInpopup, Display view) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
		this.signInpopup = signInpopup;
		
	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
		bind();
	}

	
	private void bind() {

		RootPanel.get("loadingMessage").setVisible(false);
		display.getBtnSubmit().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
						MaterialLoader.loading(true);
						MaterialLoader.progress(true);
			

				if (display.getTxtUserName().getText().equals("") || display.getTxtPassword().getText().equals("")) {
					display.getLblError().setVisible(true);
					display.getLblError().setText("username / password cannot be empty");
					MaterialLoader.loading(false);
					MaterialLoader.progress(false);
				} else {
					
					signIn(display.getTxtUserName().getText(), display.getTxtPassword().getText());

				}
				
			}

		});
		display.getlinkSignUp().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				signInpopup.close();
				SignUpView signUpView = new SignUpView();
				MaterialWindow signUpWindow = new MaterialWindow();
				signUpWindow.add(signUpView);
				signUpWindow.open();
			}
		});

	}

	public void signIn(String userName, String password) {
		 signInpopup.close();
		final LoadingPopup loadingPopup = new LoadingPopup();
		loadingPopup.display();
		rpcService.signIn(userName, password, new AsyncCallback<User>()
              
		{
			public void onFailure(Throwable ex) {
				Window.alert(ex.getStackTrace().toString());
				if (loadingPopup != null) {
					loadingPopup.remove();
				}
				MaterialLoader.loading(false);
				MaterialLoader.progress(false);
			}

			public void onSuccess(User user) {
				MaterialLoader.loading(false);
				MaterialLoader.progress(false);
				if (user != null) {

					display.getLblError().setVisible(false);
					if (user.getRoleId().getRoleId() == 1) {

						eventBus.fireEvent(new RecordsUserEvent(user));

					} else {
						eventBus.fireEvent(new RecordsAdminEvent(user));
					}
				} else {
					display.getLblError().setVisible(true);
					display.getLblError().setText("username / password invalid");
				}

				if (loadingPopup != null) {
					loadingPopup.remove();
				}
			}
		});

	}
}

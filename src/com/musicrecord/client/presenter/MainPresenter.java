package com.musicrecord.client.presenter;

import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.musicrecord.client.GreetingServiceAsync;

public class MainPresenter implements Presenter

{
    private final GreetingServiceAsync rpcService;
    private final HandlerManager eventBus;
    private final Display display;
    private Logger logger = Logger.getLogger("DashBoardPresenter");

    public interface Display {
	Widget asWidget();

    }

    public MainPresenter(GreetingServiceAsync rpcService, HandlerManager eventBus, Display view) {
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

    }
}

package com.musicrecord.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.musicrecord.shared.User;

public class MainTabEvent extends GwtEvent<MainTabEventHandler> {

    User loggedInUser = null;
    int selectedYear;

    public MainTabEvent(User loggedInUser) {
	this.loggedInUser = loggedInUser;
    }

    public MainTabEvent(User loggedInUser, int year) {
	this.loggedInUser = loggedInUser;
	this.selectedYear = year;
    }

    public static Type<MainTabEventHandler> TYPE = new Type<MainTabEventHandler>();

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<MainTabEventHandler> getAssociatedType() {
	return TYPE;
    }

    @Override
    protected void dispatch(MainTabEventHandler handler) {
	handler.onMain(this);

    }

    public User getLoggedInUser() {
	return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
	this.loggedInUser = loggedInUser;
    }

    public int getSelectedYear() {
	return selectedYear;
    }

    public void setSelectedYear(int selectedYear) {
	this.selectedYear = selectedYear;
    }

}

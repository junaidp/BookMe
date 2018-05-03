package com.musicrecord.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.musicrecord.client.widgets.SubmitReview;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.User;
import com.musicrecord.shared.UserBooking;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

    void signIn(String userid, String password, AsyncCallback<User> callback);

    void fetchRecords(HashMap<String, String> requestInfo, AsyncCallback<ArrayList<Records>> callback);

    void saveRecord(Records record, AsyncCallback<String> callback);

    void deleteRecord(Records record, AsyncCallback<String> callback);

    void fetchCategories(AsyncCallback<ArrayList<Category>> callback);
    
    void fetchReviews(HashMap<String, String> requestInfo,AsyncCallback<ArrayList<Reviews>> asyncCallback);
    
    void saveReviews(Reviews review , AsyncCallback<String> callback);

	void signup(User user, AsyncCallback<String> callback);

	void fetchReviews(AsyncCallback<ArrayList<Reviews>> callback);

	//void bookUser(User users, AsyncCallback<String> asyncCallback);

	void bookUser(UserBooking userBooking, AsyncCallback<String> asyncCallback);

	void fetchUserBooking(AsyncCallback<ArrayList<UserBooking>> callback);
	
}

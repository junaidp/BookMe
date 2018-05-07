package com.musicrecord.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.musicrecord.client.widgets.SubmitReview;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.User;
import com.musicrecord.shared.UserBooking;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String signup(User user) throws Exception;

    User signIn(String userid, String password) throws Exception;

    ArrayList<Records> fetchRecords(HashMap<String, String> requestInfo) throws Exception;

    String saveRecord(Records record) throws Exception;

    String deleteRecord(Records record) throws Exception;

    ArrayList<Category> fetchCategories() throws Exception;

	ArrayList<Reviews> fetchReviews() throws Exception;

	String saveReviews(Reviews reviews) throws Exception;

	ArrayList<Reviews> fetchReviews(HashMap<String, String> requestInfo);

	String bookUser(UserBooking userBooking) throws Exception;
	 
	ArrayList<UserBooking> fetchUserBooking() throws Exception;
	//String bookUser(User users);

	ArrayList<UserBooking> fetchConfirmedBookings() throws Exception;


}


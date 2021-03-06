package com.musicrecord.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.musicrecord.client.GreetingService;
import com.musicrecord.client.widgets.SubmitReview;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.User;
import com.musicrecord.shared.UserBooking;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

    HttpSession session;
    MusicHelper musicHelper = new MusicHelper();

    @Override
    public User signIn(String userid, String password) throws Exception {

	return musicHelper.signIn(userid, password);
    }

    @Override
    public ArrayList<Records> fetchRecords(HashMap<String, String> map) throws Exception {
	return musicHelper.fetchRecords(map);
    }

    @Override
    public String saveRecord(Records record) throws Exception {
	return musicHelper.saveRecord(record);
    }

    @Override
    public String deleteRecord(Records record) throws Exception {
	return musicHelper.deleteRecord(record);
    }

    @Override
    public ArrayList<Category> fetchCategories() throws Exception {
	return musicHelper.fetchCategories();
    }

	@Override
	public String signup(User user) throws Exception {
		return musicHelper.signup(user);
		 
	}

	@Override
	public String saveReviews(Reviews reviews) throws Exception {
		// TODO Auto-generated method stub
		return musicHelper.saveReview(reviews);
	}

	@Override
	public ArrayList<Reviews> fetchReviews(HashMap<String, String> requestInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reviews> fetchReviews() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String bookUser(UserBooking userBooking) throws Exception {
		// TODO Auto-generated method stub
		return musicHelper.bookUser(userBooking);
	}

	@Override
	public ArrayList<UserBooking> fetchUserBooking() throws Exception {
		// TODO Auto-generated method stub
		return musicHelper.fetchUserBooking();
	}

	@Override
	public ArrayList<UserBooking> fetchConfirmedBookings() throws Exception {
		// TODO Auto-generated method stub
		return musicHelper.fetchConfirmedBookings() ;
	}


//	@Override
//	public String bookUser(String message, Date bookDate, Date bookTime) {
//		// TODO Auto-generated method stub
//		return null;
//	}


 

}

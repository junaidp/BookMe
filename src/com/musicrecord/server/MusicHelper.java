package com.musicrecord.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musicrecord.database.MySQLRdbHelper;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.User;
import com.musicrecord.shared.UserBooking;

public class MusicHelper {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    MySQLRdbHelper rdbHelper = (MySQLRdbHelper) ctx.getBean("ManagerExams");

    public User signIn(String userid, String password) throws Exception {

	User user = (User) rdbHelper.getAuthentication(userid, password);
	if (user != null) {
	    // session = getThreadLocalRequest().getSession(true);
	    //
	    // session.setAttribute("user", user);
	}
	return user;
    }
     public String signup(User user) throws Exception{
    	return rdbHelper.saveUser(user);
     }

    public ArrayList<Records> fetchRecords(HashMap<String, String> map) throws Exception {

	return rdbHelper.fetchRecords(map);
    }

    public String saveRecord(Records record) throws Exception {
	return rdbHelper.saveRecord(record);
    }

    public String deleteRecord(Records record) throws Exception {
	return rdbHelper.deleteRecord(record);
    }

    public ArrayList<Category> fetchCategories() throws Exception {

	return rdbHelper.fetchCategories();//save review method rehta
    }

	 public String saveReview(Reviews reviews) throws Exception {
		 return rdbHelper.saveReview(reviews);
    }


	
	public String bookUser(UserBooking userBooking) throws Exception {
		// TODO Auto-generated method stub
		return rdbHelper.bookUser(userBooking);
	}
	public ArrayList<UserBooking> fetchUserBooking() throws Exception {
		// TODO Auto-generated method stub
		return rdbHelper.fetchUserBooking();
	}

 
	 
}

package com.musicrecord.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.musicrecord.client.widgets.SubmitReview;
import com.musicrecord.shared.Category;
import com.musicrecord.shared.HibernateDetachUtility;
import com.musicrecord.shared.Records;
import com.musicrecord.shared.Reviews;
import com.musicrecord.shared.User;

public class MySQLRdbHelper {

    private SessionFactory sessionFactory;
    Logger logger;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public User getAuthentication(String userid, String password) throws Exception {

	User users = null;
	Session session = null;
	try {
	    session = sessionFactory.openSession();

	    Criteria crit = session.createCriteria(User.class);
	    crit.add(Restrictions.eq("name", userid));
	    crit.add(Restrictions.eq("password", password));
	    crit.createAlias("roleId", "role");

	    List rsList = crit.list();
	    for (Iterator it = rsList.iterator(); it.hasNext();) {
		users = (User) it.next();
		System.out.println(users.getPassword());
	    }

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in getAuthentication", ex.getMessage()), ex);
	    System.out.println("Exception occured in getAuthentication" + ex.getMessage());

	    throw new Exception("Exception occured in getAuthentication");
	} finally {
	    session.close();
	}

	return users;
    }
    //Getting Category ID
    public int getCategoryID(String keyWord) throws Exception {

    	Category category = null;
    	Session session = null;
    	try {
    	    session = sessionFactory.openSession();

    	    Criteria crit = session.createCriteria(Category.class);
    	    if(keyWord.length() > 0)
    	    crit.add(Restrictions.eq("categoryname", keyWord));
    	
    	    List rsList = crit.list();
    	    if(rsList.size()<=0)
    	    	return 0;
    	    for (Iterator it = rsList.iterator(); it.hasNext();) {
    		category = (Category) it.next();
    		System.out.println(category.getCategoryid());
    	    }

    	} catch (Exception ex) {
    	    logger.warn(String.format("Exception occured in getCategoryID", ex.getMessage()), ex);
    	    System.out.println("Exception occured in getCategoryID" + ex.getMessage());

    	    throw new Exception("Exception occured in getCategoryID");
    	} finally {
    	    session.close();
    	}

    	return category.getCategoryid();
        }


    public ArrayList<Records> fetchRecords(HashMap<String, String> map) throws Exception {
	Session session = null;
	int count = 0;
//	String searchBy = map.get("searchBy");
     String keyWord = map.get("keyWord");

	// GET ID FROM NAME..
	int categoryId = getCategoryID(keyWord);
	if(categoryId == 0)
		return null;
	ArrayList<Records> listRecords = new ArrayList<Records>();
	try {
	    session = sessionFactory.openSession();

	    Criteria crit = session.createCriteria(Records.class);
	
	    crit.createAlias("category", "cat");
	    crit.add(Restrictions.eq("cat.categoryid", categoryId));
	    if (keyWord.trim().length() > 0) {
//		if (searchBy.equalsIgnoreCase("title")) {
//		    crit.add(Restrictions.ilike("title", keyWord, MatchMode.START));
//		} else if (searchBy.equalsIgnoreCase("artist")) {
//		    crit.add(Restrictions.like("artist", keyWord, MatchMode.START));
//		} else if (searchBy.equals("All")) {
//		    Disjunction disc = Restrictions.disjunction();
//		    disc.add(Restrictions.like("artist", keyWord, MatchMode.START));
//		    disc.add(Restrictions.like("title", keyWord, MatchMode.START));
//		    crit.add(disc);
//		}
	    }
	    count = crit.list().size();
//	    crit.setMaxResults(Integer.parseInt(map.get("length")));
//	    String sortorder = map.get("sortOrder");
//	    crit.setFirstResult(Integer.parseInt(map.get("start")));
//	    if (sortorder.equalsIgnoreCase("asc")) {
//		crit.addOrder(Order.asc(map.get("sortField")));
//	    } else {
//		crit.addOrder(Order.desc(map.get("sortField")));
//	    }
	    List rsList = crit.list();
	    for (Iterator it = rsList.iterator(); it.hasNext();) {
		Records record = (Records) it.next();
		ArrayList<Reviews> review = fetchReviews(record.getRecordId());
		record.setCount(count);
		record.setReviews(review);
		// HibernateDetachUtility.nullOutUninitializedFields(review,
			//	    HibernateDetachUtility.SerializationType.SERIALIZATION);

		// HibernateDetachUtility.nullOutUninitializedFields(record,
			//	    HibernateDetachUtility.SerializationType.SERIALIZATION);

			
		listRecords.add(record);
		
	    }
	    return listRecords;

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in Fetch Records", ex.getMessage()), ex);
	    throw new Exception("Exception occured in Fetch Records");
	} finally {
	    session.close();
	}

    }

    public String saveRecord(Records record) throws Exception {
	Session session = null;

	try {
	    session = sessionFactory.openSession();
	    session.saveOrUpdate(record);
	    session.flush();
	    return "Record Saved";

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in save record", ex.getMessage()), ex);
	    throw new Exception("Exception occured in save record");
	} finally {
	    session.close();
	}
    }

    public String saveUser(User user) throws Exception {
    	Session session = null;

    	try {
    	    session = sessionFactory.openSession();
    	    session.saveOrUpdate(user);
    	    session.flush();
    	    return "User is Saved";

    	} catch (Exception ex) {
    	    logger.warn(String.format("Exception occured in saving user", ex.getMessage()), ex);
    	    throw new Exception("Exception occured in saving user");
    	} finally {
    	    session.close();
    	}
        }
    public String deleteRecord(Records record) throws Exception {
	Session session = null;

	try {
	    session = sessionFactory.openSession();
	    session.delete(record);
	    session.flush();
	    return "record deleted";

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in Delete Record", ex.getMessage()), ex);
	    throw new Exception("Exception occured in Delete Record");
	} finally {
	    session.close();

	}
    }

    public ArrayList<Category> fetchCategories() throws Exception {
	Session session = null;

	ArrayList<Category> listCategories = new ArrayList<Category>();
	try {
	    session = sessionFactory.openSession();

	    Criteria crit = session.createCriteria(Category.class);

	    List csList = crit.list();

	    for (Iterator it = csList.iterator(); it.hasNext();) {

		Category category = (Category) it.next();
		listCategories.add(category);

	    }
	    return listCategories;

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in Fetch Categories", ex.getMessage()), ex);
	    throw new Exception("Exception occured in fetchCategories");
	} finally {
	    session.close();
	}

    }
    
	public ArrayList<Reviews> fetchReviews(int recordId) throws Exception {
		Session session = null;

		ArrayList<Reviews> listReviews = new ArrayList<Reviews>();
		try{
		    session = sessionFactory.openSession();

		    Criteria crit = session.createCriteria(Reviews.class);
		    crit.createAlias("recordId", "rec");
		    crit.createAlias("rec.category", "catre");
		    crit.add(Restrictions.eq("rec.records", recordId));
		    List csList = crit.list();

		    for (Iterator it = csList.iterator(); it.hasNext();) {

			Reviews reviews = (Reviews) it.next();
		    HibernateDetachUtility.nullOutUninitializedFields(reviews,
				    HibernateDetachUtility.SerializationType.SERIALIZATION);

			listReviews.add(reviews);
			
		    }
		   // if(listReviews.size()<1) return null;
		    return listReviews;
		   

		} catch (Exception ex) {
		    logger.warn(String.format("Exception occured in Fetch Reviews", ex.getMessage()), ex);
		    throw new Exception("Exception occured in fetchCategories");
		} finally {
		    session.close();
		}
		
	}

	public String saveReview(Reviews reviews) throws Exception {
		Session session = null;

		try {
		    session = sessionFactory.openSession();
		    Reviews rv = new Reviews();
		    rv.setDesc("");
		    rv.setRecordId(null);
		    rv.setReviews(2);
		    session.save(rv);
		    session.flush();
		    return "Reviews Saved";

		} catch (Exception ex) {
		    logger.warn(String.format("Exception occured in save reviews", ex.getMessage()), ex);
		    throw new Exception("Exception occured in save reviews");
		} finally {
		    session.close();
		}
	}
    public String saveReview(SubmitReview submitReview) throws Exception {
	Session session = null;

	try {
	    session = sessionFactory.openSession();
	    session.saveOrUpdate(submitReview);
	    session.flush();
	    return "Reviews  Saved";

	} catch (Exception ex) {
	    logger.warn(String.format("Exception occured in save Reviews", ex.getMessage()), ex);
	    throw new Exception("Exception occured in save Reviews");
	} finally {
	    session.close();
	}
    }
public String BookMe(String s) throws Exception{
	Session session = null;
	try{
		session = sessionFactory.openSession();
		return "rpc is called";
	}	
		catch (Exception ex) {
		    logger.warn(String.format("Exception occured in save Reviews", ex.getMessage()), ex);
		    throw new Exception("records not saved");
		} finally {
		    session.close();
		}

	

	
}
public String bookUser(User users ) throws Exception {
	return "From server";

}
}

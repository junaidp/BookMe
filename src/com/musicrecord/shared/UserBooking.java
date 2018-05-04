package com.musicrecord.shared;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.cglib.core.TinyBitSet;

@Entity
@Table(name="booking")
public class UserBooking implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "bookingid")
	    private int bookingId;

	    @Column(name = "date")
	    private Date date;
	  
	    @Column(name = "time")
	    private Date time;

	  
  
	    @Column(name = "message")
	    private String message;

	    @Column(name = "userID")
	    private int userid;

	    @Column(name = "confirmed")
	    private boolean confirmed;


	    
		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public Date getTime() {
			return time;
		}



		public void setTime(Date time) {
			this.time = time;
		}



		public String getMessage() {
			return message;
		}



		public void setMessage(String message) {
			this.message = message;
		}



		public int getUserid() {
			return userid;
		}



		public void setUserid(int userid) {
			this.userid = userid;
		}



		public boolean getConfirmed() {
			return confirmed;
		}



		public void setConfirmed(boolean confirmed) {
			this.confirmed = confirmed;
		}

}


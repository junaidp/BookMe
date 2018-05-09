package com.musicrecord.shared;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity

@Table(name = "records")
public class Records implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recordsid")
    private int records;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @JoinColumn(name = "categoryid")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    
    @JoinColumn(name = "userid")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    
    @Column(name = "displayimage")
    private String displayImage;

    @Column(name = "description")
    private String musicDescription;
    
    @Transient
    private ArrayList<Reviews> reviews;
   
	@Transient
    private int count;

    public int getRecordId() {
	return records;
    }

    public void setRecords(int records) {
	this.records = records;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getArtist() {
	return artist;
    }

    public void setArtist(String artist) {
	this.artist = artist;
    }

    public Category getCategory() {
	return category;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

    public int getCount() {
	return count;
    }

    public void setCount(int count) {
	this.count = count;
    }

	public String getDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(String displayImage) {
		this.displayImage = displayImage;
	}

	public String getMusicDescription() {
		return musicDescription;
	}

	public void setMusicDescription(String musicDescription) {
		this.musicDescription = musicDescription;
	}

	public ArrayList<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Reviews> reviews) {
		this.reviews = reviews;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}

package com.musicrecord.shared;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reviewid")
	private int reviewId;

	@Column(name="reviews")
	private int reviews;

	@JoinColumn(name = "recordid")
	@ManyToOne(fetch = FetchType.LAZY)
	private Records recordId;

	@Column(name = "desc")
	private String desc;
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public Records getRecordId() {
		return recordId;
	}

	public void setRecordId(Records recordId) {
		this.recordId = recordId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	

}

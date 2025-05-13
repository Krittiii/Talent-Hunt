package com.code.talent.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="talent")
public class Talent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="talent_id")
	private int talent_id;
	
	@Column(name="title",length=50,nullable=false)
	private String title;
	
	@Column(name="description",length=100,nullable=false)
	private String description;
	
	@Column(name="videoURL",length=200,nullable=false)
	private String videoURL;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private talentStatus status;
	
	/*private String status; (Open, closed , funded) */
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user_id;
	
	
	public enum talentStatus {
        OPEN, CLOSED
    }
	
	public Talent() {
		this.talent_id=0;
		this.title = null;
		this.description = null;
		this.videoURL = null;
		this.user_id = null;
		this.status=null;
	
	}

	public Talent(String title, String description, String videoURL, talentStatus status, Users user_id) {
		super();
		this.title = title;
		this.description = description;
		this.videoURL = videoURL;
		this.status = status;
		this.user_id = user_id;
	}

	public int getTalent_id() {
		return talent_id;
	}

	public void setTalent_id(int talent_id) {
		this.talent_id = talent_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public talentStatus getStatus() {
		return status;
	}

	public void setStatus(talentStatus status) {
		this.status = status;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Talent [talent_id=" + talent_id + ", title=" + title + ", description=" + description + ", videoURL="
				+ videoURL + ", status=" + status + ", user_id=" + user_id + "]";
	}

	
	
}


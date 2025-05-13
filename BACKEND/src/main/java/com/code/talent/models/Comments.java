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
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int comment_id;
	
	@Column(name="score")
    private int score;
	
	@Column(name="remark")
	private String remark;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status",nullable=false)
	private Status status;
	
	@Column(name="judge_name")
	private String judge_name;
	
	
	@ManyToOne
	@JoinColumn(name="talent_id")
	private Talent talent;
	
	
	public enum Status {
		PENDING, ACCEPTED, REJECTED
	}
	
	public Comments() {
		this.comment_id = 0;
		this.status = null;
		this.talent = null;
		this.score = 0;
		this.remark = null;
		this.judge_name=null;
		 
		

	}

	public Comments( int score, String remark, Status status, String judge_name, Talent talent) {
		
		this.score = score;
		this.remark = remark;
		this.status = status;
		this.judge_name = judge_name;
		this.talent = talent;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getJudge_name() {
		return judge_name;
	}

	public void setJudge_name(String judge_name) {
		this.judge_name = judge_name;
	}

	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", score=" + score + ", remark=" + remark + ", status=" + status
				+ ", judge_name=" + judge_name + ", talent=" + talent + "]";
	}
	

	
	
	
}


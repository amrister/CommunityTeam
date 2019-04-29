package com.arena.communityapi.post;

import com.arena.communityapi.comment.Comment;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Post {
	
	@Id
	public ObjectId _id;
	
	private String text,privacy,date;
	private Integer userId,votesUp,VotesDown;
	
	private List<Comment> comments = new ArrayList<>();
	
	public Post(){
		setVotesUp(0);
		setVotesDown(0);
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Post(ObjectId id,String t, String p, Integer uId, int vUp, int vDown){
		_id = id;
		text = t;
		privacy = p;
		userId = uId;
		votesUp = vUp;
		VotesDown= vDown;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getVotesUp() {
		return votesUp;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public void setVotesUp(Integer votesUp) {
		this.votesUp = votesUp;
	}
	public Integer getVotesDown() {
		return VotesDown;
	}
	public void setVotesDown(Integer votesDown) {
		VotesDown = votesDown;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

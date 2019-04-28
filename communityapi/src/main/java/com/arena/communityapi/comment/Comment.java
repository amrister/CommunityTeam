package com.arena.communityapi.comment;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Comment {
	
	@Id
	public ObjectId _id;
	
	private String text,date;
	private String userId;
	
	public Comment(){
		
	}
	
	public Comment(String t, String d, ObjectId id,String uID){
		this.text = t;
		this.setDate(d);
		this._id = id;
		this.setUserId(uID); 
	}
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

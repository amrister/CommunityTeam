package com.swe.test.postController;

public class Post {
	
	private String text,privacy;
	private Integer userId,postID,votesUp,VotesDown;
	
	public Post(){
		setVotesUp(0);
		setVotesDown(0);
	}
	public Post(String t, String p, Integer id){
		text = t;
		privacy = p;
		userId = id;
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
	public void setVotesUp(Integer votesUp) {
		this.votesUp = votesUp;
	}
	public Integer getVotesDown() {
		return VotesDown;
	}
	public void setVotesDown(Integer votesDown) {
		VotesDown = votesDown;
	}
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
}

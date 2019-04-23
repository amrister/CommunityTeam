package arenaposting.com.comments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import arenaposting.com.posts.Post;

@Entity
public class Comment {
	
	@Id
	private Integer commentID;
	private Integer userID;
	private String text,date;
	private Integer userId;
	
	@ManyToOne
	private Post post;
	public Comment(){
		
	}
	public Comment(String t, String d, Integer cID,Integer pID,Integer uID){
		text = t;
		setDate(d);
		commentID = cID;
		setUserID(uID);
		this.post = new Post();
		this.post.setPostID(pID); 
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

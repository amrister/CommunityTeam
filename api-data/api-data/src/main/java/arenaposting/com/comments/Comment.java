package arenaposting.com.comments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import arenaposting.com.posts.Post;

@Entity
public class Comment {
	
	@Id
	private String commentID;
	private String text,date;
	private String userId;
	
	@ManyToOne
	private Post post;
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comment(){
		
	}
	public Comment(String t, String d, String cID,String pID,String uID){
		super();
		this.text = t;
		this.setDate(d);
		this.commentID = cID;
		this.setUserId(uID);
		this.post = new Post();
		this.post.setId(pID); 
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

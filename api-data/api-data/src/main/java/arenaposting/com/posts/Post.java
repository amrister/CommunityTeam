package arenaposting.com.posts;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	private String id;
	private String text,privacy;
	private Integer userId,votesUp,VotesDown;
	
	public Post(){
		setVotesUp(0);
		setVotesDown(0);
	}
	public Post(String pID){
		id = pID;
	}
	public Post(String pID,String t, String p, Integer uId, int vUp, int vDown){
		id = pID;
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
	public void setVotesUp(Integer votesUp) {
		this.votesUp = votesUp;
	}
	public Integer getVotesDown() {
		return VotesDown;
	}
	public void setVotesDown(Integer votesDown) {
		VotesDown = votesDown;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

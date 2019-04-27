package arenaposting.com.comments;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import arenaposting.com.posts.Post;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	// Get All Comment Of Some Post By PostID
	@RequestMapping("/post/{postID}/comments")
	public List<Comment> getAllComments(@PathVariable String postID){
		return commentService.getAllComments(postID);
	}
	
	// Get a Certain Comment By CommentID
	@RequestMapping("/post/{postID}/comment/{id}")
	public Comment getComment(@PathVariable("id") String commentID){
		return commentService.getComment(commentID);
	}

	// Create a New Comment
	@RequestMapping(method = RequestMethod.POST, value = "/post/{postID}/comment") 
	public String addComment(@RequestBody Comment newComment, @PathVariable String postID){
		newComment.setPost(new Post(postID));
		commentService.addComment(newComment);
		return newComment.getUserId();
	}
	
	// Update a Certain Comment By CommentID
	@RequestMapping(method = RequestMethod.PUT, value = "/post/{postID}/comment/{commentID}") 
	public String updateComment(@RequestBody Comment newComment,@PathVariable String postID,@PathVariable String commentID){
		newComment.setPost(new Post(postID));
		commentService.updateComment(newComment,commentID);
		return newComment.getUserId();
	}
	
	// Delete a Certain Comment By CommentID
	@RequestMapping(method = RequestMethod.DELETE, value="/post/{postID}/comment/{commentID}")
	public void deleteComment(@PathVariable String commentID) {
		 commentService.deleteComment(commentID);
	}
	
}
package arenaposting.com.comments;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	
	// Get All Post Of Some User By UserID
	@RequestMapping("/comment/{commentID}")
	public List<Comment> getAllComments(@PathVariable int commentID){
		return commentService.getAllComments(commentID);
	}
	
	// Get a Certain Post By commentID
	@RequestMapping("/comment/{id}")
	public Comment getComment(@PathVariable("id") int commentID){
		return commentService.getComment(commentID);
	}

	// Create a New Post
	@RequestMapping(method = RequestMethod.POST, value = "/add_comment") 
	public int addComment(@RequestBody Comment newComment){
		commentService.addComment(newComment);
		return newComment.getUserId();
	}
	
	// Update a Certain Post By commentID
	@RequestMapping(method = RequestMethod.PUT, value = "/update_comment/{commentID}") 
	public int updateComment(@RequestBody Comment newComment,@PathVariable int commentID){
		commentService.updateComment(newComment,commentID);
		return newComment.getUserId();
	}
	
	// Delete a Certain Post By commentID
	@RequestMapping(method = RequestMethod.DELETE, value="/delete_comment/{commentID}")
	public void deleteComment(@PathVariable int commentID) {
		 commentService.deleteComment(commentID);
	}
		
}



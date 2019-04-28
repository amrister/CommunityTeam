package com.arena.communityapi.comment;

import com.arena.communityapi.post.PostController;
import com.arena.communityapi.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.bson.types.ObjectId;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostController postController;
	
	// Get All Comment Of Some Post By PostID
	@RequestMapping("/post/{postID}/comments")
	public List<Comment> getAllComments(@PathVariable ObjectId postID){
		return commentRepository.findAll();
	}
	
	// Get a Certain Comment By CommentID
	@RequestMapping("/post/{postID}/comment/{id}")
	public Comment getComment(@PathVariable ObjectId postID , @PathVariable("id") ObjectId id){
		return commentRepository.findBy_id(id);
	}

	// Create a New Comment
	@RequestMapping(method = RequestMethod.POST, value = "/post/{postID}/comment") 
	public void addComment(@Valid @RequestBody Comment newComment, @PathVariable ObjectId postID){
		newComment.set_id(ObjectId.get());
		postController.addComment(newComment,postID);
		commentRepository.save(newComment);
	}
	
	// Update a Certain Comment By CommentID
	@RequestMapping(method = RequestMethod.PUT, value = "/post/{postID}/comment/{commentID}") 
	public void updateComment(@RequestBody Comment newComment,@PathVariable ObjectId postID,@PathVariable ObjectId commentID){
		newComment.set_id(commentID);
		postController.addComment(newComment,postID);
		commentRepository.save(newComment);
	}
	
	// Delete a Certain Comment By CommentID
	@RequestMapping(method = RequestMethod.DELETE, value="/post/{postID}/comment/{id}")
	public void deleteComment(@PathVariable ObjectId postID, @PathVariable ObjectId id) {
		postController.deleteComment(id,postID);
		 commentRepository.delete(commentRepository.findBy_id(id));
	}

}
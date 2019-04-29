package com.arena.communityapi.post;

import com.arena.communityapi.comment.Comment;
import com.arena.communityapi.repositories.PostRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	// Get All Post Of Some User By UserID
	@RequestMapping("/posts/{userID}")
	public List<Post> getAllPosts(@PathVariable int userID){
		return postRepository.findAll();
	}
	
	// Get a Certain Post By PostID
	@RequestMapping("/post/{id}")
	public Post getPost(@PathVariable("id") ObjectId id){
		return postRepository.findBy_id(id);
	}

	// Create a New Post
	@RequestMapping(method = RequestMethod.POST, value = "/post") 
	public void createPost(@Valid @RequestBody Post newPost){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    newPost.setDate(formatter.format(date));
		newPost.set_id(ObjectId.get());
		postRepository.save(newPost);
	}
	
	// Update a Certain Post By PostID
	@RequestMapping(method = RequestMethod.PUT, value = "/post/{id}") 
	public void updatePost(@Valid @RequestBody Post newPost, @PathVariable("id") ObjectId id) {
		newPost.set_id(id);
		postRepository.save(newPost);
	}
	
	// Delete a Certain Post By PostID
	@RequestMapping(method = RequestMethod.DELETE, value="/post/{id}")
	public void deletePet(@PathVariable ObjectId id) {
		postRepository.delete(postRepository.findBy_id(id));
	}
	
	public void addComment(Comment newComment, ObjectId postID){
		Post comPost = new Post();
		comPost = postRepository.findBy_id(postID);
		comPost.set_id(postID);
		comPost.getComments().add(newComment);
		postRepository.save(comPost);
	}
	
	public void updateComment(Comment newComment, ObjectId postID){
		Post comPost = new Post();
		comPost = postRepository.findBy_id(postID);
		int commentIndex = 0;
		for(int i = 0; i < comPost.getComments().size();i++){
			System.out.println(comPost.getComments().get(i).get_id());
			if(comPost.getComments().get(i).get_id().equals(newComment.get_id())){
				commentIndex = i;
				break;
			}
		}
		comPost.getComments().set(commentIndex, newComment);
		postRepository.save(comPost);
	}
	
	public void deleteComment(ObjectId commentID, ObjectId postID){
		Post comPost = new Post();
		comPost = postRepository.findBy_id(postID);
		comPost.set_id(postID);
		comPost.getComments().removeIf(t -> t.get_id().equals(commentID));
		postRepository.save(comPost);
	}
		
}
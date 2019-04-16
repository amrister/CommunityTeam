package com.swe.test.postController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;

	
	// Get All Post Of Some User By UserID
	@RequestMapping("/posts/{userID}")
	public List<Post> getAllPosts(@PathVariable int userID){
		return postService.getAllPosts(userID);
	}
	
	// Get a Certain Post By PostID
	@RequestMapping("/post/{id}")
	public Post getPost(@PathVariable("id") int postID){
		return postService.getPost(postID);
	}

	// Create a New Post
	@RequestMapping(method = RequestMethod.POST, value = "/publish_post") 
	public int deletePost(@RequestBody Post newPost){
		postService.addPost(newPost);
		return newPost.getUserId();
	}
	
	// Update a Certain Post By PostID
	@RequestMapping(method = RequestMethod.PUT, value = "/update_post/{postID}") 
	public int updatePost(@RequestBody Post newPost,@PathVariable int postID){
		postService.updatePost(newPost,postID);
		return newPost.getUserId();
	}
	
	// Delete a Certain Post By PostID
	@RequestMapping(method = RequestMethod.DELETE, value="/delete_post/{postID}")
	public void deletePost(@PathVariable int postID) {
		 postService.deletePost(postID);
	}
		
}



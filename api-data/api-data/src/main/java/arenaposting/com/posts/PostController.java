package arenaposting.com.posts;

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
	public Post getPost(@PathVariable("id") String id){
		return postService.getPost(id);
	}

	// Create a New Post
	@RequestMapping(method = RequestMethod.POST, value = "/post") 
	public String createPost(@RequestBody Post newPost){
		postService.addPost(newPost);
		return newPost.getId();
	}
	
	// Update a Certain Post By PostID
	@RequestMapping(method = RequestMethod.PUT, value = "/post/{id}") 
	public int updatePost(@RequestBody Post newPost,@PathVariable int id){
		postService.updatePost(newPost,id);
		return newPost.getUserId();
	}
	
	// Delete a Certain Post By PostID
	@RequestMapping(method = RequestMethod.DELETE, value="/post/{id}")
	public void deletePost(@PathVariable String id) {
		 postService.deletePost(id);
	}
		
}



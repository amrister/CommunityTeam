package com.swe.test.postController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GetController {
	
	@RequestMapping(value = "/get_post")
	
	public ResponseEntity<Post> get() {
	    Post post = new Post();
	    post.setText("Blue");
	    post.setUserId(100);
	    post.setPrivacy("pub");
	    return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
}

package com.swe.test.postController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private List<Post> posts = new ArrayList<>(Arrays.asList(
			new Post("Star","Sar",5),
			new Post("John","Web",10),
			new Post("Snow","Deep",25)
			));

	public List<Post> getAllPosts(int userID){
		return posts;
	}
	public Post getPost(int postID){
		return posts.stream().filter(t -> t.getUserId().equals(postID)).findFirst().get();
	}
	public void addPost(Post newPost) {
		posts.add(newPost);
	}
	public void updatePost(Post newPost, int postID) {
		for(int i = 0;i<posts.size();i++){
			if(posts.get(i).getUserId() == postID) {
				posts.set(i, newPost);
				return;
			}
		}
	}
	public void deletePost(int postID){
		posts.removeIf(t -> t.getUserId().equals(postID));
	}
}

package arenaposting.com.posts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public List<Post> getAllPosts(int userID){
		List<Post> posts = new ArrayList<>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}
	public Post getPost(int postID){
		return postRepository.findById(postID).get();
	}
	public void addPost(Post newPost) {
		postRepository.save(newPost);
	}
	public void updatePost(Post newPost, int postID) {
		postRepository.save(newPost);
	}
	public void deletePost(int postID){
		postRepository.deleteById(postID);
	}
}

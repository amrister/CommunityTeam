package arenaposting.com.comments;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String>{
	
	public List<Comment> findByPostId(String postId);
	
}

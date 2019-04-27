package arenaposting.com.comments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	public List<Comment> getAllComments(String postID){
		List<Comment> comments = new ArrayList<>();
		commentRepository.findByPostId(postID).forEach(comments::add);
		return comments;
	}
	public Comment getComment(String commentID){
		return commentRepository.findById(commentID).get();
	}
	public void addComment(Comment newComment) {
		commentRepository.save(newComment);
	}
	public void updateComment(Comment newComment, String commentID) {
		commentRepository.save(newComment);
	}
	public void deleteComment(String commentID){
		commentRepository.deleteById(commentID);
	}
}

package arenaposting.com.comments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	public List<Comment> getAllComments(int postID){
		List<Comment> comments = new ArrayList<>();
		commentRepository.findAll().forEach(comments::add);
		return comments;
	}
	public Comment getComment(int commentID){
		return commentRepository.findById(commentID).get();
	}
	public void addComment(Comment newComment) {
		commentRepository.save(newComment);
	}
	public void updateComment(Comment newComment, int commentID) {
		commentRepository.save(newComment);
	}
	public void deleteComment(int commentID){
		commentRepository.deleteById(commentID);
	}
}

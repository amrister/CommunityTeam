
package com.arena.communityapi.repositories;

import com.arena.communityapi.comment.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
	Comment findBy_id(ObjectId _id);
}


package com.arena.communityapi.repositories;

import com.arena.communityapi.post.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
  Post findBy_id(ObjectId _id);
}
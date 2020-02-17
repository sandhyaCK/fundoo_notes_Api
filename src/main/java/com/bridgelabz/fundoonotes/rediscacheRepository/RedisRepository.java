/*package com.bridgelabz.fundoonotes.rediscacheRepository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisRepository {
	
		private static final String key = "notes";
		private RedisTemplate<String, Object> redisTemplate;
		private HashOperations<String, Long, Object> hashOperations;

		public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
			this.redisTemplate = redisTemplate;
			hashOperations = redisTemplate.opsForHash();
		}

		public void save(NoteData note) {
	//S		hashOperations.put("note", note.getId(), note);
		}

		public void save(NoteData user) {
			hashOperations.put("note", user.getUserId(), user);
		}
}
*/
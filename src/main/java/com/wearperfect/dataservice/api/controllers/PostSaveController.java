package com.wearperfect.dataservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wearperfect.dataservice.api.dto.PostSaveDTO;
import com.wearperfect.dataservice.api.service.PostSaveService;

@RestController
public class PostSaveController {
	
	@Autowired
	PostSaveService postSaveService;

	@PostMapping(path = "/users/{userId}/posts/{postId}/saves")
	Long savePost(@PathVariable(name = "userId", required = true) Long userId,
			@PathVariable(name = "postId", required = true) Long postId) {
		return postSaveService.savePost(userId, postId);
	}
	
	@DeleteMapping(path = "/users/{userId}/posts/{postId}/saves")
	Long unSavePost(@PathVariable(name = "userId", required = true) Long userId,
			@PathVariable(name = "postId", required = true) Long postId) {
		return postSaveService.unSavePost(userId, postId);
	}
}

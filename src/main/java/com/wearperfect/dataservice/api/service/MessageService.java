package com.wearperfect.dataservice.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wearperfect.dataservice.api.dto.MessageDTO;
import com.wearperfect.dataservice.api.dto.PostDTO;
import com.wearperfect.dataservice.api.dto.UserContactMessageDetailsDTO;
import com.wearperfect.dataservice.api.dto.UserContactSuggestionsDTO;
import com.wearperfect.dataservice.api.dto.UserPostsResponseDTO;

public interface MessageService {

	UserContactSuggestionsDTO getUserContactSuggestionsByUserId(Long userId);
	
	List<UserContactMessageDetailsDTO> getCommunicatedUserContactsByUserId(Long userId);

	UserPostsResponseDTO getUserMessagesWith(Long sentBy, Long sentTo);

	UserPostsResponseDTO sendMessage(Long sentBy, String name, MessageDTO messageDto, MultipartFile[] files);

	PostDTO deleteMessage(Long sentBy, Long messageId);

}
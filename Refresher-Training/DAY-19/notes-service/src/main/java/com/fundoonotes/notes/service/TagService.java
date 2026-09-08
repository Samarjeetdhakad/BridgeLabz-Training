package com.fundoonotes.notes.service;

import java.util.List;

import com.fundoonotes.notes.dto.request.TagRequestDTO;
import com.fundoonotes.notes.dto.response.TagResponseDTO;


public interface TagService {

	TagResponseDTO createTag(TagRequestDTO request);

	List<TagResponseDTO> getAllTags();

	void deleteTag(int tagId);
}

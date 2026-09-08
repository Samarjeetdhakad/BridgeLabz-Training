package com.fundoonotes.notes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonotes.notes.dto.request.TagRequestDTO;
import com.fundoonotes.notes.dto.response.TagResponseDTO;
import com.fundoonotes.notes.entity.Tag;
import com.fundoonotes.notes.exception.DuplicateTagException;
import com.fundoonotes.notes.exception.TagNotFoundException;
import com.fundoonotes.notes.mapper.TagMapper;
import com.fundoonotes.notes.repository.TagRepository;
import com.fundoonotes.notes.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;
	private final TagMapper tagMapper;

	public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {

		this.tagRepository = tagRepository;
		this.tagMapper = tagMapper;
	}

	@Override
	public TagResponseDTO createTag(TagRequestDTO request) {

		if (tagRepository.findByName(request.getName()).isPresent()) {
			throw new DuplicateTagException(request.getName());
		}

		Tag tag = tagMapper.toEntity(request);

		Tag savedTag = tagRepository.save(tag);

		return tagMapper.toResponseDTO(savedTag);
	}

	@Override
	public List<TagResponseDTO> getAllTags() {

		return tagRepository.findAll().stream().map(tagMapper::toResponseDTO).toList();
	}

	@Override
	public void deleteTag(int tagId) {

		Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new TagNotFoundException(tagId));

		tagRepository.delete(tag);
	}
}

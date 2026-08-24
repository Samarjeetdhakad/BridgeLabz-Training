package com.fundoo.specification;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.fundoo.entity.Notes;
import com.fundoo.entity.User;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class NoteSpecifications {

	public static Specification<Notes> search(User owner, String titleText, Notes.NoteState state, String tagName) {

		return (root, query, criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();

			// Always restrict notes to logged-in user
			predicates.add(criteriaBuilder.equal(root.get("owner"), owner));

			// Title filter
			if (titleText != null && !titleText.isBlank()) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
						"%" + titleText.toLowerCase() + "%"));
			}

			// State filter
			if (state != null) {
				predicates.add(criteriaBuilder.equal(root.get("state"), state));
			}

			// Tag filter
			if (tagName != null && !tagName.isBlank()) {
				Join<Notes, ?> tagJoin = root.join("tags", JoinType.INNER);
				predicates.add(criteriaBuilder.equal(tagJoin.get("name"), tagName));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
package com.jorgea.PFC.specification;

import com.jorgea.PFC.model.GenresModel;
import org.springframework.data.jpa.domain.Specification;

public class GenresSpecification {

    public static Specification<GenresModel> hasGenreName(String genreName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("genreName")), "%" + genreName.toLowerCase() + "%");
    }

}

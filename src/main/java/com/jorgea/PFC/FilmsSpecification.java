package com.jorgea.PFC;

import com.jorgea.PFC.model.FilmsModel;
import org.springframework.data.jpa.domain.Specification;

public class FilmsSpecification {

    public static Specification<FilmsModel> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<FilmsModel> hasGenreName(String genreName){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("genreName")), "%" + genreName.toLowerCase() + "%");
    }

}

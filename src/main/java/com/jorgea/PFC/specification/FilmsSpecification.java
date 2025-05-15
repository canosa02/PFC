package com.jorgea.PFC.specification;

import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.model.GenresModel;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class FilmsSpecification {

    public static Specification<FilmsModel> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<FilmsModel> hasGenreName(String genreName){
        return (root, query, criteriaBuilder) -> {
            Join<FilmsModel, GenresModel> join = root.join("genres", JoinType.LEFT);
            return criteriaBuilder.like(criteriaBuilder.lower(join.get("genreName")), "%" + genreName.toLowerCase() + "%");
        };
    }

}

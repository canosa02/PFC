package com.jorgea.PFC.specification;

import com.jorgea.PFC.model.GamesModel;
import com.jorgea.PFC.model.GenresModel;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class GamesSpecification {

    public static Specification<GamesModel> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<GamesModel> hasGenreName(String genreName){
        return (root, query, criteriaBuilder) -> {
            Join<GamesModel, GenresModel> join = root.join("genres", JoinType.LEFT);
            return criteriaBuilder.like(criteriaBuilder.lower(join.get("genreName")), "%" + genreName.toLowerCase() + "%");
        };
    }

}

package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.GenresModel;
import com.jorgea.PFC.to.GenresNameTo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T12:01:58+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class GenresModelMapperImpl implements GenresModelMapper {

    @Override
    public GenresModel toGenresModel(GenresNameTo genresNameTo) {
        if ( genresNameTo == null ) {
            return null;
        }

        GenresModel genresModel = new GenresModel();

        return genresModel;
    }

    @Override
    public List<GenresModel> toGenresModelList(List<GenresNameTo> genresNameToList) {
        if ( genresNameToList == null ) {
            return null;
        }

        List<GenresModel> list = new ArrayList<GenresModel>( genresNameToList.size() );
        for ( GenresNameTo genresNameTo : genresNameToList ) {
            list.add( toGenresModel( genresNameTo ) );
        }

        return list;
    }
}

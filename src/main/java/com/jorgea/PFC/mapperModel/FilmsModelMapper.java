package com.jorgea.PFC.mapperModel;

import com.jorgea.PFC.model.FilmsModel;
import com.jorgea.PFC.to.FilmsTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmsModelMapper {

    FilmsTo toFilmsTo(FilmsModel filmsModel);

    FilmsModel toFilmsModel(FilmsTo filmsTo);


}

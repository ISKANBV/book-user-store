package az.ingress.bookstore.mapper;

import az.ingress.bookstore.dto.BookDTO;
import az.ingress.bookstore.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO toDTO(BookEntity entity);
    BookEntity toEntity(BookDTO dto);
}

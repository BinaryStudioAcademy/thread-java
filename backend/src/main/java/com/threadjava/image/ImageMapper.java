package com.threadjava.image;

import com.threadjava.image.dto.ImageDto;
import com.threadjava.image.model.Image;
import org.mapstruct.factory.Mappers;

public interface ImageMapper {
    ImageMapper MAPPER = Mappers.getMapper( ImageMapper.class );

    ImageDto imageToImageDto(Image image);
}

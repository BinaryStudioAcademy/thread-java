package com.threadjava.image;

import com.threadjava.models.Image;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface ImageRepository  extends CrudRepository<Image, UUID> {
}
package com.threadjava.image;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.threadjava.image.dto.ImageDto;
import com.threadjava.image.dto.GyazoResponce;
import com.threadjava.image.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Value(value = "${gyazo.access-token}")
    private String GYAZO_ACCESS_TOKEN;
    @Value(value = "${gyazo.upload-url}")
    private String GYAZO_UPLOAD_URL;
    @Autowired
    ImageRepository imageRepository;

    public ImageDto upload(MultipartFile file) throws IOException {
        var result = this.uploadFile(file.getResource());
        var image = new Image();
        image.setLink(result.getUrl());
        image.setDeleteHash("");
        var imageEntity = imageRepository.save(image);
        return ImageMapper.MAPPER.imageToImageDto(imageEntity);
    }

    private GyazoResponce uploadFile(Resource imageResource) throws JsonProcessingException {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        var body = new LinkedMultiValueMap<>();
        body.add("imagedata", imageResource);
        body.add("access_token", GYAZO_ACCESS_TOKEN);

        var requestEntity = new HttpEntity<>(body, headers);

        var restTemplate = new RestTemplate();
        var response = restTemplate.postForEntity(GYAZO_UPLOAD_URL, requestEntity, String.class);
        var json = response.getBody();
        var mapper = new ObjectMapper();
        return mapper.readValue(json, GyazoResponce.class);
    }


}

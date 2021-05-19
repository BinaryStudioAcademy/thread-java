package com.threadjava.image;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.threadjava.image.dto.ImageDto;
import com.threadjava.image.dto.ImgurResponce;
import com.threadjava.image.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Value(value = "${imgur.id}")
    private String IMGUR_ID;
    @Autowired
    ImageRepository imageRepository;

    public ImageDto upload(MultipartFile file) throws IOException {
        var result = this.uploadFile(file.getBytes());
        var image = new Image();
        image.setLink(result.getData().getLink());
        image.setDeleteHash(result.getData().getDeletehash());
        var imageEntity = imageRepository.save(image);
        return ImageMapper.MAPPER.imageToImageDto(imageEntity);
    }

    private ImgurResponce uploadFile(byte[] bytes) throws JsonProcessingException {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Authorization", "Client-ID " + IMGUR_ID);

        var body = new LinkedMultiValueMap<>();
        body.add("image", bytes);

        var requestEntity = new HttpEntity<>(body, headers);

        var serverUrl = "https://api.imgur.com/3/image";

        var restTemplate = new RestTemplate();
        var response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);
        var json = response.getBody();
        var mapper = new ObjectMapper();
        return mapper.readValue(json, ImgurResponce.class);
    }


}

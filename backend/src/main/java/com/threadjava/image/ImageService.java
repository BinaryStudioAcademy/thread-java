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
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Value(value = "${imgur.id}")
    private String IMGUR_ID;
    @Value(value = "${imgur.secret}")
    private String IMGUR_SECRET;
    @Autowired
    ImageRepository imageRepository;

    public ImageDto upload(MultipartFile file) throws IOException {
        var result = this.uploadFile(file.getBytes());
        var image = new Image();
        image.setLink(result.data.link);
        image.setDeleteHash(result.data.deletehash);
        var imageEntity = imageRepository.save(image);
        return ImageMapper.MAPPER.imageToImageDto(imageEntity);
    }

    private ImgurResponce uploadFile(byte[] bytes) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Authorization", "Client-ID " + IMGUR_ID);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("image", bytes);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "https://api.imgur.com/3/upload";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);
        var json = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        ImgurResponce parser = mapper.readValue(json, ImgurResponce.class);
        return parser;
    }


}

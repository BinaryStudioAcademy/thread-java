package com.threadjava.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Component
public class WsSender {
    private final SimpMessagingTemplate template;
    private final ObjectMapper mapper;

    public WsSender(SimpMessagingTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public <T> Consumer<T> getSender() {
//        ObjectWriter writer = mapper
//                .setConfig(mapper.getSerializationConfig())
//                .writerWithView(view);

        return (T payload) -> {
//            String value = null;

//            try {
//                value = writer.writeValueAsString(payload);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }

            template.convertAndSend(
                    "/topic/activity",
                    payload
//value
//                    new WsEventDto(objectType, eventType, value)
            );
        };
    }
}
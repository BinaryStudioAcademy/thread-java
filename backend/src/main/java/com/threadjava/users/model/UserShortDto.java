package com.threadjava.users.model;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

public class UserShortDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String username;
    @Getter @Setter public String imageId;
}

package com.onpu.web.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChannelsDto {
    String userId;
    List<String> channelsId;
}

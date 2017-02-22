package com.xebia.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CreateGameRequest {

    @JsonProperty("user_id")
    @NotNull(message = "user_id can't be null")
    private String userId;

    @JsonProperty("full_name")
    @NotNull(message = "full_name can't be null")
    private String fullName;

    @JsonProperty("spaceship_protocol")
    @NotNull
    @Valid
    private SpaceShipProtocol spaceShipProtocol;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SpaceShipProtocol getSpaceShipProtocol() {
        return spaceShipProtocol;
    }

    public void setSpaceShipProtocol(SpaceShipProtocol spaceShipProtocol) {
        this.spaceShipProtocol = spaceShipProtocol;
    }
}

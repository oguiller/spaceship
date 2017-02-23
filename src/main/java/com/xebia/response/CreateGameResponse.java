package com.xebia.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateGameResponse {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("starting")
    private String starting;

    public CreateGameResponse(String userId, String fullName, String gameId, String starting) {
        this.userId = userId;
        this.fullName = fullName;
        this.gameId = gameId;
        this.starting = starting;
    }

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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }
}

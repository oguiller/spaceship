package com.xebia.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SalvoResponse {

    @JsonProperty("salvo")
    private Map<String, String> salvo;

    @JsonProperty("game")
    private Map<String, String> game;

    public SalvoResponse(Map<String, String> salvo, Map<String, String> game) {
        this.salvo = salvo;
        this.game = game;
    }

    public Map<String, String> getSalvo() {
        return salvo;
    }

    public void setSalvo(Map<String, String> salvo) {
        this.salvo = salvo;
    }

    public Map<String, String> getGame() {
        return game;
    }

    public void setGame(Map<String, String> game) {
        this.game = game;
    }
}

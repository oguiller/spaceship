package com.xebia;

import com.xebia.entity.Game;
import com.xebia.request.CreateGameRequest;
import com.xebia.response.CreateGameResponse;
import com.xebia.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

    @Autowired
    GameService gameService;

    @PostMapping(value = "/game/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CreateGameResponse createNewGame(@Valid @RequestBody CreateGameRequest request) {

        Game game = gameService.createNewGame(request.getUserId(), request.getFullName(), request.getSpaceShipProtocol());
        CreateGameResponse createGameResponse = new CreateGameResponse();
        createGameResponse.setUserId(game.getSelf().getUserId());
        createGameResponse.setFullName(game.getSelf().getFullName());
        createGameResponse.setGameId(game.getGameId());
        createGameResponse.setStarting(game.getOpponent().getUserId());

        return createGameResponse;
    }

}

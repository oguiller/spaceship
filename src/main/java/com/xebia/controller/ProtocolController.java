package com.xebia.controller;

import com.xebia.entity.Game;
import com.xebia.entity.Player;
import com.xebia.request.CreateGameRequest;
import com.xebia.request.SalvoRequest;
import com.xebia.response.CreateGameResponse;
import com.xebia.response.SalvoResponse;
import com.xebia.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GameService gameService;

    @PostMapping(value = "/game/new")
    public CreateGameResponse createNewGame(@Valid @RequestBody CreateGameRequest request) {
        log.info("CREATING A NEW GAME");

        Game game = gameService.createNewGame(request.getUserId(), request.getFullName(), request.getSpaceShipProtocol());

        final String userId = game.getSelf().getUserId();
        final String opponentUserId = game.getOpponent().getUserId();
        final String fullName = game.getSelf().getFullName();
        final String gameId = game.getGameId();

        CreateGameResponse createGameResponse = new CreateGameResponse(userId, fullName, gameId, opponentUserId);

        return createGameResponse;
    }

    @PutMapping(value = "/game/{gameId}")
    public SalvoResponse gettingFired(@PathVariable String gameId, @RequestBody SalvoRequest request){
        log.info("I AM GETTING FIRED!! {}", gameId);

        Map<String, String> salvo = gameService.gettingFired(request.getSalvo(), gameId);
        Player player = gameService.getTurn(gameId);
        Map<String, String> game = new HashMap<>();
        game.put("player_turn", player.getUserId());

        return new SalvoResponse(salvo, game);
    }

}

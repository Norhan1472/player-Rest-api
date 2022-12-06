package com.springapi.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.player.model.Player;
import com.springapi.player.service.PlayerService;

@RestController
@RequestMapping("/play")
public class PlayerController {
	
	private PlayerService playerService;
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping("/player")
	public List<Player> getAllData() {
		return playerService.getPlayers();
	}

}
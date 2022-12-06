package com.springapi.player.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.player.exception.PlayerException;
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
	
	@GetMapping("/getPlayer/{id}")
	public Player getPlayerById(@PathVariable("id") long id) {
		Player p = playerService.EditPlayer(id);
		if(p==null) {
			 throw new PlayerException("Error");
		}
		return p;
	}
	
	@PostMapping("/addPlayer")
	public Player addPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
		return player;
	}
	
	@PutMapping("/editPlayer")
	public Player editPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
		return player;
	}
	
	@DeleteMapping("/deletePlayer/{id}")
	public String deletePlayer(@PathVariable("id") long id) {
		Player p = playerService.EditPlayer(id);
		if(p==null) {
			 throw new PlayerException("Error");
		}
		playerService.deletePlayer(id);
		return "Deleted Successfully";
	}

}

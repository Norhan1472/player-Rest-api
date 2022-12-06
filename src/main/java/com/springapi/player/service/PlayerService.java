package com.springapi.player.service;


import java.util.List;

import org.springframework.validation.BindingResult;

import com.springapi.player.model.Player;

public interface PlayerService {

	public List<Player>getPlayers();
	
	public void addPlayer(Player player);
	
	public Player EditPlayer(long id);
	
	public void deletePlayer(long id);
}

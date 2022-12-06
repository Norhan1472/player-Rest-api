package com.springapi.player.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.springapi.player.model.Player;

public interface PlayerDao {
	
	public List<Player>getAllPlayers();
	public void savePlayer(Player palyer);
	public Player updatePlayer(long id);
	public void deletePlayer(long id);
}

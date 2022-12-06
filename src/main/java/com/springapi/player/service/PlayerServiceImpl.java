package com.springapi.player.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.springapi.player.dao.PlayerDao;
import com.springapi.player.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	PlayerDao playerDao;
	
	@Autowired
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}


	@Override
	@Transactional
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return playerDao.getAllPlayers();
	}


	@Override
	@Transactional
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		System.out.println(player.getName());
		playerDao.savePlayer(player);
		
	}


	@Override
	@Transactional
	public Player EditPlayer(long id) {
		// TODO Auto-generated method stub
		return playerDao.updatePlayer(id);
	}


	@Override
	@Transactional
	public void deletePlayer(long id) {
		// TODO Auto-generated method stub
		playerDao.deletePlayer(id);
	}

}

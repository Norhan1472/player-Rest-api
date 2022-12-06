package com.springapi.player.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springapi.player.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public PlayerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
       Session session = sessionFactory.getCurrentSession();
		Query<Player> query = session.createQuery("from Player",Player.class);
		List<Player>p=query.getResultList();

		
		
		return query.getResultList();
	  
	}


	@Override
	public void savePlayer(Player palyer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(palyer);
	}

	@Override
	public Player updatePlayer(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Player.class,id);
	}


	@Override
	public void deletePlayer(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		Query q =session.createQuery("delete from Player where id=?1");
		q.setLong(1, id);
		q.executeUpdate();
	}

}

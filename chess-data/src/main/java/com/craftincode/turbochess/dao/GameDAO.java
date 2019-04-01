package com.craftincode.turbochess.dao;

import com.craftincode.turbochess.domain.Game;

import java.util.List;

public class GameDAO implements DAO<Game,Integer> {

    public List<Game> findAll(){
        return null;
    }

    @Override
    public Game findById(Integer id) {
        return null;
    }

    public void update(Game game){

    }

    public void create(Game game){

    }

    public void delete(Game game){

    }

}

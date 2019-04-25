package com.craftincode.turbochess.data.player;

import com.craftincode.turbochess.data.common.DAO;
import com.craftincode.turbochess.domain.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO<Player, Integer> {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Player> findAll() throws SQLException {

//        Connection connection = ConnectionUtils.getConnection();

        String sql = "select * from player";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Player> players = new ArrayList<>();

        Integer playerId;
        String nick,password,email;
        while (rs.next()){
            playerId = rs.getInt("player_id");
            nick = rs.getString("nick");
            password = rs.getString("password");
            email = rs.getString("email");
            Player p = new Player(playerId,nick,password,email);
            players.add(p);
        }



        return players;
    }

    @Override
    public Player findById(Integer id) {
        return null;
    }

    @Override
    public void create(Player player) {

    }

    @Override
    public void update(Player player) {

    }

    @Override
    public void delete(Player player) {

    }
}

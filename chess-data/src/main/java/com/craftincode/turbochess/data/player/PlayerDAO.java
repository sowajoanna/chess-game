package com.craftincode.turbochess.data.player;

import com.craftincode.turbochess.data.common.DAO;
import com.craftincode.turbochess.domain.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO<PlayerDTO, Integer> {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PlayerDTO> findAll() throws SQLException {
        String sql = "select player_id, nick, password, email from player";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<PlayerDTO> players = new ArrayList<>();

        Integer playerId;
        String nick, password, email;
        while (rs.next()) {
            playerId = rs.getInt("player_id");
            nick = rs.getString("nick");
            password = rs.getString("password");
            email = rs.getString("email");
            PlayerDTO p = new PlayerDTO(playerId, nick, password, email);
            players.add(p);
        }
        return players;
    }

    @Override
    public PlayerDTO findById(Integer id) {
        return null;
    }

    @Override
    public void create(PlayerDTO player) throws SQLException {
        String sql = "INSERT INTO player (nick, password, email) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,player.getNick());
        ps.setString(2,player.getPassword());
        ps.setString(3,player.getEmail());
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.first()){
            player.setPlayerId(generatedKeys.getInt(1));
        }
    }

    @Override
    public void update(PlayerDTO player) {

    }

    @Override
    public void delete(PlayerDTO player) {

    }
}

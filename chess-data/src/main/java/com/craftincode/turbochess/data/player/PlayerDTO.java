package com.craftincode.turbochess.data.player;

public class PlayerDTO {
    private Integer playerId;
    private String nick,password,email;

    public PlayerDTO(Integer playerId, String nick, String password, String email) {
        this.playerId = playerId;
        this.nick = nick;
        this.password = password;
        this.email = email;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "playerId=" + playerId +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

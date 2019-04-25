package com.craftincode.turbochess.data.player;

import com.craftincode.turbochess.data.common.EntityMapper;
import com.craftincode.turbochess.domain.Player;

public class PlayerEntityMapper implements EntityMapper<Player,PlayerDTO> {
    @Override
    public Player convertToEntity(PlayerDTO dto) throws Exception {
        return new Player(dto.getPlayerId(),dto.getNick(),dto.getPassword(),dto.getEmail());
    }

    @Override
    public PlayerDTO convertToDTO(Player entity) throws Exception {
        return new PlayerDTO(entity.getPlayerId(),entity.getNick(),entity.getPassword(),entity.getEmail());
    }
}

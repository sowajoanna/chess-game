package com.craftincode.turbochess.domain;

import java.time.LocalDateTime;

public class Game {
        private Integer gameId;
        private Player playerWhite;
        private Player playerBlack;
        private Player winner;
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;
}

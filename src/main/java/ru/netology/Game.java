package ru.netology;


import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        //реализация метода регистрации
        players.add(player);
    }

    public byte round(String playerName1, String playerName2) {
        // написать метод соревнования м/у двумя игроками
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null && player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered "
                            + " and " +
                            "Player with name: " + playerName2 + " not registered "
            );
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered "
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not registered "
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;

    }

}




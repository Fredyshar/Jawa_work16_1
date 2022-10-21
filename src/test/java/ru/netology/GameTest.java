package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Batman", 20);
    Player player2 = new Player(2, "Superman", 20);
    Player player3 = new Player(3, "Robin", 15);
    Player player4 = new Player(4, "Joker", 40);


    @Test
    public void allPlayersRegistered() {                    //все икроки зарегестрированы

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        byte actual = game.round("Batman", "Superman");
        byte expected = 0;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void firstPlayerNotRegistered() {                  //первый игрок не зарегестрирован
        Game game = new Game();
        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Joker", "Superman");
        });
//        byte actual = game.round("Superman", "Joker");
//        System.out.println(actual);
    }

    @Test
    public void secondPlayerNotRegistered() {                  //второй игрок не зарегестрирован
        Game game = new Game();
        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Superman", "Joker");
        });
//        byte actual = game.round("Superman", "Joker");
//        System.out.println(actual);
    }

    @Test
    public void twoPlayersNotRegistered() {                  //два игрока не зарегестрированы
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Robin", "Joker");
        });
//        byte actual = game.round("Robin", "Joker");
//        System.out.println(actual);
    }

    @Test
    public void strengthPlayersEqual() {                 //силы игроков равны
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        byte expected = 0;
        byte actual = game.round("Batman", "Superman");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void strengthPlayer1More() {                 //силы игрока 1 больше
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        byte expected = 1;
        byte actual = game.round("Batman", "Robin");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void strengthPlayer2More() {                 //силы игрока 2 больше
        Game game = new Game();
        game.register(player1);
        game.register(player4);

        byte expected = 2;
        byte actual = game.round("Batman", "Joker");

        Assertions.assertEquals(actual, expected);
    }

}

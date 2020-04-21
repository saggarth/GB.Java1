package Lesson_7;

import javax.swing.*;

public class Game {
    private GameBoard board;                                // Ссылка на игровое поле
    private GamePlayer[] gamePlayers = new GamePlayer[2];   // Массив игроков
    private int playersTurn = 0;                            // Индекс текущего игрока

    public Game(){
        this.board = new GameBoard(this);
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    /**
     * Метод передачи хода
     */
    void passTurn(){
        if(playersTurn == 0){
            playersTurn = 1;
        } else {
            playersTurn = 0;
        }
    }

    void setPlayersTurn() {
        playersTurn = 0;
    }

    /**
     * Получение объекта текущего игрока
     * @return GamePlayer объект игрока
     */
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }

    /**
     * Метод показа всплывающих сообщения для пользователя
     * @param messageText - текс тообщений
     */
    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText); //Вызываем диалоговое окно с привязкой к игровому полю с передаваемым сообщением
    }
}
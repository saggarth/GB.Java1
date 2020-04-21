package Lesson_7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;  // Передаем номер ряда, номер столбца и ссылку на кнопку, к которой привязыаем наш GameActionListener
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья");
                board.emptyField();
            } else {
                if (!board.getGame().getCurrentPlayer().isRealPlayer()) {
                    updateByAiData(board);
                }
            }
        } else {
            board.getGame().showMessage("Некорректный ход");
        }
    }

    /**
     *
     * if (!currentGame.getCurrentPlayer().isRealPLayer())
     * currentGame.getCurrentPlayer().updateByAiData(button);
    * Ход человека
    *
    * @param board GameBoard() - ссылка на игровое поле
    */
    private void updateByPlayersData(GameBoard board) {
        // Обновляем матрицу игры
        board.updateGameField(row, cell);
        // Обновляем содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        // После хода проверим состояние победы
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    /**
     * Ход компьютера
     *
     * @param board GameBoard() - ссылка на игровое поле
     */
    private void updateByAiData(GameBoard board) {
        // Генерация координат хода компьютера
        int maxScoreFieldX = -1, maxScoreFieldY = -1, maxScore = 0, x = -1, y = -1;

        Random random = new Random();

        for (int i = 0; i < GameBoard.dimension; i++){
            for (int j = 0; j < GameBoard.dimension; j++){
                int fieldScore = 0;

                if (board.isTurnable(i, j)){
                    if (i-1 >= 0 && j-1 >= 0 && board.isAiSymbol(i-1, j-1)){//leftTop
                        fieldScore++;
                    }
                    if (i-1 >= 0 && board.isAiSymbol(i-1, j)){//top
                        fieldScore++;
                    }
                    if (i-1 >= 0 && j+1 < GameBoard.dimension && board.isAiSymbol(i-1,j+1)){//rightTop
                        fieldScore++;
                    }
                    if (j+1 < GameBoard.dimension && board.isAiSymbol(i,j+1)){//right
                        fieldScore++;
                    }
                    if (i+1 < GameBoard.dimension && j+1 < GameBoard.dimension && board.isAiSymbol(i+1,j+1)){//rightBot
                        fieldScore++;
                    }
                    if (i+1 < GameBoard.dimension && board.isAiSymbol(i+1, j)){//bot
                        fieldScore++;
                    }
                    if (i+1 < GameBoard.dimension && j-1 >= 0 && board.isAiSymbol(i+1,j-1)){//leftBot
                        fieldScore++;
                    }
                    if (j-1 >= 0 && board.isAiSymbol(i,j-1)){//left
                        fieldScore++;
                    }
                }
                if (fieldScore > maxScore){
                    maxScore = fieldScore;
                    maxScoreFieldX = j;
                    maxScoreFieldY = i;
                }
            }
        }

        if (maxScoreFieldX != -1){
            x = maxScoreFieldY;
            y = maxScoreFieldX;
        }

        if (maxScore == 0){
            do {
                x = random.nextInt(GameBoard.dimension);
                y = random.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x,y));
        }
        // Обновим матрицу игры
        board.updateGameField(x, y);

        // Обновим содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        // Проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }
}
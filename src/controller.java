import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private GridPane grid;
    private char currentPlayer = 'X';
    private Button[][] buttons=new Button[3][3];

    @FXML
    void clicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));
            if (checkForWin(currentPlayer)) {
                System.out.println(currentPlayer + " wins!");
                // Handle win condition
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                // Handle draw condition
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                computerMove();
            }
        }

    }

    @FXML
    void initialize(ActionEvent event) {
        buttons[0][0]=button1;
        buttons[0][1]=button2;
        buttons[0][2]=button3;
        buttons[1][0]=button4;
        buttons[1][1]=button5;
        buttons[1][2]=button6;
        buttons[2][0]=button7;
        buttons[2][1]=button8;
        buttons[2][2]=button9;
    }

    private boolean isBoardFull() {
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                if (button.getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkForWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(player))
                    && buttons[i][1].getText().equals(String.valueOf(player))
                    && buttons[i][2].getText().equals(String.valueOf(player))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(player))
                    && buttons[1][i].getText().equals(String.valueOf(player))
                    && buttons[2][i].getText().equals(String.valueOf(player))) {
                return true;
            }
        }
        if (buttons[0][0].getText().equals(String.valueOf(player))
                && buttons[1][1].getText().equals(String.valueOf(player))
                && buttons[2][2].getText().equals(String.valueOf(player))) {
            return true;
        }
        if (buttons[0][2].getText().equals(String.valueOf(player))
                && buttons[1][1].getText().equals(String.valueOf(player))
                && buttons[2][0].getText().equals(String.valueOf(player))) {
            return true;
        }
        return false;
    }
    private void computerMove() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!buttons[x][y].getText().isEmpty());
        buttons[x][y].setText(String.valueOf(currentPlayer));
        if (checkForWin(currentPlayer)) {
            System.out.println(currentPlayer + " wins!");
        } else if (isBoardFull()) {
            System.out.println("It's a draw!");
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

}

import model.MapModel;
import view.game.*;
import view.login.LoginFrame;
import view.game.GameStartInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // initialize the login frame
            LoginFrame loginFrame = new LoginFrame(280, 280);
            loginFrame.setVisible(true);

// only one mapModel; more levels should be added (for advanced point)
            MapModel mapModel = new MapModel(new int[][]{
//                    matrix provided by demo
//                    {1, 2, 2, 1},
//                    {1, 3, 2, 2},
//                    {1, 3, 4, 4},
//                    {0, 0, 4, 4}

                    // represent the matrix in an improved way
//                    {10, 20, 20, 13},
//                    {11, 30, 21, 21},
//                    {12, 30, 40, 40},
//                    {0, 0, 40, 40}

                    // matrix qualified for Task 2
                    {21, 21, 20, 20, 10},
                    {40, 40, 30, 12, 0},
                    {40, 40, 30, 13, 0},
                    {23, 23, 22, 22, 11}

            });

            // initialize the game frame`
            GameFrame gameFrame = new GameFrame(600, 450, mapModel);
            gameFrame.setVisible(false);
            loginFrame.setGameFrame(gameFrame);

            // turn the first two parameter into corresponding method output, when the log-in and game-saving are done
            GameStartInterface gameStartInterface = new GameStartInterface(true,true,280,280, gameFrame);
            gameStartInterface.setGameFrame(gameFrame);
            // the initial state (should be only the log-in interface)
            gameStartInterface.setVisible(false);
            loginFrame.setGameStartInterface(gameStartInterface);

        });
    }
}

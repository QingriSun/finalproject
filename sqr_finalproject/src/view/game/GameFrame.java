// a huge constructor, set up the window of the game
// how the buttons on the frame work remain to be done

package view.game;

import controller.GameController;
import model.MapModel;
import model.User;
import view.FrameUtil;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private GameController controller;
    private JButton restartBtn;
    private JButton loadBtn;
    private JButton withdrawBtn;

    //add
    private JButton saveBtn;
    private User user;
    private JLabel userLabel;


    private JLabel stepLabel;
    private GamePanel gamePanel;
    private MovementPanel movementPanel;
    private JPanel exitPanel;

    // constructor, new GameFrame(width, height, mapMadel)
    public GameFrame(int width, int height, MapModel mapModel, User user) {
// the title can be modified
        this.setTitle("2025 CS109 Project Demo");
        this.setLayout(null); // have no layout manager
        this.setSize(width, height);

        gamePanel = new GamePanel(mapModel);
        movementPanel = new MovementPanel(gamePanel);
        movementPanel.setLocation(width / 2 + 20, height / 2 - movementPanel.getHeight() / 2);
        this.add(movementPanel);
        int gamePanelX = 30;
        gamePanel.setLocation(gamePanelX, height / 2 - gamePanel.getHeight() / 2); // the y coordinate is dependent on the size of the frame and panel
        this.add(gamePanel);
        this.controller = new GameController(gamePanel, mapModel);

        //add
        this.user = user;
        this.userLabel = FrameUtil.createJLabel(this,(user != null) ? user.getUsername() : "Guest", new Font("serif", Font.ITALIC, 22), new Point(gamePanel.getWidth() + 80, 18), 180, 50);
        this.saveBtn = FrameUtil.createButton(this, "Save", new Point(gamePanel.getWidth() + 80, 310), 80, 50);

        // tell the user where the exit is
        exitPanel = new JPanel();
        exitPanel.setVisible(true);
        exitPanel.setSize(20, 2 * gamePanel.getGRID_SIZE());
        exitPanel.setLocation(gamePanel.getX() + gamePanel.getWidth(), gamePanel.getY() + gamePanel.getWidth() / 4);
        exitPanel.setBackground(Color.cyan);
        this.add(exitPanel);

        this.restartBtn = FrameUtil.createButton(this, "Restart", new Point(gamePanelX, height / 2 - 150), 80, 40);
        this.loadBtn = FrameUtil.createButton(this, "Load", new Point(gamePanelX + 80 + 20,height /2 -150), 80, 40);
        this.withdrawBtn = FrameUtil.createButton(this, "Withdraw", new Point(gamePanelX, height / 2 + 110), 80, 40);
        this.stepLabel = FrameUtil.createJLabel(this, "Start", new Font("serif", Font.ITALIC, 22), new Point(gamePanel.getWidth() + 80, 70), 180, 50);
        gamePanel.setStepLabel(stepLabel);

        this.restartBtn.addActionListener(e -> // e for event, induced by the system
        {
            controller.restartGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });

// this loadBtn.addActionListener remains to be complete (store the information, i.e. mapModel, path)
        this.loadBtn.addActionListener(e ->
        {
            // variable string stores the information of path
            String string = JOptionPane.showInputDialog(this /* the dialog will be at the centre of the parent component*/, "Input path:");

            // deleted in the teaching video
            System.out.println(string); //print to the terminal
            gamePanel.requestFocusInWindow();//enable key listener, 键盘
        });

        //add save button
        this.saveBtn.addActionListener( e -> {
            if (isGuest()) {
                JOptionPane.showMessageDialog(this, "Guests cannot save games!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                controller.saveGame(user);
                JOptionPane.showMessageDialog(this, "Game saved!");
            }
        });
        if (isGuest()) {
            saveBtn.setEnabled(false);
            saveBtn.setToolTipText("Guests cannot save games");
        }


        // get back to last state, and step --
        this.withdrawBtn.addActionListener(e ->{
            System.out.println("Withdraw");
            int[][] lastState = new int[gamePanel.getModel().getMatrix().length][gamePanel.getModel().getMatrix()[0].length];
            if (gamePanel.getStates().size() == 1) // the target last state is the initial state
            {
                lastState = gamePanel.getModel().getMatrixInitial();
            }
            else if (gamePanel.getStates().size() > 1)
            {
                // the last step is unwanted
                gamePanel.getStates().removeLast();
                lastState = gamePanel.getStates().getLast();
            }
            if (lastState != null) // when steps > 0
            {
                for ( int i = 0; i < gamePanel.getBoxes().size(); i++)
                {
                    gamePanel.remove(gamePanel.getBoxes().get(i));
                }
                gamePanel.getBoxes().clear();
                MapModel.copyMatrix(lastState, gamePanel.getModel().getMatrix());
                if (gamePanel.getSteps() > 0)
                {
                    gamePanel.setSteps(gamePanel.getSteps() - 1);
                    gamePanel.getStepLabel().setText(String.format("Step: %d", gamePanel.getSteps()));
                }
                gamePanel.initialGame();
            }
        });

        //todo: add other button here
        this.setLocationRelativeTo(null); // the window is placed in the centre of the screen
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set the location of the victoryInterface
        getGamePanel().getVictoryInterface().setLocationRelativeTo(getMovementPanel().getBtnRight());
    }

    //add
    public boolean isGuest() {
        return user == null;
    }

    public User getUser() {
        return user;
    }

    public GamePanel getGamePanel()
    {
        return gamePanel;
    }

    public MovementPanel getMovementPanel()
    {
        return movementPanel;
    }
}

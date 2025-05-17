package view.game;

import model.MapModel;
import view.FrameUtil;
import view.login.LoginFrame;
import view.Location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelInterface extends JFrame{
    private JButton lastLevelBtn;
    private JButton nextLevelBtn;
    private JButton startGameBtn;
    private JPanel levelPanel;
    private JPanel levelNamePanel;
    private ArrayList<Location> locations;
    ArrayList<LevelInterface> levelInterfaces;

    // multilevel
    private int[][][] levelMatrixs = {
            {{10, 20, 20, 13}, {11, 30, 21, 21}, {12, 30, 40, 40}, {0, 0, 40, 40}},
            {{21, 21, 20, 20, 10}, {40, 40, 30, 12, 0}, {40, 40, 30, 13, 0}, {23, 23, 22, 22, 11}},
            {{0, 20, 20, 10, 11}, {40, 40, 21, 21, 12}, {40, 40, 22, 22, 30}, {0, 23, 23, 13, 30}},
            {{20, 20, 10, 21, 21}, {40, 40, 11, 30, 0}, {40, 40, 12, 30, 0}, {22, 22, 13, 23, 23}},
//            {{10, 11, 20, 20, 0}, {40, 40, 21, 21, 30}, {40, 40, 22, 22, 30}, {12, 13, 23, 23, 0}}
            {{0, 11, 0, 0, 0}, {40, 40, 21, 21, 30}, {40, 40, 22, 22, 30}, {0, 13, 23, 23, 0}} // for code testing
    };
    private int[][] levelMatrix;

    private int level;
    static int LevelNumber = 1; // level = 1, 2, 3, 4, 5

    // change the boxes' position
    private GamePanel gamePanel;
    private GameFrame gameFrame;
    private JWindow jWindow;

    public LevelInterface(LoginFrame loginFrame) {
        this.setLayout(null);
        this.setSize(1200, 900);
        this.setTitle("Level Choosing");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.locations = loginFrame.getLocations();
        this.levelInterfaces = loginFrame.getLevelInterfaces();
        this.level = LevelNumber;
        this.levelMatrix = levelMatrixs[level - 1];
        LevelNumber++;

        lastLevelBtn = FrameUtil.createButton(this, "", new Point(20, this.getHeight() / 2 - 80), 40, 80);
        nextLevelBtn = FrameUtil.createButton(this, "", new Point(getWidth() - 100, getHeight() / 2 - 80), 40, 80);
        startGameBtn = FrameUtil.createButton(this, "Start Game", new Point(getWidth() / 2 - 120, getHeight() / 2 + 310), 240, 80);
        levelPanel = FrameUtil.createPanel(this, new Point(getWidth() / 2 - 350, getHeight() / 2 - 300), 720, 600, Color.LIGHT_GRAY);
        levelNamePanel = FrameUtil.createPanel(this, new Point(getWidth() / 2 - 400, getHeight() / 2 - 430), 800, 100, Color.DARK_GRAY);

        startGameBtn.addActionListener(e -> {
            if (this.gameFrame != null) {
                // change the map
                // the initial gameFrame create in Main is substituted by levelGameFrame
                GameFrame levelGameFrame = new GameFrame(gameFrame.getWidth(), gameFrame.getHeight(), new MapModel(levelMatrix), gameFrame.getUser());
                levelGameFrame.setjWindow(jWindow);
                levelGameFrame.getTimesUpFrame().setJWindow(jWindow);
                levelGameFrame.setTimeAttack(GameFrame.getTimeAttacks()[this.level - 1]);
                levelGameFrame.setLevel(this.level);
                // There is no correct timeAttack when newing levelGameFrame
                levelGameFrame.getTimeLabel().setText(String.format("Time: %02d : %02d", levelGameFrame.getTimeAttack() / 60, levelGameFrame.getTimeAttack() % 60));
                levelGameFrame.setVisible(true); // turn to the game-start frame
                levelGameFrame.getTimer().start();
                this.setVisible(false); // hide the register page
                for (int i = 0; i < LevelNumber - 1; i++)
                {
                    loginFrame.getLevelInterfaces().get(i).setVisible(false);
                }
            }
        });

        nextLevelBtn.addActionListener(e ->{
        if (getLevel() != 5) // if there is a next level to choose
        {
            levelInterfaces.get(getLevel() - 1).setVisible(false);
            levelInterfaces.get(getLevel()).setVisible(false);
            levelInterfaces.get(getLevel() - 1).setVisible(true);
            levelInterfaces.get(getLevel()).setVisible(true);
        }
        });

        lastLevelBtn.addActionListener(e ->{
            if (getLevel() != 1)
            {
                levelInterfaces.get(getLevel() - 1).setVisible(false);
                levelInterfaces.get(getLevel() - 2).setVisible(false);
                levelInterfaces.get(getLevel() - 1).setVisible(true);
                levelInterfaces.get(getLevel() - 2).setVisible(true);
            }
        });
    }

    public GamePanel getGamePanel()
    {
        return gamePanel;
    }

    public GameFrame getGameFrame() {return gameFrame;}

    public void setGameFrame(GameFrame gameFrame)
    {
        this.gameFrame = gameFrame;
    }

    public void setGamePanel(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }

    public void setjWindow(JWindow jWindow) {
        this.jWindow = jWindow;
    }

    public int getLevel()
    {
        return level;
    }

    public JPanel getLevelNamePanel()
    {
        return levelNamePanel;
    }

    public JPanel getLevelPanel()
    {
        return levelPanel;
    }
}

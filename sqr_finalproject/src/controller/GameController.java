// have methods to restart games, move boxes
// to have methods to reload games, save games

package controller;

import model.MapModel;
import model.SaveData;
import model.User;
import view.game.BoxComponent;
import view.game.GamePanel;
import model.Direction;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static javax.swing.SwingUtilities.paintComponent;


/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 * You can design several methods about the game logic in this class.
 */
public class GameController {
    private final GamePanel view;
    private final MapModel model;
    private int steps;

    // constructor of GameController
    // new GameController(view, madel);
    public GameController(GamePanel view, MapModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
    }



    public void restartGame() {
        System.out.println("Restart game");
        // repaint the panel; paint a grey panel first
        for ( int i = 0; i < view.getBoxes().size(); i++)
        {
            view.remove(view.getBoxes().get(i));
        }
        view.getBoxes().clear();
        MapModel.copyMatrix(model.getMatrixInitial(), model.getMatrix());
        view.initialGame();

        this.view.setSteps(-1); // there is a "step++" in the afterMove method
        this.view.afterMove();
    }


    //reset the mapModel and the parameter of the box
    public boolean doMove(int row, int col, Direction direction) {
        if (model.getId(row, col) != 0)
        {
            int row0 = row;
            int col0 = col;
            int Id = model.getId(row, col);
            int nextRow = row + direction.getRow();
            int nextCol = col + direction.getCol();
            boolean doMove = false;

            // move the 1 * 1 rectangular
            if (model.getId(row, col) / 10 == 1) // if there is s 1 * 1 rectangular in that place
            {
                if (model.checkInHeightSize(nextRow) && model.checkInWidthSize(nextCol)) // check if the rectangular get out of the boundary
                {
                    if (model.getId(nextRow, nextCol) == 0) // if the place to be occupied is empty (accessible)
                    {
                        model.getMatrix()[row][col] = 0; // make the place where the rectangular occupied to be empty
                        model.getMatrix()[nextRow][nextCol] = Id; // move the rectangular to the accessible place
                        doMove = true;
                    }
                }
            }

            // move the 1 * 2 rectangular
            if (model.getId(row, col) / 10 == 2)
            {
                // locate the left part of the rectangular
                // assume the selected grid is the right half
                int leftCol = col - 1;
                int rightCol;
                if (model.checkInWidthSize(leftCol) && model.getId(row, leftCol) == model.getId(row, col))
                {
                    rightCol = col;
                    col = leftCol; // Because the location of boxes are their left upper point
                }
                else
                {
                    rightCol = col + 1;
                    leftCol = col;
                }

                // modify the mapModel
                    if (direction == direction.LEFT && model.checkInWidthSize(nextCol)&& model.getMatrix()[nextRow][nextCol] == 0 )
                    {
                        model.getMatrix()[nextRow][nextCol] = Id;
                        model.getMatrix()[row][rightCol] = 0;
                        doMove = true;
                    }
                    else if (direction == direction.RIGHT && model.checkInWidthSize(nextCol + 1)&& model.getMatrix()[nextRow][nextCol + 1] == 0 )
                    {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[nextRow][nextCol + 1] = Id;
                        doMove = true;
                    }
                    else if (direction == direction.UP && model.checkInHeightSize(nextRow)&& model.getMatrix()[nextRow][nextCol + 1] == 0 && model.getMatrix()[nextRow][nextCol] == 0)
                    {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row][col + 1] = 0;
                        model.getMatrix()[nextRow][nextCol] = Id;
                        model.getMatrix()[nextRow][nextCol + 1] = Id;
                        doMove = true;
                    }
                    else if (direction == direction.DOWN && model.checkInHeightSize(nextRow) && model.getMatrix()[nextRow][nextCol + 1] == 0 && model.getMatrix()[nextRow][nextCol] == 0)
                    {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row][col + 1] = 0;
                        model.getMatrix()[nextRow][nextCol] = Id;
                        model.getMatrix()[nextRow][nextCol + 1] = Id;
                        doMove = true;
                    }
                col = col0;
            }

            // move the 2 * 1 box
            if (model.getId(row, col) / 10 == 3)
            {
                // find the upper one
                int upperRow;
                int lowerRow;
                // assume the other part is on the top
                upperRow = row - 1;
                lowerRow = row;
                if (model.checkInHeightSize(upperRow) && model.getId(upperRow, col) == Id)
                {
                    row = upperRow;
                }

                // move the box
                if (direction == Direction.UP && model.checkInHeightSize(nextRow) && model.getId(nextRow, nextCol) == 0)
                {
                    model.getMatrix()[nextRow][nextCol] = Id;
                    model.getMatrix()[row + 1][col] = 0;
                    doMove = true;
                }
                if (direction == Direction.DOWN && model.checkInHeightSize(nextRow + 1) && model.getId(nextRow + 1, nextCol) == 0)
                {
                    model.getMatrix()[nextRow + 1][nextCol] = Id;
                    model.getMatrix()[row][col] = 0;
                    doMove = true;
                }
                else if (direction == direction.LEFT && model.checkInWidthSize(nextCol) && model.getMatrix()[nextRow][nextCol] == 0 && model.getMatrix()[nextRow + 1][nextCol] == 0)
                {
                    model.getMatrix()[row][col] = 0;
                    model.getMatrix()[row + 1][col] = 0;
                    model.getMatrix()[nextRow][nextCol] = Id;
                    model.getMatrix()[nextRow + 1][nextCol] = Id;
                    doMove = true;
                }
                else if (direction == direction.RIGHT && model.checkInWidthSize(nextCol) && model.getMatrix()[nextRow][nextCol] == 0 && model.getMatrix()[nextRow + 1][nextCol] == 0)
                {
                    model.getMatrix()[row][col] = 0;
                    model.getMatrix()[row + 1][col] = 0;
                    model.getMatrix()[nextRow][nextCol] = Id;
                    model.getMatrix()[nextRow + 1][nextCol] = Id;
                    doMove = true;
                }
                row = row0;
                col = col0;

            }

            // move the 4 * 4 box
            if (model.getId(row, col) / 10 == 4)
            {
                // locate the left upper grid
                int upperRow;
                int lowerRow;
                int leftCol;
                int rightCol;
                // assume the selected grid is the lower right one
                upperRow = row - 1;
                lowerRow = row;
                leftCol = col - 1;
                rightCol = col;
                if (model.checkInHeightSize(upperRow) && model.checkInWidthSize(leftCol) && model.getId(upperRow,leftCol) == Id)
                {
                    row = upperRow;
                    col = leftCol;
                }
                // assume the selected grid is the lower left one
                upperRow = row - 1;
                lowerRow = row;
                rightCol = col + 1;
                leftCol = col;
                if (model.checkInWidthSize(rightCol) && model.checkInHeightSize(upperRow) && model.getId(upperRow, rightCol) == Id)
                {
                    row = upperRow;
                    col = leftCol;
                }
                // assume the selected grid is the upper right one
                upperRow = row;
                lowerRow = row + 1;
                leftCol = col - 1;
                rightCol = col;
                if (model.checkInHeightSize(lowerRow) && model.checkInWidthSize(leftCol) && model.getId(lowerRow, leftCol) == Id)
                {
                    row = upperRow;
                    col = leftCol;
                }

                //move the box
                if (direction == direction.UP && model.checkInHeightSize(nextRow) && model.getId(nextRow,nextCol) == 0 && model.getId(nextRow, nextCol + 1) == 0)
                {
                    model.getMatrix()[nextRow][nextCol] = Id;
                    model.getMatrix()[nextRow][nextCol + 1] = Id;
                    model.getMatrix()[row + 1][col] = 0;
                    model.getMatrix()[row + 1][col + 1] = 0;
                    doMove = true;
                }
                if (direction == Direction.DOWN && model.checkInHeightSize(nextRow + 1) && model.getId(nextRow + 1, nextCol) == 0 && model.getId(nextRow + 1, nextCol + 1) == 0)
                {
                    model.getMatrix()[nextRow + 1][nextCol + 1] = Id;
                    model.getMatrix()[nextRow + 1][nextCol] = Id;
                    model.getMatrix()[row][col] = 0;
                    model.getMatrix()[row][col + 1] = 0;
                    doMove = true;
                }
                if (direction == Direction.LEFT && model.checkInWidthSize(nextCol) && model.getId(nextRow, nextCol) == 0 && model.getId(nextRow + 1, nextCol) == 0)
                {
                    model.getMatrix()[nextRow][nextCol] = Id;
                    model.getMatrix()[nextRow + 1][nextCol] = Id;
                    model.getMatrix()[row][col + 1] = 0;
                    model.getMatrix()[row + 1][col + 1] = 0;
                    doMove = true;
                }
                if (direction == Direction.RIGHT && model.checkInWidthSize(nextCol + 1) && model.getId(nextRow, nextCol + 1) == 0 && model.getId(nextRow + 1, nextCol + 1) == 0)
                {
                    model.getMatrix()[nextRow][nextCol + 1] = Id;
                    model.getMatrix()[nextRow + 1][nextCol + 1] = Id;
                    model.getMatrix()[row][col] = 0;
                    model.getMatrix()[row + 1][col] = 0;
                    doMove = true;
                }
                row = row0;
                col = col0;
            }

            if (doMove)
            {
                // change the parameter of the corresponding component
                BoxComponent box = view.getSelectedBox();
                box.setRow(nextRow);
                box.setCol(nextCol);
                // ? what is the meaning of the magic number 2 ? : may be padding
                box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2); // GRID_SIZE is a final int 50
                box.repaint(); // repaint
                steps++;
                return true; // the rectangular is moved
            }
        }

        return false; // the rectangular can not be moved to the intended place (due to boundary or other rectangular)
    }

    //add
    public void saveGame(User user) {
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Guests cannot save games!");
            return;
        }

        try {
            // 1. 准备数据
            int[][] map = model.getMatrix();
            SaveData data = new SaveData(map, steps);

            // 2. 创建用户存档目录
            Path saveDir = Path.of("save", user.getUsername());
            Files.createDirectories(saveDir);

            // 3. 写入序列化文件
            Path saveFile = saveDir.resolve("save.dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(saveFile))) {
                oos.writeObject(data);
            }

            JOptionPane.showMessageDialog(null, "Game saved!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Save failed: " + e.getMessage());
        }
    }

    public boolean loadGame(User user) {
        if (user == null || user.getUsername() == null) {
            JOptionPane.showMessageDialog(null, "Invalid user data");
            return false;
        }

        Path saveFile = Paths.get("save", user.getUsername(), "save.dat");
        if (!Files.exists(saveFile)) {
            JOptionPane.showMessageDialog(null, "No saved game found");
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(saveFile))) {
            SaveData data = (SaveData) ois.readObject();
            // 更新模型
            model.setMatrix(data.getMapState());

            // 更新视图
            view.setSteps(data.getSteps());
            view.refresh();

            return true;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Save file format error");
            return false;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Load failed: " + e.getMessage());
            return false;
        }
    }


}

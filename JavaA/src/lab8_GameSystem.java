import java.util.ArrayList;

public class lab8_GameSystem {

    private ArrayList<lab8_Player> playerList = new ArrayList<>(); // 忘记new ArrayList<>()了

    public ArrayList<lab8_Player> getPlayerList()
    {
        return playerList;
    }

    public boolean checkPlayer(int pid)
    {
        for (int i = 0; i < playerList.size(); i++)
        {
            if (pid == playerList.get(i).getPid())
            {
                return true;
            }
        }
        return false;
    }

    public boolean addPlayer(lab8_Player player)
    {
        if (checkPlayer(player.getPid()))
        {
            return false;
        }
        else
        {
            playerList.add(player);
            return true;
        }
    }

}

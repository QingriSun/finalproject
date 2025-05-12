public class lab8_Player {
    private int pid;
    private String name;
    private static int playerCnt = 0;

    public lab8_Player(String name)
    {
        playerCnt++;
        pid = playerCnt;
        this.name = name;
    }

    public int getPid()
    {
        return pid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static int getPlayerCnt()
    {
        return playerCnt;
    }

    public String toString()
    {
        return String.format("Player: %s, pid: %d",name,pid);
    }
}

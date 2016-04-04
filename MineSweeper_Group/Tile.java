import java.util.Scanner;

/**
 * Created by juan on 4/4/2016.
 */
public class Tile
{
    private String tile;

    public Tile()
    {
        tile = "0";
    }

    public void setMine()
    {
        tile = "*";
    }

    public boolean isMine()
    {
        return tile.compareTo("*") == 0;
    }

    public void setTile(MineField mineField, Scanner kb)
    {

    }

    public void setHint()
    {
        if(isMine())
        {
            return;
        }
        else
        {
            String.valueOf(Integer.parseInt(tile) + 1);
        }
    }
}

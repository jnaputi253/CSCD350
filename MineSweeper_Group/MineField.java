/**
 * Created by juan on 4/4/2016.
 */
public class MineField
{
    private Tile[][] tiles;
    public MineField(int rows, int columns)
    {
        tiles = new Tile[rows + 2][columns + 2];

        for(int i = 0; i < rows; i ++)
        {
            for(int j = 0; j < columns; j ++)
            {
                tiles[i][j] = new Tile();
            }
        }
    }

    public Tile getTile(int row, int column)
    {
        return tiles[row][column];
    }
}

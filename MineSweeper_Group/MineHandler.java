import java.util.Scanner;

/**
 * Created by juan on 4/4/2016.
 */

public class MineHandler
{
    public static void generateMineField(Scanner kb)
    {
        while(kb.hasNextLine())
        {
            int rows = kb.nextInt();
            int columns = kb.nextInt();

            MineField mineField = new MineField(rows, columns);

            System.out.println(mineField.getTile(3, 3));

            /*for(int i = 0; i < rows; i ++)
            {
                String line = kb.nextLine();
                String[] lineItems = line.split("");

            }*/
        }
    }
}

package main.driver;

import main.tree_impelemtation.Point;
import main.tree_impelemtation.RTree;

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Driver {

    public static void main(String[] args) throws DataFormatException, InterruptedException {
        Scanner in = new Scanner(System.in);
        RTree rTree = new RTree();
        rTree.init(null);

        System.out.print("CSV file name: \n---> ");
        String name = in.nextLine();

        System.out.print("Separator: \n---> ");
        char[] c = in.nextLine().toCharArray();
        if(c.length > 1)
            throw new DataFormatException();

        Data data = new Data();
        data.init(name, c[0]);

        System.out.print("\nSet your point of searching. (37,0 for instance)\nX: ");
        float x;
        if(in.hasNextFloat())
            x = in.nextFloat();
        else
            throw new DataFormatException();

        System.out.print("Y: ");
        float y;
        if(in.hasNextFloat())
            y= in.nextFloat();
        else
            throw new DataFormatException();

        System.out.print("\nRadix of searching. (3,0 for instance): \n---> ");
        float radix = in.nextFloat();


        System.out.println("\nSearching will start in a second...\n");
        Thread.sleep(1500);

        rTree.addFromData(data);
        Point point = new Point(x, y);
        rTree.nearestLocations(point,
                i -> {
                    Data.Location location = data.getLocationByIndex(i);
                    System.out.println((location.toString()+"\n" + "Distance: " + rTree.getRectangleById(i).distance(point))+"\n");
                    return true;
                }, Integer.MAX_VALUE, radix);
    }
}

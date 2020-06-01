package main.util;

import main.tree.Data;
import main.tree.MBR;

public class Tools {
    public static boolean isInsideArea(MBR mbr, double x, double y){
        return (x >= mbr.getxLU() && x <= mbr.getxRL() && y >= mbr.getyRL() && y <= mbr.getyLU());
    }

    public static boolean isIntersected(MBR box1, MBR box2){
        return !(box1.getyLU() < box2.getyRL()) && !(box1.getyRL() > box2.getyLU()) && !(box1.getxRL() < box2.getxLU()) && !(box1.getxLU() > box2.getxRL());
    }

    public static MBR areaCount(MBR mbr, Data data) {
        MBR temp = new MBR();
        if (data.getY() <= mbr.getyLU() && data.getY() >= mbr.getyRL() && data.getX() <= mbr.getxLU()) { //dot is left side
            temp = new MBR(data.getX(), mbr.getxRL(), mbr.getyLU(), mbr.getyRL());
        } else if (data.getX() >= mbr.getxLU() && data.getX() <= mbr.getxRL() && data.getY() <= mbr.getyRL()) { //dot is down side
            temp = new MBR(mbr.getxLU(), mbr.getxRL(), mbr.getyLU(), data.getY());
        } else if (data.getY() <= mbr.getyLU() && data.getY() >= mbr.getyRL() && data.getX() >= mbr.getxLU()) { //dot is right side
            temp = new MBR(mbr.getxLU(), data.getX(), mbr.getyLU(), mbr.getyRL());
        } else if (data.getX() >= mbr.getxLU() && data.getX() <= mbr.getxRL() && data.getY() >= mbr.getyRL()) { //dot is up side
            temp = new MBR(mbr.getxLU(), mbr.getxRL(), data.getY(), mbr.getyRL());
        } else if (data.getX() > mbr.getxRL() && data.getY() > mbr.getyLU()) { //dot is right-up side
            temp = new MBR(mbr.getxLU(), data.getX(), data.getY(), mbr.getyRL());
        } else if (data.getX() > mbr.getxRL() && data.getY() < mbr.getyRL()) { //dot is right-down side
            temp = new MBR(mbr.getxLU(), data.getX(), mbr.getyLU(), data.getY());
        } else if (data.getX() < mbr.getxLU() && data.getY() > mbr.getyLU()) { //dot is left-up side
            temp = new MBR(data.getX(), mbr.getxRL(), data.getY(), mbr.getyRL());
        } else if (data.getX() < mbr.getxLU() && data.getY() < mbr.getyRL()) { //dot is left-down side
            temp = new MBR(data.getX(), mbr.getxRL(), mbr.getyLU(), data.getY());
        }

        return temp;
    }
}

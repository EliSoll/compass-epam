package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }
public int getDegrees() {
        return degrees;
}
    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        int degreesFinal = degrees;

        if (degrees < 0) {
              degreesFinal = 360 + degrees;
        }
            else if (degrees >= 360) {
                degreesFinal = degrees % 360;
        }
        Direction[] values = Direction.values();
        for (Direction value : values) {
            if (value.getDegrees() == degreesFinal) {
                return value;
            }
        }
        return null;
    }



    public static Direction closestToDegrees(int degrees) {
        int degreesFinal = degrees;

        if (degrees < 0) {
            degreesFinal = 360 + degrees;
        } else if (degrees >= 360) {
            degreesFinal = degrees % 360;
        }
        Direction[] values = Direction.values();
        for (Direction value : values) {
            if (value.getDegrees() == degreesFinal || value.getDegrees()+22 >= degreesFinal) {
                return value;
            }
            }
        return null;
    }

    public Direction opposite() {
        int degreesFinal = degrees;

        if (degrees < 0) {
            degreesFinal = 360 + degrees;
        } else if (degrees >= 360) {
            degreesFinal = degrees % 360;
        }
        Direction[] values = Direction.values();
        for (Direction value : values) {
            if (value.getDegrees()+180 == degreesFinal || value.getDegrees()-180 == degreesFinal) {
                return value;
            }
        }
        return null;
    }


    public int differenceDegreesTo(Direction direction) {
        Direction dir = this;
        if(direction.getDegrees() - dir.getDegrees() > 180)
            return 360 - direction.getDegrees();
        if(direction.getDegrees() > dir.getDegrees()) {
            return direction.getDegrees() - dir.getDegrees();
        }
        return dir.getDegrees() - direction.getDegrees();
    }
}

package Xinyuiii.MansionGenerator.Util;

import com.seedfinding.mccore.util.math.Vec3i;

public enum Mirror {
    NONE(new Vec3i(0, 0, 0)),
    LEFT_RIGHT(new Vec3i(0, 0, 1)),
    FRONT_BACK(new Vec3i(1, 0, 0));

    private final Vec3i orientation;

    Mirror(Vec3i vec3i) {
        this.orientation = vec3i;
    }

    public int mirrorRotation(int rotationIn, int rotationCount) {
        int i = rotationCount / 2;
        int j = rotationIn > i ? rotationIn - rotationCount : rotationIn;
        switch(this) {
            case FRONT_BACK:
                return (rotationCount - j) % rotationCount;
            case LEFT_RIGHT:
                return (i - j + rotationCount) % rotationCount;
            default:
                return rotationIn;
        }
    }

    public Rotation toRotation(Direction facing) {
        Direction.Axis direction$axis = facing.getAxis();
        return (this != LEFT_RIGHT || direction$axis != Direction.Axis.Z) && (this != FRONT_BACK || direction$axis != Direction.Axis.X) ? Rotation.NONE : Rotation.CLOCKWISE_180;
    }

    public Direction mirror(Direction facing) {
        if (this == FRONT_BACK && facing.getAxis() == Direction.Axis.X) {
            return facing.getOpposite();
        } else {
            return this == LEFT_RIGHT && facing.getAxis() == Direction.Axis.Z ? facing.getOpposite() : facing;
        }
    }

    public Vec3i getOrientation() {
        return this.orientation;
    }
}

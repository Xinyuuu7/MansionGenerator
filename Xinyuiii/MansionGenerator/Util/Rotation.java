package Xinyuiii.MansionGenerator.Util;

import com.seedfinding.mccore.rand.ChunkRand;

import java.util.ArrayList;
import java.util.List;

public enum Rotation {
    NONE(Direction.NORTH),
    CLOCKWISE_90(Direction.EAST),
    CLOCKWISE_180(Direction.SOUTH),
    COUNTERCLOCKWISE_90(Direction.WEST);

    private final Direction direction;

    Rotation(Direction direction) {
        this.direction = direction;
    }

    public Rotation add(Rotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                switch(this) {
                    case NONE:
                        return CLOCKWISE_180;
                    case CLOCKWISE_90:
                        return COUNTERCLOCKWISE_90;
                    case CLOCKWISE_180:
                        return NONE;
                    case COUNTERCLOCKWISE_90:
                        return CLOCKWISE_90;
                }
            case COUNTERCLOCKWISE_90:
                switch(this) {
                    case NONE:
                        return COUNTERCLOCKWISE_90;
                    case CLOCKWISE_90:
                        return NONE;
                    case CLOCKWISE_180:
                        return CLOCKWISE_90;
                    case COUNTERCLOCKWISE_90:
                        return CLOCKWISE_180;
                }
            case CLOCKWISE_90:
                switch(this) {
                    case NONE:
                        return CLOCKWISE_90;
                    case CLOCKWISE_90:
                        return CLOCKWISE_180;
                    case CLOCKWISE_180:
                        return COUNTERCLOCKWISE_90;
                    case COUNTERCLOCKWISE_90:
                        return NONE;
                }
            default:
                return this;
        }
    }

    public Direction getDirection() {
        return this.direction;
    }

    public Direction rotate(Direction facing) {
        if (facing.getAxis() == Direction.Axis.Y) {
            return facing;
        } else {
            switch(this) {
                case CLOCKWISE_90:
                    return facing.rotateY();
                case CLOCKWISE_180:
                    return facing.getOpposite();
                case COUNTERCLOCKWISE_90:
                    return facing.rotateYCCW();
                default:
                    return facing;
            }
        }
    }

    public int rotate(int a, int b) {
        switch(this) {
            case CLOCKWISE_90:
                return (a + b / 4) % b;
            case CLOCKWISE_180:
                return (a + b / 2) % b;
            case COUNTERCLOCKWISE_90:
                return (a + b * 3 / 4) % b;
            default:
                return a;
        }
    }

    public static Rotation getRandom(ChunkRand rand) {
        return values()[rand.nextInt(values().length)];
    }

    public static List<Rotation> shuffledRotations(ChunkRand rand) {
        List<Rotation> list = new ArrayList<>(List.of(values()));
        Util.shuffle(list, rand);
        return list;
    }
}

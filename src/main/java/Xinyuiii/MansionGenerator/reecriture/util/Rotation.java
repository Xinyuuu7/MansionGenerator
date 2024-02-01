package Xinyuiii.MansionGenerator.reecriture.util;

import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.pos.BPos;

public enum Rotation {
    NONE(Direction.NORTH),
    CLOCKWISE_90(Direction.EAST),
    CLOCKWISE_180(Direction.SOUTH),
    COUNTERCLOCKWISE_90(Direction.WEST);

    Rotation(Direction direction) {}

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

    public BPos getSize(BPos size) {
        switch (this) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                return new BPos(size.getZ(), size.getY(), size.getX());
            default:
                return size;
        }
    }

    public static Rotation getRandom(ChunkRand rand) {
        return values()[rand.nextInt(values().length)];
    }
}
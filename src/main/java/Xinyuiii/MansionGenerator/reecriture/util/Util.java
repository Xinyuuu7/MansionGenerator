package Xinyuiii.MansionGenerator.reecriture.util;

import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.pos.BPos;

import java.util.*;

public class Util {
    private static void swap(List<?> list, int i, int j) {
        ((List) list).set(i, ((List) list).set(j, ((List) list).get(i)));
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shuffle(List<?> list, ChunkRand rand) {
        int size = list.size();
        if (size < 5 || list instanceof RandomAccess) {
            for (int i = size; i > 1; i--)
                swap(list, i - 1, rand.nextInt(i));
        } else {
            Object[] arr = list.toArray();
            for (int i = size; i > 1; i--)
                swap(arr, i - 1, rand.nextInt(i));
            ListIterator it = list.listIterator();
            for (Object e : arr) {
                it.next();
                it.set(e);
            }
        }
    }

    public static BPos offset(BPos pos, Direction facing, int n) {
        return n == 0 ? pos : new BPos(pos.getX() + facing.getXOffset() * n, pos.getY() + facing.getYOffset() * n, pos.getZ() + facing.getZOffset() * n);
    }

    public static BPos getZeroPositionWithTransform(BPos pos, Mirror mirror, Rotation rotation, int a, int b) {
        --a;
        --b;
        int i = mirror == Mirror.FRONT_BACK ? a : 0;
        int j = mirror == Mirror.LEFT_RIGHT ? b : 0;
        BPos blockpos = pos;
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
                blockpos = pos.add(j, 0, a - i);
                break;
            case CLOCKWISE_90:
                blockpos = pos.add(b - j, 0, i);
                break;
            case CLOCKWISE_180:
                blockpos = pos.add(a - i, 0, b - j);
                break;
            case NONE:
                blockpos = pos.add(i, 0, j);
        }
        return blockpos;
    }

    public static BPos rotate(BPos pos, Rotation rotationIn) {
        switch (rotationIn) {
            case NONE:
            default:
                return pos;
            case CLOCKWISE_90:
                return new BPos(-pos.getZ(), pos.getY(), pos.getX());
            case CLOCKWISE_180:
                return new BPos(-pos.getX(), pos.getY(), -pos.getZ());
            case COUNTERCLOCKWISE_90:
                return new BPos(pos.getZ(), pos.getY(), -pos.getX());
        }
    }

    private static BlockBox mirrorAABB(Rotation rotation, int x, int z, BlockBox blockBox, Direction blockDirection, Direction blockDirection1) {
        BPos moveAmount = BPos.ORIGIN;
        if (rotation != Rotation.CLOCKWISE_90 && rotation != Rotation.COUNTERCLOCKWISE_90) {
            if (rotation == Rotation.CLOCKWISE_180) {
                moveAmount = offset(moveAmount,blockDirection1,x);
            } else {
                moveAmount = offset(moveAmount,blockDirection,x);
            }
        } else {
            moveAmount = offset(moveAmount,rotation.rotate(blockDirection),z);
        }
        return blockBox.offset(moveAmount.getX(), 0, moveAmount.getZ());
    }

    public static BlockBox getBoundingBox(BPos anchor, Rotation rotation, BPos pivot, Mirror mirror, BPos size) {
        BPos rotationSize = rotation.getSize(size);
        int pivotX = pivot.getX();
        int pivotZ = pivot.getZ();
        int sizedRotationX = rotationSize.getX() - 1;
        int sizedRotationY = rotationSize.getY() - 1;
        int sizedRotationZ = rotationSize.getZ() - 1;
        BlockBox blockBox = new BlockBox(0, 0, 0, 0, 0, 0);
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
                blockBox = new BlockBox(pivotX - pivotZ, 0, pivotX + pivotZ - sizedRotationZ, pivotX - pivotZ + sizedRotationX, sizedRotationY, pivotX + pivotZ);
                break;
            case CLOCKWISE_90:
                blockBox = new BlockBox(pivotX + pivotZ - sizedRotationX, 0, pivotZ - pivotX, pivotX + pivotZ, sizedRotationY, pivotZ - pivotX + sizedRotationZ);
                break;
            case CLOCKWISE_180:
                blockBox = new BlockBox(pivotX + pivotX - sizedRotationX, 0, pivotZ + pivotZ - sizedRotationZ, pivotX + pivotX, sizedRotationY, pivotZ + pivotZ);
                break;
            case NONE:
                blockBox = new BlockBox(0, 0, 0, sizedRotationX, sizedRotationY, sizedRotationZ);
        }
        switch (mirror) {
            case LEFT_RIGHT:
                blockBox = mirrorAABB(rotation, sizedRotationZ, sizedRotationX, blockBox, Direction.NORTH, Direction.SOUTH);
                break;
            case FRONT_BACK:
                blockBox = mirrorAABB(rotation, sizedRotationX, sizedRotationZ, blockBox, Direction.WEST, Direction.EAST);
            case NONE:
        }
        return blockBox.offset(anchor.getX(), anchor.getY(), anchor.getZ());
    }
}
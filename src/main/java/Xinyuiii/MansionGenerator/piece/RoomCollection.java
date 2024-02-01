package Xinyuiii.MansionGenerator.piece;

import com.seedfinding.mccore.rand.ChunkRand;

public abstract class RoomCollection {
    public RoomCollection() {}

    public abstract String get1x1(ChunkRand rand);

    public abstract String get1x1Secret(ChunkRand rand);

    public abstract String get1x2SideEntrance(ChunkRand rand, boolean a);

    public abstract String get1x2FrontEntrance(ChunkRand rand, boolean a);

    public abstract String get1x2Secret(ChunkRand rand);

    public abstract String get2x2(ChunkRand rand);

    public abstract String get2x2Secret(ChunkRand rand);
}
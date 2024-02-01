package Xinyuiii.MansionGenerator.piece;

import com.seedfinding.mccore.rand.ChunkRand;

public class SecondFloor extends RoomCollection {
    public SecondFloor() {}

    public String get1x1(ChunkRand rand) {
        return "1x1_b" + (rand.nextInt(4) + 1);
    }

    public String get1x1Secret(ChunkRand rand) {
        return "1x1_as" + (rand.nextInt(4) + 1);
    }

    public String get1x2SideEntrance(ChunkRand rand, boolean a) {
        return a ? "1x2_c_stairs" : "1x2_c" + (rand.nextInt(4) + 1);
    }

    public String get1x2FrontEntrance(ChunkRand rand, boolean a) {
        return a ? "1x2_d_stairs" : "1x2_d" + (rand.nextInt(5) + 1);
    }

    public String get1x2Secret(ChunkRand rand) {
        return "1x2_se" + (rand.nextInt(1) + 1);
    }

    public String get2x2(ChunkRand rand) {
        return "2x2_b" + (rand.nextInt(5) + 1);
    }

    public String get2x2Secret(ChunkRand rand) {
        return "2x2_s1";
    }
}
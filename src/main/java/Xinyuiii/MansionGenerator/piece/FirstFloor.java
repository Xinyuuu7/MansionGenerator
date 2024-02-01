package Xinyuiii.MansionGenerator.piece;

import com.seedfinding.mccore.rand.ChunkRand;

public class FirstFloor extends RoomCollection {
    public FirstFloor() {}

    public String get1x1(ChunkRand rand) {
        return "1x1_a" + (rand.nextInt(5) + 1);
    }

    public String get1x1Secret(ChunkRand rand) {
        return "1x1_as" + (rand.nextInt(4) + 1);
    }

    public String get1x2SideEntrance(ChunkRand rand, boolean a) {
        return "1x2_a" + (rand.nextInt(9) + 1);
    }

    public String get1x2FrontEntrance(ChunkRand rand, boolean a) {
        return "1x2_b" + (rand.nextInt(5) + 1);
    }

    public String get1x2Secret(ChunkRand rand) {
        return "1x2_s" + (rand.nextInt(2) + 1);
    }

    public String get2x2(ChunkRand rand) {
        return "2x2_a" + (rand.nextInt(4) + 1);
    }

    public String get2x2Secret(ChunkRand rand) {
        return "2x2_s1";
    }
}
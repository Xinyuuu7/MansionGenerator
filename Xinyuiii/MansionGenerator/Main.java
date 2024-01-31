package Xinyuiii.MansionGenerator;

import Xinyuiii.MansionGenerator.MansionGenerator.Piece;
import com.seedfinding.mcbiome.source.OverworldBiomeSource;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.rand.seed.WorldSeed;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcfeature.structure.Mansion;
import com.seedfinding.mcterrain.terrain.OverworldTerrainGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ChunkRand rand = new ChunkRand();
        Mansion mansion = new Mansion(MCVersion.v1_16_1);
        while (true) {
            long seed = random.nextLong();
            long structureSeed = WorldSeed.toStructureSeed(seed);
            CPos pos = mansion.getInRegion(structureSeed, 0, 0, rand);
            if (pos == null) {
                continue;
            }
            OverworldBiomeSource obs = new OverworldBiomeSource(MCVersion.v1_16_1, seed);
            if (!mansion.canSpawn(pos, obs)) {
                continue;
            }
            OverworldTerrainGenerator otg = new OverworldTerrainGenerator(obs);
            MansionGenerator generator = new MansionGenerator(MCVersion.v1_16_1);
            if (!generator.generate(otg, pos, rand)) {
                continue;
            }
            int enderPearl = 0;
            List<Piece> roomsWanted = new ArrayList<>();
            for (Piece room : generator.getAllRooms()) {
                if (room.name.equals("1x2_s2")) {
                    enderPearl = enderPearl + 2;
                    roomsWanted.add(room);
                }
            }
            if (enderPearl < 4) {
                continue;
            }
            System.out.println(seed);
            for (Piece roomWanted : roomsWanted) {
                System.out.println(roomWanted.name + " " + roomWanted.pos);
            }
            return;
        }
    }
}

package Xinyuiii.MansionGenerator;

import Debris.PrintUtil;
import com.seedfinding.mcbiome.source.OverworldBiomeSource;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcfeature.structure.Mansion;
import com.seedfinding.mcterrain.terrain.OverworldTerrainGenerator;

public class main {
    public static final MCVersion version = MCVersion.v1_16_1;

    public static void main(String[] args) {
        MansionGenerator gen = new MansionGenerator(version);

        ChunkRand rand = new ChunkRand();

        Mansion mansion = new Mansion(version);

        for (long worldSeed = 1L; worldSeed < 1000000L; worldSeed++) {
            CPos pos = mansion.getInRegion(worldSeed, 0, 0, rand);
            OverworldBiomeSource obs = new OverworldBiomeSource(version, worldSeed);
            if (!mansion.canSpawn(pos, obs)) continue;
            OverworldTerrainGenerator otg = new OverworldTerrainGenerator(obs);
            gen.generate(otg, pos, rand);
            for (MansionGenerator.Piece piece : gen.pieces) {
                System.out.println(piece.name);
                PrintUtil.tp(piece.pos);
            }
            break;
        }
    }
}

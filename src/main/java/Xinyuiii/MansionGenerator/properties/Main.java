package Xinyuiii.MansionGenerator.properties;

import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcfeature.loot.item.ItemStack;

import java.util.List;

public class Main {

    public static final MCVersion version = MCVersion.v1_20;

    public static void main(String[] args) {
        test();
    }


    public static void test() {
        ChunkRand rand = new ChunkRand();
        long seed = -1432629000L;
        CPos pos = (new BPos(-5488, 0, 14624)).toChunkPos();

        MansionGenerator generator = new MansionGenerator(version);
        generator.generateSkipHeight(seed, pos, rand);
        generator.decorate();

        for (Pair<BPos, List<ItemStack>> chest : generator.getLoot()) {

        }
    }
}
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
        long seed = 7307225956951549610L;
        CPos pos = (new BPos(-928, 0, -656)).toChunkPos();
        MansionGenerator generator = new MansionGenerator(version);
        generator.generateSkipHeight(seed, pos, rand);
        generator.generateDecoration();
        for (Pair<BPos, List<ItemStack>> chest : generator.getChests()) {
            System.out.println(chest.getFirst());
            for (ItemStack itemStack : chest.getSecond()) {
                System.out.println(itemStack.getCount() + " " + itemStack.getItem().getName());
            }
        }
    }
}

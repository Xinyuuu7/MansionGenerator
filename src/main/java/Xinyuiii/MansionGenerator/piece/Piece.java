package Xinyuiii.MansionGenerator.piece;

import Xinyuiii.MansionGenerator.reecriture.MansionPools.MansionStructureBlocks;
import Xinyuiii.MansionGenerator.reecriture.MansionPools.MansionStructureSize;
import Xinyuiii.MansionGenerator.reecriture.MansionPools.StructureBlock;
import Xinyuiii.MansionGenerator.reecriture.Mob;
import Xinyuiii.MansionGenerator.reecriture.NewLootTables;
import Xinyuiii.MansionGenerator.reecriture.NewXoroChunkRand;
import Xinyuiii.MansionGenerator.reecriture.util.*;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcfeature.loot.LootContext;
import com.seedfinding.mcfeature.loot.LootTable;
import com.seedfinding.mcfeature.loot.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    public PieceType type;
    public String name;
    public BPos pos;
    public Rotation rotation;
    public Mirror mirror;
    public BlockBox box;
    public List<Pair<BPos, List<ItemStack>>> loot = new ArrayList<>();
    public List<Mob> mobs = new ArrayList<>();

    public Piece(PieceType type, String name, BPos pos, Rotation rotation) {
        this.type = type;
        this.name = name;
        this.pos = pos;
        this.rotation = rotation;
        this.mirror = Mirror.NONE;
        this.box = Util.getBoundingBox(pos, rotation, BPos.ORIGIN, Mirror.NONE, MansionStructureSize.STRUCTURE_SIZE.get(name));
    }

    public Piece(PieceType type, String name, BPos pos, Rotation rotation, Mirror mirror) {
        this.type = type;
        this.name = name;
        this.pos = pos;
        this.rotation = rotation;
        this.mirror = mirror;
        this.box = Util.getBoundingBox(pos, rotation, BPos.ORIGIN, mirror, MansionStructureSize.STRUCTURE_SIZE.get(name));
    }

    public void decorate(ChunkRand rand, BlockBox chunkBox, MCVersion version) {
        //Using chunkRand means pre1.18
        List<StructureBlock> structureBlocks = MansionStructureBlocks.STRUCTURE_BLOCKS_1_11.get(this.name);
        for (StructureBlock structureBlock : structureBlocks) {
            handleStructureBlock(structureBlock, rand, chunkBox, version);
        }
    }

    public void decorate(NewXoroChunkRand rand, BlockBox chunkBox, MCVersion version) {
        List<StructureBlock> structureBlocks = version.isNewerOrEqualTo(MCVersion.v1_19) ?
                MansionStructureBlocks.STRUCTURE_BLOCKS_1_19.get(this.name) :
                MansionStructureBlocks.STRUCTURE_BLOCKS_1_11.get(this.name);
        for (StructureBlock structureBlock : structureBlocks) {
            handleStructureBlock(structureBlock, rand, chunkBox, version);
        }
    }

    public void handleStructureBlock(StructureBlock structureBlock, ChunkRand rand, BlockBox chunkBox, MCVersion version) {
        BPos pos = this.pos.add(Util.rotate(structureBlock.offset, this.rotation));
        if (!chunkBox.contains(pos)) return;
        String content = structureBlock.name;
        if (content.startsWith("Chest")) {
            long lootTableSeed = rand.nextLong();
            LootContext context = new LootContext(lootTableSeed);
            LootTable lootTable = NewLootTables.NORMAL_CHEST_1_11;
            List<ItemStack> itemStacks = lootTable.generate(context);
            loot.add(new Pair<>(pos, itemStacks));
            return;
        }
        switch (content) {
            case "Empty": {
                rand.nextLong();
                return;
            }
            case "Pearl": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.ENDER_PEARL_TRAPPED_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Axe": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.IRON_AXE_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Allium": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.ALLIUM_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Sampling": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.DARK_OAK_SAPLING_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Mage": {
                mobs.add(new Mob(pos, "Evoker"));
                return;
            }
            case "Warrior": {
                mobs.add(new Mob(pos, "Vindicator"));
                return;
            }
            default: {
            }
        }
    }

    public void handleStructureBlock(StructureBlock structureBlock, NewXoroChunkRand rand, BlockBox chunkBox, MCVersion version) {
        BPos pos = this.pos.add(Util.rotate(structureBlock.offset, this.rotation));
        if (!chunkBox.contains(pos)) return;
        String content = structureBlock.name;
        if (content.startsWith("Chest")) {
            long lootTableSeed = rand.nextLong();
            LootContext context = new LootContext(lootTableSeed);
            LootTable lootTable = version.isNewerOrEqualTo(MCVersion.v1_19_4) ?
                    NewLootTables.NORMAL_CHEST_1_19_4 :
                    NewLootTables.NORMAL_CHEST_1_11;
            List<ItemStack> itemStacks = lootTable.generate(context);
            loot.add(new Pair<>(pos, itemStacks));
            return;
        }
        switch (content) {
            case "Empty": {
                rand.nextLong();
                return;
            }
            case "Pearl": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.ENDER_PEARL_TRAPPED_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Axe": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.IRON_AXE_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Allium": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.ALLIUM_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Sampling": {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                LootTable lootTable = NewLootTables.DARK_OAK_SAPLING_CHEST;
                List<ItemStack> itemStacks = lootTable.generate(context);
                loot.add(new Pair<>(pos, itemStacks));
                return;
            }
            case "Mage": {
                mobs.add(new Mob(pos, "Evoker"));
                return;
            }
            case "Warrior": {
                mobs.add(new Mob(pos, "Vindicator"));
                return;
            }
            case "Group of Allays": {
                mobs.add(new Mob(pos, "Allay"));
                return;
            }
            default: {
            }
        }
    }
}

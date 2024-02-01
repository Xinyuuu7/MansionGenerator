package Xinyuiii.MansionGenerator.reecriture;

import com.seedfinding.mcfeature.loot.*;
import com.seedfinding.mcfeature.loot.entry.*;
import com.seedfinding.mcfeature.loot.function.*;
import com.seedfinding.mcfeature.loot.roll.*;
import com.seedfinding.mcfeature.loot.item.Items;

public class NewLootTables {
    // For version 1.11 to 1.19.3
    public static final LootTable NORMAL_CHEST_1_11 = new LootTable(
            new LootPool(new UniformRoll(1.0F, 3.0F),
                    new ItemEntry(Items.LEAD, 20),
                    new ItemEntry(Items.GOLDEN_APPLE, 15),
                    new ItemEntry(Items.ENCHANTED_GOLDEN_APPLE, 2),
                    new ItemEntry(Items.MUSIC_DISC_13, 15),
                    new ItemEntry(Items.MUSIC_DISC_CAT, 15),
                    new ItemEntry(Items.NAME_TAG, 20),
                    new ItemEntry(Items.CHAINMAIL_CHESTPLATE, 10),
                    new ItemEntry(Items.DIAMOND_HOE, 15),
                    new ItemEntry(Items.DIAMOND_CHESTPLATE, 5),
                    new ItemEntry(Items.ENCHANTED_BOOK, 10).apply(version -> new EnchantRandomlyFunction(Items.ENCHANTED_BOOK).apply(version))),
            new LootPool(new UniformRoll(1.0F, 4.0F),
                    new ItemEntry(Items.IRON_INGOT, 10).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.GOLD_INGOT, 5).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.BREAD, 20),
                    new ItemEntry(Items.WHEAT, 20).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.BUCKET, 10),
                    new ItemEntry(Items.REDSTONE, 15).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.COAL, 15).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.MELON_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F)),
                    new ItemEntry(Items.PUMPKIN_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F)),
                    new ItemEntry(Items.BEETROOT_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F))),
            new LootPool(new ConstantRoll(3),
                    new ItemEntry(Items.BONE, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.GUNPOWDER, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.ROTTEN_FLESH, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.STRING, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)))
    );

    //For version 1.19.4 +
    public static final LootTable NORMAL_CHEST_1_19_4 = new LootTable(
            new LootPool(new UniformRoll(1.0F, 3.0F),
                    new ItemEntry(Items.LEAD, 20),
                    new ItemEntry(Items.GOLDEN_APPLE, 15),
                    new ItemEntry(Items.ENCHANTED_GOLDEN_APPLE, 2),
                    new ItemEntry(Items.MUSIC_DISC_13, 15),
                    new ItemEntry(Items.MUSIC_DISC_CAT, 15),
                    new ItemEntry(Items.NAME_TAG, 20),
                    new ItemEntry(Items.CHAINMAIL_CHESTPLATE, 10),
                    new ItemEntry(Items.DIAMOND_HOE, 15),
                    new ItemEntry(Items.DIAMOND_CHESTPLATE, 5),
                    new ItemEntry(Items.ENCHANTED_BOOK, 10).apply(version -> new EnchantRandomlyFunction(Items.ENCHANTED_BOOK).apply(version))),
            new LootPool(new UniformRoll(1.0F, 4.0F),
                    new ItemEntry(Items.IRON_INGOT, 10).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.GOLD_INGOT, 5).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.BREAD, 20),
                    new ItemEntry(Items.WHEAT, 20).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.BUCKET, 10),
                    new ItemEntry(Items.REDSTONE, 15).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.COAL, 15).apply(version -> SetCountFunction.uniform(1.0F, 4.0F)),
                    new ItemEntry(Items.MELON_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F)),
                    new ItemEntry(Items.PUMPKIN_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F)),
                    new ItemEntry(Items.BEETROOT_SEEDS, 10).apply(version -> SetCountFunction.uniform(2.0F, 4.0F))),
            new LootPool(new ConstantRoll(3),
                    new ItemEntry(Items.BONE, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.GUNPOWDER, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.ROTTEN_FLESH, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F)),
                    new ItemEntry(Items.STRING, 10).apply(version -> SetCountFunction.uniform(1.0F, 8.0F))),
            new LootPool(new ConstantRoll(1),
                    new EmptyEntry(1),
                    new ItemEntry(NewItems.VEX_ARMOR_TRIM_SMITHING_TEMPLATE))
    );

    public static final LootTable DARK_OAK_SAPLING_CHEST = new LootTable(
            new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.DARK_OAK_SAPLING).apply(version -> SetCountFunction.constant(28)))
    );

    public static final LootTable IRON_AXE_CHEST = new LootTable(
            new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.IRON_AXE).apply(version -> new NewEnchantRandomlyFunction()))
    );

    // It is not a real chest
    public static final LootTable ENDER_PEARL_TRAPPED_CHEST = new LootTable(
            new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.ENDER_PEARL).apply(version -> SetCountFunction.constant(2)))
    );

    public static final LootTable ALLIUM_CHEST = new LootTable(
            new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.ALLIUM).apply(version -> SetCountFunction.constant(8)))
    );
}
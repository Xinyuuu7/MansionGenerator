package Xinyuiii.MansionGenerator.reecriture;

import com.seedfinding.mcfeature.loot.LootPool;
import com.seedfinding.mcfeature.loot.LootTable;
import com.seedfinding.mcfeature.loot.MCLootTables;
import com.seedfinding.mcfeature.loot.entry.EmptyEntry;
import com.seedfinding.mcfeature.loot.entry.ItemEntry;
import com.seedfinding.mcfeature.loot.function.EnchantRandomlyFunction;
import com.seedfinding.mcfeature.loot.function.SetCountFunction;
import com.seedfinding.mcfeature.loot.item.Items;
import com.seedfinding.mcfeature.loot.roll.ConstantRoll;

public class LootTables {
    public static final LootTable NORMAL = MCLootTables.WOODLAND_MANSION_CHEST.get();

    //TODO dont know if these tables true
    public static final LootTable EMPTY = new LootTable
            (new LootPool(new ConstantRoll(1),
                    new EmptyEntry(1)));

    public static final LootTable ALLIUM = new LootTable
            (new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.ALLIUM, 1).apply(version -> SetCountFunction.constant(8))));

    public static final LootTable IRON_AXE = new LootTable
            (new LootPool(new ConstantRoll(1),
                    new ItemEntry(Items.IRON_AXE, 1).apply(version -> new EnchantRandomlyFunction
                            (Items.IRON_AXE).apply(version))));


    public static LootTable lootTableProvider(String string) {
        return switch (string) {
            case "Chest" -> NORMAL;
            case "Chest_Empty" -> EMPTY;
            case "Chest_Allium" -> ALLIUM;
            case "Chest_Iron_Axe" -> IRON_AXE;
            default -> NORMAL;
        };
    }
}

package Xinyuiii.MansionGenerator.reecriture;

import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mcfeature.loot.LootContext;
import com.seedfinding.mcfeature.loot.function.LootFunction;
import com.seedfinding.mcfeature.loot.item.*;

public class NewEnchantRandomlyFunction implements LootFunction {

    public NewEnchantRandomlyFunction() {}

    @Override
    public ItemStack process(ItemStack baseStack, LootContext context) {
        Item item = baseStack.getItem();
        context.nextInt(1);
        item.addEnchantment(new Pair<>("efficiency", 1));
        return new ItemStack(item,1);
    }
}
package Xinyuiii.MansionGenerator.reecriture;

import com.seedfinding.mccore.util.pos.BPos;

import java.util.HashMap;
import java.util.List;

public class Pool {
    public static final HashMap<String, List<String>> DATA = new HashMap<>() {{
        this.put("1x1_a4", List.of("Chest"));
        this.put("1x1_as1", List.of("Chest"));
        this.put("1x1_b5", List.of("Chest"));//8 allium
        this.put("1x2_a1", List.of("Chest", "Warrior"));
        this.put("1x2_a3", List.of("Warrior"));
        this.put("1x2_a4", List.of("Chest"));//28 dark_oak_sapling
        this.put("1x2_a6", List.of("Chest"));//1 iron_axe with efficiency 1
        this.put("1x2_a7", List.of("Chest"));//Fucking chest
        this.put("1x2_a8", List.of("Warrior"));
        this.put("1x2_a9", List.of("Warrior", "Group of Chests"));//Fucking 42 chests
        this.put("1x2_b1", List.of("Warrior"));
        this.put("1x2_b2", List.of("Warrior"));
        this.put("1x2_b3", List.of("Chest", "Warrior"));
        this.put("1x2_b4", List.of("Chest"));
//        this.put("1x2_c2", List.of("Warrior", "Warrior"));
        this.put("1x2_c3", List.of("Warrior", "Warrior", "Warrior"));
        this.put("1x2_d2", List.of("Chest"));
        this.put("1x2_d3", List.of("Warrior", "Warrior", "Mage"));
        this.put("1x2_s1", List.of("Chest"));
        this.put("1x2_s2", List.of("Trapped_chest"));//2 ender_pearl
        this.put("1x2_se1", List.of("Chest", "Chest"));
        this.put("2x2_a1", List.of("Warrior", "Group of Allays", "Group of Allays", "Group of Allays", "Group of Allays"));
        this.put("2x2_a2", List.of("Warrior", "Group of Chests"));//Fucking 26 chests
        this.put("2x2_b1", List.of("Warrior", "Warrior", "Mage"));
        this.put("2x2_b2", List.of("Warrior", "Warrior", "Mage"));
        this.put("2x2_b4", List.of("Warrior", "Warrior", "Mage"));
        this.put("2x2_b5", List.of("Chest"));
    }};

    public static final HashMap<String, List<BPos>> DATA_OFFSETS = new HashMap<>() {{
        this.put("1x1_a4", List.of(new BPos(6, 6, 3)));
        this.put("1x1_as1", List.of(new BPos(5, 1, 1)));
        this.put("1x1_b5", List.of(new BPos(6, 1, 6)));//8 allium
        this.put("1x2_a1", List.of(new BPos(3, 1, 12), new BPos(3, 1, 3)));
        this.put("1x2_a3", List.of(new BPos(3, 2, 8)));
        this.put("1x2_a4", List.of(new BPos(6, 1, 5)));//28 dark_oak_sapling
        this.put("1x2_a6", List.of(new BPos(2, 1, 8)));//1 iron_axe with efficiency 1
        this.put("1x2_a7", List.of(new BPos(3, 1, 0)));//Fucking chest
        this.put("1x2_a8", List.of(new BPos(2, 1, 2)));
        this.put("1x2_a9", List.of(new BPos(5, 1, 1), new BPos(0, 2, 3), new BPos(0, 2, 5), new BPos(0, 2, 7), new BPos(0, 2, 9), new BPos(0, 2, 11), new BPos(3, 2, 3), new BPos(3, 2, 5), new BPos(3, 2, 7), new BPos(3, 2, 9), new BPos(3, 2, 11), new BPos(5, 2, 6), new BPos(5, 2, 8), new BPos(5, 2, 10), new BPos(5, 2, 11), new BPos(0, 4, 3), new BPos(0, 4, 5), new BPos(0, 4, 7), new BPos(0, 4, 9), new BPos(0, 4, 11), new BPos(3, 4, 3), new BPos(3, 4, 5), new BPos(3, 4, 7), new BPos(3, 4, 9), new BPos(3, 4, 11), new BPos(5, 4, 6), new BPos(5, 4, 7), new BPos(5, 4, 9), new BPos(5, 4, 11), new BPos(0, 6, 3), new BPos(0, 6, 5), new BPos(0, 6, 7), new BPos(0, 6, 9), new BPos(0, 6, 11), new BPos(3, 6, 3), new BPos(3, 6, 5), new BPos(3, 6, 7), new BPos(3, 6, 9), new BPos(3, 6, 11), new BPos(5, 6, 6), new BPos(5, 6, 8), new BPos(5, 6, 10), new BPos(5, 6, 11)));//Fucking 42 chests
        this.put("1x2_b1", List.of(new BPos(3, 1, 13)));
        this.put("1x2_b2", List.of(new BPos(5, 1, 11)));
        this.put("1x2_b3", List.of(new BPos(3, 1, 0), new BPos(3, 1, 4)));
        this.put("1x2_b4", List.of(new BPos(4, 3, 9)));
//        this.put("1x2_c2", List.of("Warrior找不到nbt", "Warrior找不到nbt"));
        this.put("1x2_c3", List.of(new BPos(4, 1, 6), new BPos(4, 1, 9), new BPos(4, 1, 12)));
        this.put("1x2_d2", List.of(new BPos(6, 7, 12)));
        this.put("1x2_d3", List.of(new BPos(2, 2, 10), new BPos(4, 2, 10), new BPos(3, 3, 3)));
        this.put("1x2_s1", List.of(new BPos(3, 1, 4)));
        this.put("1x2_s2", List.of(new BPos(3, 4, 5)));//2 ender_pearl
        this.put("1x2_se1", List.of(new BPos(3, 9, 1), new BPos(3, 9, 13)));
        this.put("2x2_a1", List.of(new BPos(12, 1, 3), new BPos(2, 2, 8), new BPos(4, 2, 2), new BPos(5, 2, 12), new BPos(12, 2, 12)));
        this.put("2x2_a2", List.of(new BPos(9, 1, 2), new BPos(0, 2, 1), new BPos(0, 2, 2), new BPos(0, 2, 4), new BPos(0, 2, 5), new BPos(0, 2, 7), new BPos(0, 2, 8), new BPos(0, 2, 10), new BPos(0, 2, 11), new BPos(6, 2, 4), new BPos(6, 2, 5), new BPos(6, 2, 7), new BPos(6, 2, 8), new BPos(6, 2, 10), new BPos(6, 2, 11), new BPos(8, 2, 6), new BPos(8, 2, 7), new BPos(8, 2, 9), new BPos(8, 2, 10), new BPos(8, 2, 12), new BPos(8, 2, 13), new BPos(14, 2, 6), new BPos(14, 2, 7), new BPos(14, 2, 9), new BPos(14, 2, 10), new BPos(14, 2, 12), new BPos(14, 2, 13)));//Fucking 26 chests
        this.put("2x2_b1", List.of(new BPos(4, 1, 4), new BPos(8, 1, 9), new BPos(2, 1, 8)));
        this.put("2x2_b2", List.of(new BPos(9, 1, 8), new BPos(13, 1, 2), new BPos(2, 1, 7)));
        this.put("2x2_b4", List.of(new BPos(3, 1, 3), new BPos(4, 1, 11), new BPos(3, 1, 8)));
        this.put("2x2_b5", List.of(new BPos(7, 7, 0)));
    }};

    public static final HashMap<String, BPos> SIZE = new HashMap<>() {{

    }};

}
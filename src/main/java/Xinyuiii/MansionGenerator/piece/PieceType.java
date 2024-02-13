package Xinyuiii.MansionGenerator.piece;

import java.util.HashMap;

public enum PieceType {
    ROOM,
    TECHNICALSTRUCTURE;

    public boolean isRoom() {
        return this.equals(ROOM);
    }

    public static final HashMap<String, String> ROOM_NAME = new HashMap<>() {{
        this.put("1x1_a1", "Flower room");
        this.put("1x1_a2", "Pumpkin ring room");
        this.put("1x1_a3", "Office");
        this.put("1x1_a4", "Checkerboard room");
        this.put("1x1_a5", "White tulip sanctuary");
        this.put("1x1_as1", "X room");
        this.put("1x1_as2", "Spider room");
        this.put("1x1_as3", "Obsidian room");
        this.put("1x1_as4", "Birch pillar room");
        this.put("1x1_b1", "Birch arch room");
        this.put("1x1_b2", "Small dining room");
        this.put("1x1_b3", "Single bed bedroom");
        this.put("1x1_b4", "Small library");
        this.put("1x1_b5", "Allium room");
        this.put("1x2_a1", "Gray banner room");
        this.put("1x2_a2", "Wheat farm");
        this.put("1x2_a3", "Forge room");
        this.put("1x2_a4", "Sapling farm");
        this.put("1x2_a5", "Wool room");
        this.put("1x2_a6", "Tree-chopping room");
        this.put("1x2_a7", "Mushroom farm");
        this.put("1x2_a8", "Dual-staged farm");
        this.put("1x2_a9", "Small storage room");
        this.put("1x2_b1", "Redstone jail");
        this.put("1x2_b2", "Small jail");
        this.put("1x2_b3", "Wood arch hallway");
        this.put("1x2_b4", "Winding stairway room");
        this.put("1x2_b5", "Illager head room");
        this.put("1x2_c1", "Medium dining room");
        this.put("1x2_c2", "Double bed bedroom");
        this.put("1x2_c3", "Triple bed bedroom");
        this.put("1x2_c4", "Medium library");
        this.put("1x2_c_stairs", "Curved staircase");
        this.put("1x2_d1", "Master bedroom");
        this.put("1x2_d2", "Bedroom with loft");
        this.put("1x2_d3", "Ritual room");
        this.put("1x2_d4", "Cat statue room");
        this.put("1x2_d5", "Chicken statue room");
        this.put("1x2_d_stairs", "Straight staircase");
        this.put("1x2_s1", "Clean chest room");
        this.put("1x2_s2", "Fake End portal room");
        this.put("1x2_se1", "Attic room");
        this.put("2x2_a1", "Large jail");
        this.put("2x2_a2", "Large storage room");
        this.put("2x2_a3", "Illager statue room");
        this.put("2x2_a4", "Nature room");
        this.put("2x2_b1", "Large dining room");
        this.put("2x2_b2", "Conference room");
        this.put("2x2_b3", "Large library");
        this.put("2x2_b4", "Map room");
        this.put("2x2_b5", "Arena room");
        this.put("2x2_s1", "Lava room");
    }};
}

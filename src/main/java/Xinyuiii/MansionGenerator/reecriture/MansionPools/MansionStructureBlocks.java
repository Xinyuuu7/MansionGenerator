package Xinyuiii.MansionGenerator.reecriture.MansionPools;

import com.seedfinding.mccore.util.pos.BPos;

import java.util.*;

public class MansionStructureBlocks {
    // For version 1.11 to 1.18.2
    public static final HashMap<String, List<StructureBlock>> STRUCTURE_BLOCKS_1_11 = new HashMap<>() {{
        this.put("1x1_a1", List.of());
        this.put("1x1_a2", List.of());
        this.put("1x1_a3", List.of());
        this.put("1x1_a4", List.of(
                new StructureBlock("ChestWest", new BPos(6, 6, 3))
        ));
        this.put("1x1_a5", List.of());
        this.put("1x1_as1", List.of(
                new StructureBlock("ChestWest", new BPos(5, 1, 1))
        ));
        this.put("1x1_as2", List.of());
        this.put("1x1_as3", List.of());
        this.put("1x1_as4", List.of());
        this.put("1x1_b1", List.of());
        this.put("1x1_b2", List.of());
        this.put("1x1_b3", List.of());
        this.put("1x1_b4", List.of());
        this.put("1x1_b5", List.of(
                new StructureBlock("Allium", new BPos(6, 1, 6))
        ));//Fake StructBlock
        this.put("1x2_a1", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 3)),
                new StructureBlock("ChestSouth", new BPos(3, 1, 12))
        ));
        this.put("1x2_a2", List.of());
        this.put("1x2_a3", List.of(
                new StructureBlock("Warrior", new BPos(3, 2, 8))
        ));
        this.put("1x2_a4", List.of(
                new StructureBlock("Sampling", new BPos(6, 1, 5))
        ));//Fake StructBlock
        this.put("1x2_a5", List.of());
        this.put("1x2_a6", List.of(
                new StructureBlock("Axe", new BPos(2, 1, 8))
        ));//Fake StructBlock
        this.put("1x2_a7", List.of(
                new StructureBlock("Empty", new BPos(3, 1, 0))
        ));//Fake StructBlock
        this.put("1x2_a8", List.of(
                new StructureBlock("Warrior", new BPos(2, 1, 2))
        ));
        this.put("1x2_a9", List.of(
                new StructureBlock("Warrior", new BPos(5, 1, 1)),
                new StructureBlock("Empty", new BPos(0, 2, 3)),
                new StructureBlock("Empty", new BPos(0, 2, 5)),
                new StructureBlock("Empty", new BPos(0, 2, 7)),
                new StructureBlock("Empty", new BPos(0, 2, 9)),
                new StructureBlock("Empty", new BPos(0, 2, 11)),
                new StructureBlock("Empty", new BPos(3, 2, 3)),
                new StructureBlock("Empty", new BPos(3, 2, 5)),
                new StructureBlock("Empty", new BPos(3, 2, 7)),
                new StructureBlock("Empty", new BPos(3, 2, 9)),
                new StructureBlock("Empty", new BPos(3, 2, 11)),
                new StructureBlock("Empty", new BPos(5, 2, 6)),
                new StructureBlock("Empty", new BPos(5, 2, 8)),
                new StructureBlock("Empty", new BPos(5, 2, 10)),
                new StructureBlock("Empty", new BPos(5, 2, 11)),
                new StructureBlock("Empty", new BPos(0, 4, 3)),
                new StructureBlock("Empty", new BPos(0, 4, 5)),
                new StructureBlock("Empty", new BPos(0, 4, 7)),
                new StructureBlock("Empty", new BPos(0, 4, 9)),
                new StructureBlock("Empty", new BPos(0, 4, 11)),
                new StructureBlock("Empty", new BPos(3, 4, 3)),
                new StructureBlock("Empty", new BPos(3, 4, 5)),
                new StructureBlock("Empty", new BPos(3, 4, 7)),
                new StructureBlock("Empty", new BPos(3, 4, 9)),
                new StructureBlock("Empty", new BPos(3, 4, 11)),
                new StructureBlock("Empty", new BPos(5, 4, 6)),
                new StructureBlock("Empty", new BPos(5, 4, 7)),
                new StructureBlock("Empty", new BPos(5, 4, 9)),
                new StructureBlock("Empty", new BPos(5, 4, 11)),
                new StructureBlock("Empty", new BPos(0, 6, 3)),
                new StructureBlock("Empty", new BPos(0, 6, 5)),
                new StructureBlock("Empty", new BPos(0, 6, 7)),
                new StructureBlock("Empty", new BPos(0, 6, 9)),
                new StructureBlock("Empty", new BPos(0, 6, 11)),
                new StructureBlock("Empty", new BPos(3, 6, 3)),
                new StructureBlock("Empty", new BPos(3, 6, 5)),
                new StructureBlock("Empty", new BPos(3, 6, 7)),
                new StructureBlock("Empty", new BPos(3, 6, 9)),
                new StructureBlock("Empty", new BPos(3, 6, 11)),
                new StructureBlock("Empty", new BPos(5, 6, 6)),
                new StructureBlock("Empty", new BPos(5, 6, 8)),
                new StructureBlock("Empty", new BPos(5, 6, 10)),
                new StructureBlock("Empty", new BPos(5, 6, 11))
        ));
        this.put("1x2_b1", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 13))
        ));
        this.put("1x2_b2", List.of(
                new StructureBlock("Warrior", new BPos(5, 1, 11))
        ));
        this.put("1x2_b3", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 1, 0)),
                new StructureBlock("Warrior", new BPos(3, 1, 4))
        ));
        this.put("1x2_b4", List.of(
                new StructureBlock("ChestNorth", new BPos(4, 3, 9))
        ));
        this.put("1x2_b5", List.of());
        this.put("1x2_c1", List.of());
        this.put("1x2_c2", List.of());
        this.put("1x2_c3", List.of(
                new StructureBlock("Warrior", new BPos(4, 1, 6)),
                new StructureBlock("Warrior", new BPos(4, 1, 9)),
                new StructureBlock("Warrior", new BPos(4, 1, 12))
        ));
        this.put("1x2_c4", List.of());
        this.put("1x2_c_stairs", List.of());
        this.put("1x2_d1", List.of());
        this.put("1x2_d2", List.of(
                new StructureBlock("ChestWest", new BPos(6, 7, 12))
        ));
        this.put("1x2_d3", List.of(
                new StructureBlock("Warrior", new BPos(2, 2, 10)),
                new StructureBlock("Warrior", new BPos(4, 2, 10)),
                new StructureBlock("Mage", new BPos(3, 3, 3))
        ));
        this.put("1x2_d4", List.of());
        this.put("1x2_d5", List.of());
        this.put("1x2_d_stairs", List.of());
        this.put("1x2_s1", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 1, 4))
        ));
        this.put("1x2_s2", List.of(
                new StructureBlock("Pearl", new BPos(3, 4, 5))
        ));
        this.put("1x2_se1", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 9, 1)),
                new StructureBlock("ChestNorth", new BPos(3, 9, 13))
        ));
        this.put("2x2_a1", List.of(
                new StructureBlock("Warrior", new BPos(12, 1, 3))
        ));
        this.put("2x2_a2", List.of(
                new StructureBlock("Warrior", new BPos(9, 1, 2)),
                new StructureBlock("Empty", new BPos(0, 2, 1)),
                new StructureBlock("Empty", new BPos(0, 2, 2)),
                new StructureBlock("Empty", new BPos(0, 2, 4)),
                new StructureBlock("Empty", new BPos(0, 2, 5)),
                new StructureBlock("Empty", new BPos(0, 2, 7)),
                new StructureBlock("Empty", new BPos(0, 2, 8)),
                new StructureBlock("Empty", new BPos(0, 2, 10)),
                new StructureBlock("Empty", new BPos(0, 2, 11)),
                new StructureBlock("Empty", new BPos(6, 2, 4)),
                new StructureBlock("Empty", new BPos(6, 2, 5)),
                new StructureBlock("Empty", new BPos(6, 2, 7)),
                new StructureBlock("Empty", new BPos(6, 2, 8)),
                new StructureBlock("Empty", new BPos(6, 2, 10)),
                new StructureBlock("Empty", new BPos(6, 2, 11)),
                new StructureBlock("Empty", new BPos(8, 2, 6)),
                new StructureBlock("Empty", new BPos(8, 2, 7)),
                new StructureBlock("Empty", new BPos(8, 2, 9)),
                new StructureBlock("Empty", new BPos(8, 2, 10)),
                new StructureBlock("Empty", new BPos(8, 2, 12)),
                new StructureBlock("Empty", new BPos(8, 2, 13)),
                new StructureBlock("Empty", new BPos(14, 2, 6)),
                new StructureBlock("Empty", new BPos(14, 2, 7)),
                new StructureBlock("Empty", new BPos(14, 2, 9)),
                new StructureBlock("Empty", new BPos(14, 2, 10)),
                new StructureBlock("Empty", new BPos(14, 2, 12)),
                new StructureBlock("Empty", new BPos(14, 2, 13))
        ));
        this.put("2x2_a3", List.of());
        this.put("2x2_a4", List.of());
        this.put("2x2_b1", List.of(
                new StructureBlock("Mage", new BPos(2, 1, 8)),
                new StructureBlock("Warrior", new BPos(4, 1, 4)),
                new StructureBlock("Warrior", new BPos(8, 1, 9))
        ));
        this.put("2x2_b2", List.of(
                new StructureBlock("Mage", new BPos(2, 1, 7)),
                new StructureBlock("Warrior", new BPos(9, 1, 8)),
                new StructureBlock("Warrior", new BPos(13, 1, 2))
        ));
        this.put("2x2_b3", List.of());
        this.put("2x2_b4", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 3)),
                new StructureBlock("Mage", new BPos(3, 1, 8)),
                new StructureBlock("Warrior", new BPos(4, 1, 11))
        ));
        this.put("2x2_b5", List.of(
                new StructureBlock("ChestSouth", new BPos(7, 7, 0))
        ));
        this.put("2x2_s1", List.of());
        this.put("carpet_east", List.of());
        this.put("carpet_north", List.of());
        this.put("carpet_south_1", List.of());
        this.put("carpet_south_2", List.of());
        this.put("carpet_west_1", List.of());
        this.put("carpet_west_2", List.of());
        this.put("corridor_floor", List.of());
        this.put("entrance", List.of());
        this.put("indoors_door_1", List.of());
        this.put("indoors_door_2", List.of());
        this.put("indoors_wall_1", List.of());
        this.put("indoors_wall_2", List.of());
        this.put("roof", List.of());
        this.put("roof_corner", List.of());
        this.put("roof_front", List.of());
        this.put("roof_inner_corner", List.of());
        this.put("small_wall", List.of());
        this.put("small_wall_corner", List.of());
        this.put("wall_corner", List.of());
        this.put("wall_flat", List.of());
        this.put("wall_window", List.of());
    }};

    // For version 1.19 +
    public static final HashMap<String, List<StructureBlock>> STRUCTURE_BLOCKS_1_19 = new HashMap<>() {{
        this.put("1x1_a1", List.of());
        this.put("1x1_a2", List.of());
        this.put("1x1_a3", List.of());
        this.put("1x1_a4", List.of(
                new StructureBlock("ChestWest", new BPos(6, 6, 3))
        ));
        this.put("1x1_a5", List.of());
        this.put("1x1_as1", List.of(
                new StructureBlock("ChestWest", new BPos(5, 1, 1))
        ));
        this.put("1x1_as2", List.of());
        this.put("1x1_as3", List.of());
        this.put("1x1_as4", List.of());
        this.put("1x1_b1", List.of());
        this.put("1x1_b2", List.of());
        this.put("1x1_b3", List.of());
        this.put("1x1_b4", List.of());
        this.put("1x1_b5", List.of(
                new StructureBlock("Allium", new BPos(6, 1, 6))
        ));//Fake StructBlock
        this.put("1x2_a1", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 3)),
                new StructureBlock("ChestSouth", new BPos(3, 1, 12))
        ));
        this.put("1x2_a2", List.of());
        this.put("1x2_a3", List.of(
                new StructureBlock("Warrior", new BPos(3, 2, 8))
        ));
        this.put("1x2_a4", List.of(
                new StructureBlock("Sampling", new BPos(6, 1, 5))
        ));//Fake StructBlock
        this.put("1x2_a5", List.of());
        this.put("1x2_a6", List.of(
                new StructureBlock("Axe", new BPos(2, 1, 8))
        ));//Fake StructBlock
        this.put("1x2_a7", List.of(
                new StructureBlock("Empty", new BPos(3, 1, 0))
        ));//Fake StructBlock
        this.put("1x2_a8", List.of(
                new StructureBlock("Warrior", new BPos(2, 1, 2))
        ));
        this.put("1x2_a9", List.of(
                new StructureBlock("Warrior", new BPos(5, 1, 1)),
                new StructureBlock("Empty", new BPos(0, 2, 3)),
                new StructureBlock("Empty", new BPos(0, 2, 5)),
                new StructureBlock("Empty", new BPos(0, 2, 7)),
                new StructureBlock("Empty", new BPos(0, 2, 9)),
                new StructureBlock("Empty", new BPos(0, 2, 11)),
                new StructureBlock("Empty", new BPos(3, 2, 3)),
                new StructureBlock("Empty", new BPos(3, 2, 5)),
                new StructureBlock("Empty", new BPos(3, 2, 7)),
                new StructureBlock("Empty", new BPos(3, 2, 9)),
                new StructureBlock("Empty", new BPos(3, 2, 11)),
                new StructureBlock("Empty", new BPos(5, 2, 6)),
                new StructureBlock("Empty", new BPos(5, 2, 8)),
                new StructureBlock("Empty", new BPos(5, 2, 10)),
                new StructureBlock("Empty", new BPos(5, 2, 11)),
                new StructureBlock("Empty", new BPos(0, 4, 3)),
                new StructureBlock("Empty", new BPos(0, 4, 5)),
                new StructureBlock("Empty", new BPos(0, 4, 7)),
                new StructureBlock("Empty", new BPos(0, 4, 9)),
                new StructureBlock("Empty", new BPos(0, 4, 11)),
                new StructureBlock("Empty", new BPos(3, 4, 3)),
                new StructureBlock("Empty", new BPos(3, 4, 5)),
                new StructureBlock("Empty", new BPos(3, 4, 7)),
                new StructureBlock("Empty", new BPos(3, 4, 9)),
                new StructureBlock("Empty", new BPos(3, 4, 11)),
                new StructureBlock("Empty", new BPos(5, 4, 6)),
                new StructureBlock("Empty", new BPos(5, 4, 7)),
                new StructureBlock("Empty", new BPos(5, 4, 9)),
                new StructureBlock("Empty", new BPos(5, 4, 11)),
                new StructureBlock("Empty", new BPos(0, 6, 3)),
                new StructureBlock("Empty", new BPos(0, 6, 5)),
                new StructureBlock("Empty", new BPos(0, 6, 7)),
                new StructureBlock("Empty", new BPos(0, 6, 9)),
                new StructureBlock("Empty", new BPos(0, 6, 11)),
                new StructureBlock("Empty", new BPos(3, 6, 3)),
                new StructureBlock("Empty", new BPos(3, 6, 5)),
                new StructureBlock("Empty", new BPos(3, 6, 7)),
                new StructureBlock("Empty", new BPos(3, 6, 9)),
                new StructureBlock("Empty", new BPos(3, 6, 11)),
                new StructureBlock("Empty", new BPos(5, 6, 6)),
                new StructureBlock("Empty", new BPos(5, 6, 8)),
                new StructureBlock("Empty", new BPos(5, 6, 10)),
                new StructureBlock("Empty", new BPos(5, 6, 11))
        ));
        this.put("1x2_b1", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 13))
        ));
        this.put("1x2_b2", List.of(
                new StructureBlock("Warrior", new BPos(5, 1, 11))
        ));
        this.put("1x2_b3", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 1, 0)),
                new StructureBlock("Warrior", new BPos(3, 1, 4))
        ));
        this.put("1x2_b4", List.of(
                new StructureBlock("ChestNorth", new BPos(4, 3, 9))
        ));
        this.put("1x2_b5", List.of());
        this.put("1x2_c1", List.of());
        this.put("1x2_c2", List.of());
        this.put("1x2_c3", List.of(
                new StructureBlock("Warrior", new BPos(4, 1, 6)),
                new StructureBlock("Warrior", new BPos(4, 1, 9)),
                new StructureBlock("Warrior", new BPos(4, 1, 12))
        ));
        this.put("1x2_c4", List.of());
        this.put("1x2_c_stairs", List.of());
        this.put("1x2_d1", List.of());
        this.put("1x2_d2", List.of(
                new StructureBlock("ChestWest", new BPos(6, 7, 12))
        ));
        this.put("1x2_d3", List.of(
                new StructureBlock("Warrior", new BPos(2, 2, 10)),
                new StructureBlock("Warrior", new BPos(4, 2, 10)),
                new StructureBlock("Mage", new BPos(3, 3, 3))
        ));
        this.put("1x2_d4", List.of());
        this.put("1x2_d5", List.of());
        this.put("1x2_d_stairs", List.of());
        this.put("1x2_s1", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 1, 4))
        ));
        this.put("1x2_s2", List.of());
        this.put("1x2_se1", List.of(
                new StructureBlock("ChestSouth", new BPos(3, 9, 1)),
                new StructureBlock("ChestNorth", new BPos(3, 9, 13))
        ));
        this.put("2x2_a1", List.of(
                new StructureBlock("Warrior", new BPos(12, 1, 3)),
                new StructureBlock("Group of Allays", new BPos(2, 2, 8)),
                new StructureBlock("Group of Allays", new BPos(4, 2, 2)),
                new StructureBlock("Group of Allays", new BPos(5, 2, 12)),
                new StructureBlock("Group of Allays", new BPos(12, 2, 12))
        ));
        this.put("2x2_a2", List.of(
                new StructureBlock("Warrior", new BPos(9, 1, 2)),
                new StructureBlock("Empty", new BPos(0, 2, 1)),
                new StructureBlock("Empty", new BPos(0, 2, 2)),
                new StructureBlock("Empty", new BPos(0, 2, 4)),
                new StructureBlock("Empty", new BPos(0, 2, 5)),
                new StructureBlock("Empty", new BPos(0, 2, 7)),
                new StructureBlock("Empty", new BPos(0, 2, 8)),
                new StructureBlock("Empty", new BPos(0, 2, 10)),
                new StructureBlock("Empty", new BPos(0, 2, 11)),
                new StructureBlock("Empty", new BPos(6, 2, 4)),
                new StructureBlock("Empty", new BPos(6, 2, 5)),
                new StructureBlock("Empty", new BPos(6, 2, 7)),
                new StructureBlock("Empty", new BPos(6, 2, 8)),
                new StructureBlock("Empty", new BPos(6, 2, 10)),
                new StructureBlock("Empty", new BPos(6, 2, 11)),
                new StructureBlock("Empty", new BPos(8, 2, 6)),
                new StructureBlock("Empty", new BPos(8, 2, 7)),
                new StructureBlock("Empty", new BPos(8, 2, 9)),
                new StructureBlock("Empty", new BPos(8, 2, 10)),
                new StructureBlock("Empty", new BPos(8, 2, 12)),
                new StructureBlock("Empty", new BPos(8, 2, 13)),
                new StructureBlock("Empty", new BPos(14, 2, 6)),
                new StructureBlock("Empty", new BPos(14, 2, 7)),
                new StructureBlock("Empty", new BPos(14, 2, 9)),
                new StructureBlock("Empty", new BPos(14, 2, 10)),
                new StructureBlock("Empty", new BPos(14, 2, 12)),
                new StructureBlock("Empty", new BPos(14, 2, 13))
        ));
        this.put("2x2_a3", List.of());
        this.put("2x2_a4", List.of());
        this.put("2x2_b1", List.of(
                new StructureBlock("Mage", new BPos(2, 1, 8)),
                new StructureBlock("Warrior", new BPos(4, 1, 4)),
                new StructureBlock("Warrior", new BPos(8, 1, 9))
        ));
        this.put("2x2_b2", List.of(
                new StructureBlock("Mage", new BPos(2, 1, 7)),
                new StructureBlock("Warrior", new BPos(9, 1, 8)),
                new StructureBlock("Warrior", new BPos(13, 1, 2))
        ));
        this.put("2x2_b3", List.of());
        this.put("2x2_b4", List.of(
                new StructureBlock("Warrior", new BPos(3, 1, 3)),
                new StructureBlock("Mage", new BPos(3, 1, 8)),
                new StructureBlock("Warrior", new BPos(4, 1, 11))
        ));
        this.put("2x2_b5", List.of(
                new StructureBlock("ChestSouth", new BPos(7, 7, 0))
        ));
        this.put("2x2_s1", List.of());
        this.put("carpet_east", List.of());
        this.put("carpet_north", List.of());
        this.put("carpet_south_1", List.of());
        this.put("carpet_south_2", List.of());
        this.put("carpet_west_1", List.of());
        this.put("carpet_west_2", List.of());
        this.put("corridor_floor", List.of());
        this.put("entrance", List.of());
        this.put("indoors_door_1", List.of());
        this.put("indoors_door_2", List.of());
        this.put("indoors_wall_1", List.of());
        this.put("indoors_wall_2", List.of());
        this.put("roof", List.of());
        this.put("roof_corner", List.of());
        this.put("roof_front", List.of());
        this.put("roof_inner_corner", List.of());
        this.put("small_wall", List.of());
        this.put("small_wall_corner", List.of());
        this.put("wall_corner", List.of());
        this.put("wall_flat", List.of());
        this.put("wall_window", List.of());
    }};
}

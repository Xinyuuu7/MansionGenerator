package Xinyuiii.MansionGenerator.reecriture.MansionPools;

import com.seedfinding.mccore.util.pos.BPos;

public class StructureBlock {
    String name;
    BPos offset;

    public StructureBlock(String name, BPos offset) {
        this.name = name;
        this.offset = offset;
    }
}
package Xinyuiii.MansionGenerator.piece;

import com.seedfinding.mccore.util.pos.BPos;

public class Mob {
    BPos pos;
    String name;

    public Mob(BPos pos, String name) {
        this.pos = pos;
        this.name = name;
    }

    public BPos getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }
}
package Xinyuiii.MansionGenerator.Util;

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

    public void moveTo(BPos pos) {
        this.pos = pos;
    }

    public void finalizeSpawn1_18(XoroChunkRand rand) {
//        this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random spawn bonus", randomSource.triangle(0.0, 0.11485000000000001), AttributeModifier.Operation.MULTIPLY_BASE));
        rand.triangle(0.0, 0.11485000000000001);

//        if (randomSource.nextFloat() < 0.05F) {
//            this.setLeftHanded(true);
//        } else {
//            this.setLeftHanded(false);
//        }
        rand.nextFloat();

    }
}

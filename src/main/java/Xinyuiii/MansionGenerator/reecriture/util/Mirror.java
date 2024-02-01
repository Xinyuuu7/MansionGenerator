package Xinyuiii.MansionGenerator.reecriture.util;

import com.seedfinding.mccore.util.math.Vec3i;

public enum Mirror {
    NONE(new Vec3i(0, 0, 0)),
    LEFT_RIGHT(new Vec3i(0, 0, 1)),
    FRONT_BACK(new Vec3i(1, 0, 0));

    Mirror(Vec3i vec3i) {}
}
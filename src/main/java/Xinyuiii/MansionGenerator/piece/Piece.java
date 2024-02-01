package Xinyuiii.MansionGenerator.piece;

import Xinyuiii.MansionGenerator.reecriture.MansionPools.MansionStructureSize;
import Xinyuiii.MansionGenerator.reecriture.util.*;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.pos.BPos;

public class Piece {
    public PieceType type;
    public String name;
    public BPos pos;
    public Rotation rotation;
    public Mirror mirror;
    public BlockBox box;

    public Piece(PieceType type, String name, BPos pos, Rotation rotation) {
        this.type = type;
        this.name = name;
        this.pos = pos;
        this.rotation = rotation;
        this.mirror = Mirror.NONE;
        this.box = Util.getBoundingBox(pos,rotation,BPos.ORIGIN,Mirror.NONE, MansionStructureSize.STRUCTURE_SIZE.get(name));
    }

    public Piece(PieceType type, String name, BPos pos, Rotation rotation, Mirror mirror) {
        this.type = type;
        this.name = name;
        this.pos = pos;
        this.rotation = rotation;
        this.mirror = mirror;
        this.box = Util.getBoundingBox(pos,rotation,BPos.ORIGIN,mirror, MansionStructureSize.STRUCTURE_SIZE.get(name));
    }
}
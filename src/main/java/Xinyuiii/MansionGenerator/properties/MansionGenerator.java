package Xinyuiii.MansionGenerator.properties;

import Xinyuiii.MansionGenerator.piece.Piece;
import Xinyuiii.MansionGenerator.reecriture.util.Rotation;
import Xinyuiii.MansionGenerator.piece.*;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.pos.*;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcterrain.terrain.OverworldTerrainGenerator;

import java.util.*;

public class MansionGenerator {
    private final MCVersion version;
    private List<Piece> pieces;
    private long worldSeed;

    public MansionGenerator(MCVersion version) {
        this.version = version;
    }

    public boolean generate(OverworldTerrainGenerator otg, CPos pos, ChunkRand rand) {
        this.worldSeed = otg.getWorldSeed();
        return generate(worldSeed, pos.getX(), pos.getZ(), rand, otg);
    }

    public boolean generate(long worldSeed, int chunkX, int chunkZ, ChunkRand rand, OverworldTerrainGenerator otg) {
        rand.setCarverSeed(worldSeed, chunkX, chunkZ, version);
        Rotation rotation = Rotation.getRandom(rand);
        int i = 5;
        int j = 5;
        if (rotation == Rotation.CLOCKWISE_90) {
            i = -5;
        } else if (rotation == Rotation.CLOCKWISE_180) {
            i = -5;
            j = -5;
        } else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
            j = -5;
        }
        int k = (chunkX << 4) + 7;
        int l = (chunkZ << 4) + 7;
        int i1 = otg.getHeightInGround(k, l);
        int j1 = otg.getHeightInGround(k, l + j);
        int k1 = otg.getHeightInGround(k + i, l);
        int l1 = otg.getHeightInGround(k + i, l + j);
        int i2 = Math.min(Math.min(i1, j1), Math.min(k1, l1));
        if (i2 >= 60) {
            BPos pos = new BPos(chunkX * 16 + 8, i2 + 1, chunkZ * 16 + 8);
            pieces = new ArrayList<>();
            Grid grid = new Grid(rand);
            Placer placer = new Placer(rand);
            placer.createMansion(pos, rotation, pieces, grid);
            return true;
        }
        return false;
    }

    public List<Piece> getAllPieces() {
        return pieces;
    }

    public List<Piece> getAllRooms() {
        List<Piece> rooms = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.type.isRoom()) {
                rooms.add(piece);
            }
        }
        return rooms;
    }

    public List<Piece> getAllOthers() {
        List<Piece> others = new ArrayList<>();
        for (Piece piece : pieces) {
            if (!piece.type.isRoom()) {
                others.add(piece);
            }
        }
        return others;
    }
}
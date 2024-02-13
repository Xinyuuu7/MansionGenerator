package Xinyuiii.MansionGenerator.properties;

import Xinyuiii.MansionGenerator.piece.*;
import Xinyuiii.MansionGenerator.reecriture.NewXoroChunkRand;
import Xinyuiii.MansionGenerator.reecriture.util.Rotation;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mccore.version.UnsupportedVersion;
import com.seedfinding.mcfeature.loot.item.ItemStack;
import com.seedfinding.mcterrain.terrain.OverworldTerrainGenerator;

import java.util.ArrayList;
import java.util.List;

public class MansionGenerator {
    private final MCVersion version;
    private int chunkX;
    private int chunkZ;
    private int y;
    private Rotation rotation;
    private List<Piece> pieces;
    private long worldSeed;

    public MansionGenerator(MCVersion version) {
        this.version = version;
    }

    public void generate(OverworldTerrainGenerator otg, CPos chunkPos, ChunkRand rand) {
        if (version.isOlderThan(MCVersion.v1_11)){
            throw new UnsupportedVersion(version, " mansions");
        }
        this.chunkX = chunkPos.getX();
        this.chunkZ = chunkPos.getZ();
        this.worldSeed = otg.getWorldSeed();
        rand.setCarverSeed(worldSeed, chunkX, chunkZ, version);
        this.rotation = Rotation.getRandom(rand);
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
        this.y = Math.min(Math.min(i1, j1), Math.min(k1, l1));
        generate(rand);
    }

    public void generateSkipHeight(long worldSeed, CPos chunkPos, ChunkRand rand) {
        this.chunkX = chunkPos.getX();
        this.chunkZ = chunkPos.getZ();
        this.worldSeed = worldSeed;
        rand.setCarverSeed(worldSeed, chunkX, chunkZ, version);
        this.rotation = Rotation.getRandom(rand);
        this.y = 64;
        generate(rand);
    }

    private void generate(ChunkRand rand) {
        BPos pos = null;
        if (version.isBetween(MCVersion.v1_11, MCVersion.v1_18_2)) {
            pos = new BPos(chunkX * 16 + 8, y + 1, chunkZ * 16 + 8);
        }
        else {
            pos = new BPos(chunkX * 16 + 7, y, chunkZ * 16 + 7);
        }
        pieces = new ArrayList<>();
        Grid grid = new Grid(rand);
        Placer placer = new Placer(rand);
        placer.createMansion(pos, rotation, pieces, grid);
    }

    //allay generation is not fixed and can not be predicated
    public List<BPos> getAllays() {
        return pieces.stream().flatMap(x -> x.mobs.stream().filter(y -> y.getName().equals("Allay")).map(Mob::getPos)).toList();
    }

    public List<BPos> getEvokers() {
        return pieces.stream().flatMap(x -> x.mobs.stream().filter(y -> y.getName().equals("Evoker")).map(Mob::getPos)).toList();
    }

    public List<BPos> getVindicators() {
        return pieces.stream().flatMap(x -> x.mobs.stream().filter(y -> y.getName().equals("Vindicator")).map(Mob::getPos)).toList();
    }

    public List<Pair<BPos, List<ItemStack>>> getChests() {
        return pieces.stream().flatMap(x -> x.loot.stream()).toList();
    }

    public void generateDecoration() {
        List<Piece> generationPieces = new ArrayList<>(pieces);
        BlockBox maxbox = generationPieces.stream().map(x -> x.box).reduce((piece1, piece2) -> new BlockBox(Math.min(piece1.minX, piece2.minX), Math.min(piece1.minY, piece2.minY), Math.min(piece1.minZ, piece2.minZ),
                Math.max(piece1.maxX, piece2.maxX), Math.max(piece1.maxY, piece2.maxY), Math.max(piece1.maxZ, piece2.maxZ))).get();
        for (int x = maxbox.minX >> 4; x <= maxbox.maxX >> 4; x++) {
            for (int z = maxbox.minZ >> 4; z <= maxbox.maxZ >> 4; z++) {
                decorateChunk(generationPieces, x, z);
            }
        }
    }

    private void decorateChunk(List<Piece> generationPieces, int chunkX, int chunkZ) {
        BlockBox chunkBox = new BlockBox(chunkX * 16, chunkZ * 16, chunkX * 16 + 15, chunkZ * 16 + 15);
        if (version.isNewerOrEqualTo(MCVersion.v1_18)) {
            NewXoroChunkRand rand = new NewXoroChunkRand();
            if (version.isNewerOrEqualTo(MCVersion.v1_19_3)) {
                rand.setDecoratorSeed(worldSeed,chunkX,chunkZ,40005);
            }
            else {
                rand.setDecoratorSeed(worldSeed,chunkX,chunkZ,40001);
            }
            for (Piece piece : generationPieces) {
                if (piece.box.intersects(chunkBox)) {
                    piece.decorate(rand, chunkBox, version);
                }
            }
        } else {
            ChunkRand rand = new ChunkRand();
            rand.setDecoratorSeed(worldSeed, chunkX << 4, chunkZ << 4, 40001, version);
            for (Piece piece : generationPieces) {
                if (piece.box.intersects(chunkBox)) {
                    piece.decorate(rand, chunkBox, version);
                }
            }
        }
    }

    public List<Piece> getAllPieces() {
        return pieces;
    }

    public List<Piece> getAllRooms() {
        List<Piece> rooms = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.type.isRoom()) {
                piece.name = PieceType.ROOM_NAME.get(piece.name);
                rooms.add(piece);
            }
        }
        return rooms;
    }

    public List<Piece> getAllTechnicalStructures() {
        List<Piece> others = new ArrayList<>();
        for (Piece piece : pieces) {
            if (!piece.type.isRoom()) {
                others.add(piece);
            }
        }
        return others;
    }
}

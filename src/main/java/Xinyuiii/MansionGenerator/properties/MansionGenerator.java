package Xinyuiii.MansionGenerator.properties;

import Xinyuiii.MansionGenerator.piece.Grid;
import Xinyuiii.MansionGenerator.piece.Piece;
import Xinyuiii.MansionGenerator.piece.Placer;
import Xinyuiii.MansionGenerator.reecriture.Mob;
import Xinyuiii.MansionGenerator.reecriture.NewXoroChunkRand;
import Xinyuiii.MansionGenerator.reecriture.util.Rotation;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
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

    public boolean canGenerate(OverworldTerrainGenerator otg, CPos chunk, ChunkRand rand) {
        this.chunkX = chunk.getX();
        this.chunkZ = chunk.getZ();
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
        return y >= 60;
    }

    public void generateSkipHeight(long worldSeed, CPos chunk, ChunkRand rand) {
        this.chunkX = chunk.getX();
        this.chunkZ = chunk.getZ();
        this.worldSeed = worldSeed;
        rand.setCarverSeed(worldSeed, chunkX, chunkZ, version);
        this.rotation = Rotation.getRandom(rand);
        this.y = 64;
        generate(rand);
    }

    public void generate(ChunkRand rand) {
        BPos pos = new BPos(chunkX * 16 + 8, y + 1, chunkZ * 16 + 8);
        if (version.isNewerOrEqualTo(MCVersion.v1_18)) pos.subtract(1, 0, 1);
        //TODO only tested on 1.20.1, also I don't know why
        pieces = new ArrayList<>();
        Grid grid = new Grid(rand);
        Placer placer = new Placer(rand);
        placer.createMansion(pos, rotation, pieces, grid);
    }

    public List<BPos> getRooms(String name) {
        return pieces.stream().filter(x -> x.name.equals(name)).map(x -> x.pos).toList();
    }
    /*
    pearl "1x2_s2"
    allium "1x1_b5"
    sampling "1x2_a4"
    axe "1x2_a6"
    samll store room "1x2_a9"
    huge store room "2x2_a2"
    obbi diamond room "1x1_as3"
    lava diamond room "2x2_s1"
    large jail "2x2_a1"
    anvil room "1x2_a3"
    spider room "1x1_as2"
    wool room "1x2_a5"
    melon room "1x2_a8"
    */

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

    public List<Pair<BPos, List<ItemStack>>> getLoot() {
        return pieces.stream().flatMap(x -> x.loot.stream()).toList();
    }

    public void decorate() {
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
            rand.setDecoratorSeed(worldSeed, chunkX, chunkZ, 40005);//TODO only tested on 1.20.1
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

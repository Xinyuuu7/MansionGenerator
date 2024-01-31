package Xinyuiii.MansionGenerator;

import Xinyuiii.MansionGenerator.Util.*;
import Xinyuiii.MansionGenerator.piece.Grid;
import Xinyuiii.MansionGenerator.piece.Placer;
import Xinyuiii.MansionGenerator.reecriture.LootTables;
import Xinyuiii.MansionGenerator.reecriture.Pool;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockBox;
import com.seedfinding.mccore.util.data.Pair;
import com.seedfinding.mccore.util.pos.BPos;
import com.seedfinding.mccore.util.pos.CPos;
import com.seedfinding.mccore.version.MCVersion;
import com.seedfinding.mcfeature.loot.LootContext;
import com.seedfinding.mcfeature.loot.item.ItemStack;
import com.seedfinding.mcterrain.terrain.OverworldTerrainGenerator;

import java.util.ArrayList;
import java.util.List;

public class MansionGenerator {
    private final MCVersion version;
    private List<Piece> pieces;

    private long worldSeed;
    private static List<Pair<BPos, List<ItemStack>>> chests;
    private static List<Mob> mobs;

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

    public List<BPos> getPearls() {
        return pieces.stream().filter(x -> x.name.equals("1x2_s2")).map(x -> x.pos).toList();
    }

    public List<BPos> getEvokers() {
        return mobs.stream().filter(x -> x.getName().equals("Evoker")).map(Mob::getPos).toList();
    }

    public List<BPos> getVindicators() {
        return mobs.stream().filter(x -> x.getName().equals("Vindicator")).map(Mob::getPos).toList();
    }

    public List<BPos> getAllays() {
        return mobs.stream().filter(x -> x.getName().equals("Allay")).map(Mob::getPos).toList();
    }

    public List<Pair<BPos, List<ItemStack>>> getChests() {
        return chests;
    }

    public void decorate() {
        chests = new ArrayList<>();
        mobs = new ArrayList<>();

        List<Piece> generationPieces = new ArrayList<>(pieces);

        BlockBox maxbox = generationPieces.stream().map(x -> x.box).reduce((piece1, piece2) -> new BlockBox(Math.min(piece1.minX, piece2.minX), Math.min(piece1.minY, piece2.minY), Math.min(piece1.minZ, piece2.minZ),
                Math.max(piece1.maxX, piece2.maxX), Math.max(piece1.maxY, piece2.maxY), Math.max(piece1.maxZ, piece2.maxZ))).get();

        if (version.isNewerOrEqualTo(MCVersion.v1_18)) {
            XoroChunkRand rand = new XoroChunkRand();
            for (int x = maxbox.minX >> 4; x <= maxbox.maxX >> 4; x++) {
                for (int z = maxbox.minZ >> 4; z <= maxbox.maxZ >> 4; z++) {
                    decorateChunk1_18(generationPieces, x, z, rand);
                }
            }
        } else {
            ChunkRand rand = new ChunkRand();
            for (int x = maxbox.minX >> 4; x <= maxbox.maxX >> 4; x++) {
                for (int z = maxbox.minZ >> 4; z <= maxbox.maxZ >> 4; z++) {
                    decorateChunk(generationPieces, x, z, rand);
                }
            }
        }

    }

    public void decorateChunk(List<Piece> pieces, int chunkX, int chunkZ, ChunkRand rand) {
        rand.setDecoratorSeed(worldSeed, chunkX << 4, chunkZ << 4, 40001, version);//TODO
    }

    public void decorateChunk1_18(List<Piece> generationPieces, int chunkX, int chunkZ, XoroChunkRand rand) {
        BlockBox chunkBox = new BlockBox(chunkX * 16, chunkZ * 16, chunkX * 16 + 15, chunkZ * 16 + 15);
        rand.setDecoratorSeed(worldSeed, chunkX, chunkZ, 40001);//TODO dont know salt
        for (Piece piece : generationPieces) {
            if (piece.box.intersects(chunkBox)) {
                piece.decorate1_18(rand, chunkBox);
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

    public static class Piece {
        public PieceType type;
        public String name;
        public BPos pos;
        public BlockBox box;//TODO
        public Rotation rotation;
        public Mirror mirror;

        public Piece(PieceType type, String name, BPos pos, Rotation rotation) {
            this.type = type;
            this.name = name;
            this.pos = pos;
            this.rotation = rotation;
            this.mirror = Mirror.NONE;
        }

        public Piece(PieceType type, String name, BPos pos, Rotation rotation, Mirror mirror) {
            this.type = type;
            this.name = name;
            this.pos = pos;
            this.rotation = rotation;
            this.mirror = mirror;
        }

        public void decorate1_18(XoroChunkRand rand, BlockBox chunkBox) {
            List<String> strings = Pool.DATA.get(this.name);
            List<BPos> offsets = Pool.DATA_OFFSETS.get(this.name);
            for (int i = 0; i < strings.size(); i++) {
                handleString1_18(strings.get(i), offsets.get(i), rand, chunkBox);
            }
        }

        public void handleString1_18(String string, BPos offset, XoroChunkRand rand, BlockBox chunkBox) {
            BPos pos = this.pos.add(Util.rotate(offset, this.rotation));
            if (!chunkBox.contains(pos)) return;//TODO maybe
            if (string.startsWith("Chest")) {
                long lootTableSeed = rand.nextLong();
                LootContext context = new LootContext(lootTableSeed);
                List<ItemStack> itemStacks = LootTables.lootTableProvider(string).generate(context);
                chests.add(new Pair<>(pos, itemStacks));
            } else {
                List<Mob> list = new ArrayList<>();
                labelOfMobs:
                switch (string) {
                    case "Mage":
                        list.add(new Mob(pos, "Evoker"));
                        break;
                    case "Warrior":
                        list.add(new Mob(pos, "Vindicator"));
                        break;
                    case "Group of Allays":
                        int i = rand.nextInt(3) + 1;
                        int j = 0;

                        while (true) {
                            if (j >= i) {
                                break labelOfMobs;
                            }

                            list.add(new Mob(pos, "Allay"));
                            ++j;
                        }
                    default:
                        return;
                }

                for (Mob mob : list) {
                    if (mob != null) {
                        mob.moveTo(pos);
                        mob.finalizeSpawn1_18(rand);
//                    serverLevelAccessor.addFreshEntityWithPassengers(mob);//TODO I dont know if consumes random
                        mobs.add(mob);
                    }
                }
            }
        }
    }

    public enum PieceType {
        ROOM,
        OTHER;

        public boolean isRoom() {
            return this.equals(ROOM);
        }
    }
}

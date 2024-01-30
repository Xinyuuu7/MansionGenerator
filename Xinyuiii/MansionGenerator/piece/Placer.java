package Xinyuiii.MansionGenerator.piece;

import Xinyuiii.MansionGenerator.MansionGenerator.Piece;
import Xinyuiii.MansionGenerator.Util.Direction;
import Xinyuiii.MansionGenerator.Util.Mirror;
import Xinyuiii.MansionGenerator.Util.Rotation;
import Xinyuiii.MansionGenerator.Util.Util;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.block.BlockDirection;
import com.seedfinding.mccore.util.pos.BPos;

import java.util.ArrayList;
import java.util.List;

public class Placer {
    private final ChunkRand rand;
    private int startX;
    private int startY;

    public Placer(ChunkRand rand) {
        this.rand = rand;
    }

    public void createMansion(BPos pos, Rotation rotation, List<Piece> pieceList, Grid grid) {
        PlacementData woodlandmansionpieces$placementdata = new PlacementData();
        woodlandmansionpieces$placementdata.pos = pos;
        woodlandmansionpieces$placementdata.rotation = rotation;
        woodlandmansionpieces$placementdata.wallType = "wall_flat";
        PlacementData woodlandmansionpieces$placementdata1 = new PlacementData();
        this.entrance(pieceList, woodlandmansionpieces$placementdata);
        woodlandmansionpieces$placementdata1.pos = woodlandmansionpieces$placementdata.pos.relative(BlockDirection.UP,8);
        woodlandmansionpieces$placementdata1.rotation = woodlandmansionpieces$placementdata.rotation;
        woodlandmansionpieces$placementdata1.wallType = "wall_window";
        if (!pieceList.isEmpty()) {
            //NULL
        }
        SimpleGrid woodlandmansionpieces$simplegrid = grid.baseGrid;
        SimpleGrid woodlandmansionpieces$simplegrid1 = grid.thirdFloorGrid;
        this.startX = 8;
        this.startY = 5;
        int i = 8;
        int j = 4;
        this.traverseOuterWalls(pieceList, woodlandmansionpieces$placementdata, woodlandmansionpieces$simplegrid, Direction.SOUTH, this.startX, this.startY, i, j);
        this.traverseOuterWalls(pieceList, woodlandmansionpieces$placementdata1, woodlandmansionpieces$simplegrid, Direction.SOUTH, this.startX, this.startY, i, j);
        PlacementData woodlandmansionpieces$placementdata2 = new PlacementData();
        woodlandmansionpieces$placementdata2.pos = woodlandmansionpieces$placementdata.pos.relative(BlockDirection.UP,19);
        woodlandmansionpieces$placementdata2.rotation = woodlandmansionpieces$placementdata.rotation;
        woodlandmansionpieces$placementdata2.wallType = "wall_window";
        boolean flag = false;
        for(int k = 0; k < woodlandmansionpieces$simplegrid1.height && !flag; ++k) {
            for(int l = woodlandmansionpieces$simplegrid1.width - 1; l >= 0 && !flag; --l) {
                if (Grid.isHouse(woodlandmansionpieces$simplegrid1, l, k)) {
                    woodlandmansionpieces$placementdata2.pos = Util.offset(woodlandmansionpieces$placementdata2.pos,woodlandmansionpieces$placementdata2.rotation.rotate(Direction.SOUTH), 8 + (k - this.startY) * 8);
                    woodlandmansionpieces$placementdata2.pos = Util.offset(woodlandmansionpieces$placementdata2.pos,woodlandmansionpieces$placementdata2.rotation.rotate(Direction.EAST), 8 + (l - this.startX) * 8);
                    this.traverseWallPiece(pieceList, woodlandmansionpieces$placementdata2);
                    this.traverseOuterWalls(pieceList, woodlandmansionpieces$placementdata2, woodlandmansionpieces$simplegrid1, Direction.SOUTH, l, k, l, k);
                    flag = true;
                }
            }
        }
        this.createRoof(pieceList, pos.relative(BlockDirection.UP,16), rotation, woodlandmansionpieces$simplegrid, woodlandmansionpieces$simplegrid1);
        this.createRoof(pieceList, pos.relative(BlockDirection.UP,27), rotation, woodlandmansionpieces$simplegrid1, null);
        if (!pieceList.isEmpty()) {
            //NULL
        }
        RoomCollection[] awoodlandmansionpieces$roomcollection = new RoomCollection[]{new FirstFloor(), new SecondFloor(), new ThirdFloor()};
        for(int l2 = 0; l2 < 3; ++l2) {
            BPos blockpos = pos.relative(BlockDirection.UP,8 * l2 + (l2 == 2 ? 3 : 0));
            SimpleGrid woodlandmansionpieces$simplegrid2 = grid.floorRooms[l2];
            SimpleGrid woodlandmansionpieces$simplegrid3 = l2 == 2 ? woodlandmansionpieces$simplegrid1 : woodlandmansionpieces$simplegrid;
            String s = l2 == 0 ? "carpet_south_1" : "carpet_south_2";
            String s1 = l2 == 0 ? "carpet_west_1" : "carpet_west_2";
            for(int i1 = 0; i1 < woodlandmansionpieces$simplegrid3.height; ++i1) {
                for(int j1 = 0; j1 < woodlandmansionpieces$simplegrid3.width; ++j1) {
                    if (woodlandmansionpieces$simplegrid3.get(j1, i1) == 1) {
                        BPos blockpos1 = Util.offset(blockpos,rotation.rotate(Direction.SOUTH), 8 + (i1 - this.startY) * 8);
                        blockpos1 = Util.offset(blockpos1,rotation.rotate(Direction.EAST), (j1 - this.startX) * 8);
                        pieceList.add(new Piece("corridor_floor", blockpos1, rotation));
                        if (woodlandmansionpieces$simplegrid3.get(j1, i1 - 1) == 1 || (woodlandmansionpieces$simplegrid2.get(j1, i1 - 1) & 8388608) == 8388608) {
                            pieceList.add(new Piece("carpet_north", Util.offset(blockpos1,rotation.rotate(Direction.EAST), 1).relative(BlockDirection.UP), rotation));
                        }

                        if (woodlandmansionpieces$simplegrid3.get(j1 + 1, i1) == 1 || (woodlandmansionpieces$simplegrid2.get(j1 + 1, i1) & 8388608) == 8388608) {
                            pieceList.add(new Piece("carpet_east", blockpos1.offset(rotation.rotate(Direction.SOUTH), 1).offset(rotation.rotate(Direction.EAST), 5).up(), rotation));
                        }

                        if (woodlandmansionpieces$simplegrid3.get(j1, i1 + 1) == 1 || (woodlandmansionpieces$simplegrid2.get(j1, i1 + 1) & 8388608) == 8388608) {
                            pieceList.add(new Piece(s, blockpos1.offset(rotation.rotate(Direction.SOUTH), 5).offset(rotation.rotate(Direction.WEST), 1), rotation));
                        }

                        if (woodlandmansionpieces$simplegrid3.get(j1 - 1, i1) == 1 || (woodlandmansionpieces$simplegrid2.get(j1 - 1, i1) & 8388608) == 8388608) {
                            pieceList.add(new Piece(s1, blockpos1.offset(rotation.rotate(Direction.WEST), 1).offset(rotation.rotate(Direction.NORTH), 1), rotation));
                        }
                    }
                }
            }

            String s2 = l2 == 0 ? "indoors_wall_1" : "indoors_wall_2";
            String s3 = l2 == 0 ? "indoors_door_1" : "indoors_door_2";
            List<Direction> list = new ArrayList<>();

            for(int k1 = 0; k1 < woodlandmansionpieces$simplegrid3.height; ++k1) {
                for(int l1 = 0; l1 < woodlandmansionpieces$simplegrid3.width; ++l1) {
                    boolean flag1 = l2 == 2 && woodlandmansionpieces$simplegrid3.get(l1, k1) == 3;
                    if (woodlandmansionpieces$simplegrid3.get(l1, k1) == 2 || flag1) {
                        int i2 = woodlandmansionpieces$simplegrid2.get(l1, k1);
                        int j2 = i2 & 983040;
                        int k2 = i2 & '\uffff';
                        flag1 = flag1 && (i2 & 8388608) == 8388608;
                        list.clear();
                        if ((i2 & 2097152) == 2097152) {
                            for(Direction direction : Direction.Plane.HORIZONTAL) {
                                if (woodlandmansionpieces$simplegrid3.get(l1 + direction.getXOffset(), k1 + direction.getZOffset()) == 1) {
                                    list.add(direction);
                                }
                            }
                        }

                        Direction direction1 = null;
                        if (!list.isEmpty()) {
                            direction1 = list.get(this.rand.nextInt(list.size()));
                        } else if ((i2 & 1048576) == 1048576) {
                            direction1 = Direction.UP;
                        }

                        BPos blockpos3 = blockpos.offset(rotation.rotate(Direction.SOUTH), 8 + (k1 - this.startY) * 8);
                        blockpos3 = blockpos3.offset(rotation.rotate(Direction.EAST), -1 + (l1 - this.startX) * 8);
                        if (Grid.isHouse(woodlandmansionpieces$simplegrid3, l1 - 1, k1) && !grid.isRoomId(woodlandmansionpieces$simplegrid3, l1 - 1, k1, l2, k2)) {
                            pieceList.add(new Piece(direction1 == Direction.WEST ? s3 : s2, blockpos3, rotation));
                        }

                        if (woodlandmansionpieces$simplegrid3.get(l1 + 1, k1) == 1 && !flag1) {
                            BPos blockpos2 = blockpos3.offset(rotation.rotate(Direction.EAST), 8);
                            pieceList.add(new Piece(direction1 == Direction.EAST ? s3 : s2, blockpos2, rotation));
                        }

                        if (Grid.isHouse(woodlandmansionpieces$simplegrid3, l1, k1 + 1) && !grid.isRoomId(woodlandmansionpieces$simplegrid3, l1, k1 + 1, l2, k2)) {
                            BPos blockpos4 = blockpos3.offset(rotation.rotate(Direction.SOUTH), 7);
                            blockpos4 = blockpos4.offset(rotation.rotate(Direction.EAST), 7);
                            pieceList.add(new Piece(direction1 == Direction.SOUTH ? s3 : s2, blockpos4, rotation.add(Rotation.CLOCKWISE_90)));
                        }

                        if (woodlandmansionpieces$simplegrid3.get(l1, k1 - 1) == 1 && !flag1) {
                            BPos blockpos5 = blockpos3.offset(rotation.rotate(Direction.NORTH), 1);
                            blockpos5 = blockpos5.offset(rotation.rotate(Direction.EAST), 7);
                            pieceList.add(new Piece(direction1 == Direction.NORTH ? s3 : s2, blockpos5, rotation.add(Rotation.CLOCKWISE_90)));
                        }

                        if (j2 == 65536) {
                            this.addRoom1x1(pieceList, blockpos3, rotation, direction1, awoodlandmansionpieces$roomcollection[l2]);
                        } else if (j2 == 131072 && direction1 != null) {
                            Direction direction3 = grid.get1x2RoomDirection(woodlandmansionpieces$simplegrid3, l1, k1, l2, k2);
                            boolean flag2 = (i2 & 4194304) == 4194304;
                            this.addRoom1x2(pieceList, blockpos3, rotation, direction3, direction1, awoodlandmansionpieces$roomcollection[l2], flag2);
                        } else if (j2 == 262144 && direction1 != null && direction1 != Direction.UP) {
                            Direction direction2 = direction1.rotateY();
                            if (!grid.isRoomId(woodlandmansionpieces$simplegrid3, l1 + direction2.getXOffset(), k1 + direction2.getZOffset(), l2, k2)) {
                                direction2 = direction2.getOpposite();
                            }

                            this.addRoom2x2(pieceList, blockpos3, rotation, direction2, direction1, awoodlandmansionpieces$roomcollection[l2]);
                        } else if (j2 == 262144 && direction1 == Direction.UP) {
                            this.addRoom2x2Secret(pieceList, blockpos3, rotation, awoodlandmansionpieces$roomcollection[l2]);
                        }
                    }
                }
            }
        }

    }

    private void traverseOuterWalls(List<Piece> pieceList, PlacementData placementData, SimpleGrid simpleGrid, Direction direction1, int a, int b, int c, int d) {
        int i = a;
        int j = b;
        Direction direction2 = direction1;

        do {
            if (!Grid.isHouse(simpleGrid, i + direction1.getXOffset(), j + direction1.getZOffset())) {
                this.traverseTurn(pieceList, placementData);
                direction1 = direction1.rotateY();
                if (i != c || j != d || direction2 != direction1) {
                    this.traverseWallPiece(pieceList, placementData);
                }
            } else if (Grid.isHouse(simpleGrid, i + direction1.getXOffset(), j + direction1.getZOffset()) && Grid.isHouse(simpleGrid, i + direction1.getXOffset() + direction1.rotateYCCW().getXOffset(), j + direction1.getZOffset() + direction1.rotateYCCW().getZOffset())) {
                this.traverseInnerTurn(pieceList, placementData);
                i += direction1.getXOffset();
                j += direction1.getZOffset();
                direction1 = direction1.rotateYCCW();
            } else {
                i += direction1.getXOffset();
                j += direction1.getZOffset();
                if (i != c || j != d || direction2 != direction1) {
                    this.traverseWallPiece(pieceList, placementData);
                }
            }

        } while (i != c || j != d || direction2 != direction1);
    }

    private void createRoof(List<Piece> pieceList, BPos pos, Rotation rotation, SimpleGrid simpleGrid1, SimpleGrid simpleGrid2) {
        for(int i = 0; i < simpleGrid1.height; ++i) {
            for(int j = 0; j < simpleGrid1.width; ++j) {
                BPos lvt_8_3_ = Util.offset(pos,rotation.rotate(Direction.SOUTH),8 + (i - this.startY) * 8);
                lvt_8_3_ = Util.offset(pos,rotation.rotate(Direction.EAST),(j - this.startX) * 8);
                boolean flag = simpleGrid2 != null && Grid.isHouse(simpleGrid2, j, i);
                if (Grid.isHouse(simpleGrid1, j, i) && !flag) {
                    pieceList.add(new Piece("roof", lvt_8_3_.relative(BlockDirection.UP,3), rotation));
                    if (!Grid.isHouse(simpleGrid1, j + 1, i)) {
                        BPos blockpos1 = Util.offset(lvt_8_3_,rotation.rotate(Direction.EAST),6);
                        pieceList.add(new Piece("roof_front", blockpos1, rotation));
                    }
                    if (!Grid.isHouse(simpleGrid1, j - 1, i)) {
                        BPos blockpos5 = Util.offset(lvt_8_3_,rotation.rotate(Direction.EAST),0);
                        blockpos5 = Util.offset(blockpos5,rotation.rotate(Direction.SOUTH),7);
                        pieceList.add(new Piece("roof_front", blockpos5, rotation.add(Rotation.CLOCKWISE_180)));
                    }
                    if (!Grid.isHouse(simpleGrid1, j, i - 1)) {
                        BPos blockpos6 = Util.offset(lvt_8_3_,rotation.rotate(Direction.WEST),1);
                        pieceList.add(new Piece("roof_front", blockpos6, rotation.add(Rotation.COUNTERCLOCKWISE_90)));
                    }
                    if (!Grid.isHouse(simpleGrid1, j, i + 1)) {
                        BPos blockpos7 = Util.offset(lvt_8_3_,rotation.rotate(Direction.EAST),6);
                        blockpos7 = Util.offset(blockpos7,rotation.rotate(Direction.SOUTH),6);
                        pieceList.add(new Piece("roof_front", blockpos7, rotation.add(Rotation.CLOCKWISE_90)));
                    }
                }
            }
        }
        if (simpleGrid2 != null) {
            for(int k = 0; k < simpleGrid1.height; ++k) {
                for(int i1 = 0; i1 < simpleGrid1.width; ++i1) {
                    BPos blockpos3 = Util.offset(pos,rotation.rotate(Direction.SOUTH),8 + (k - this.startY) * 8);
                    blockpos3 = Util.offset(blockpos3,rotation.rotate(Direction.EAST),(i1 - this.startX) * 8);
                    boolean flag1 = Grid.isHouse(simpleGrid2, i1, k);
                    if (Grid.isHouse(simpleGrid1, i1, k) && flag1) {
                        if (!Grid.isHouse(simpleGrid1, i1 + 1, k)) {
                            BPos blockpos8 = Util.offset(blockpos3,rotation.rotate(Direction.EAST),7);
                            pieceList.add(new Piece("small_wall", blockpos8, rotation));
                        }
                        if (!Grid.isHouse(simpleGrid1, i1 - 1, k)) {
                            BPos blockpos9 = Util.offset(blockpos3,rotation.rotate(Direction.WEST),1);
                            blockpos9 = Util.offset(blockpos9,rotation.rotate(Direction.SOUTH),6);
                            pieceList.add(new Piece("small_wall", blockpos9, rotation.add(Rotation.CLOCKWISE_180)));
                        }
                        if (!Grid.isHouse(simpleGrid1, i1, k - 1)) {
                            BPos blockpos10 = Util.offset(blockpos3,rotation.rotate(Direction.WEST),0);
                            blockpos10 = Util.offset(blockpos10,rotation.rotate(Direction.NORTH),1);
                            pieceList.add(new Piece("small_wall", blockpos10, rotation.add(Rotation.COUNTERCLOCKWISE_90)));
                        }
                        if (!Grid.isHouse(simpleGrid1, i1, k + 1)) {
                            BPos blockpos11 = Util.offset(blockpos3,rotation.rotate(Direction.EAST),6);
                            blockpos11 = Util.offset(blockpos11,rotation.rotate(Direction.SOUTH),7);
                            pieceList.add(new Piece("small_wall", blockpos11, rotation.add(Rotation.CLOCKWISE_90)));
                        }
                        if (!Grid.isHouse(simpleGrid1, i1 + 1, k)) {
                            if (!Grid.isHouse(simpleGrid1, i1, k - 1)) {
                                BPos blockpos12 = Util.offset(blockpos3,rotation.rotate(Direction.EAST),7);
                                blockpos12 = Util.offset(blockpos12,rotation.rotate(Direction.NORTH),2);
                                pieceList.add(new Piece("small_wall_corner", blockpos12, rotation));
                            }
                            if (!Grid.isHouse(simpleGrid1, i1, k + 1)) {
                                BPos blockpos13 = Util.offset(blockpos3,rotation.rotate(Direction.EAST),8);
                                blockpos13 = Util.offset(blockpos13,rotation.rotate(Direction.SOUTH),7);
                                pieceList.add(new Piece("small_wall_corner", blockpos13, rotation.add(Rotation.CLOCKWISE_90)));
                            }
                        }
                        if (!Grid.isHouse(simpleGrid1, i1 - 1, k)) {
                            if (!Grid.isHouse(simpleGrid1, i1, k - 1)) {
                                BPos blockpos14 = Util.offset(blockpos3,rotation.rotate(Direction.WEST),2);
                                blockpos14 = Util.offset(blockpos14,rotation.rotate(Direction.NORTH),1);
                                pieceList.add(new Piece("small_wall_corner", blockpos14, rotation.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            if (!Grid.isHouse(simpleGrid1, i1, k + 1)) {
                                BPos blockpos15 = Util.offset(blockpos3,rotation.rotate(Direction.WEST),1);
                                blockpos15 = Util.offset(blockpos15,rotation.rotate(Direction.SOUTH),8);
                                pieceList.add(new Piece("small_wall_corner", blockpos15, rotation.add(Rotation.CLOCKWISE_180)));
                            }
                        }
                    }
                }
            }
        }
        for(int l = 0; l < simpleGrid1.height; ++l) {
            for(int j1 = 0; j1 < simpleGrid1.width; ++j1) {
                BPos blockpos4 = Util.offset(pos,rotation.rotate(Direction.SOUTH),8 + (l - this.startY) * 8);
                blockpos4 = Util.offset(blockpos4,rotation.rotate(Direction.EAST),(j1 - this.startX) * 8);
                boolean flag2 = simpleGrid2 != null && Grid.isHouse(simpleGrid2, j1, l);
                if (Grid.isHouse(simpleGrid1, j1, l) && !flag2) {
                    if (!Grid.isHouse(simpleGrid1, j1 + 1, l)) {
                        BPos blockpos16 = Util.offset(blockpos4,rotation.rotate(Direction.EAST),6);
                        if (!Grid.isHouse(simpleGrid1, j1, l + 1)) {
                            BPos blockpos2 = Util.offset(blockpos16,rotation.rotate(Direction.SOUTH),6);
                            pieceList.add(new Piece("roof_corner", blockpos2, rotation));
                        } else if (Grid.isHouse(simpleGrid1, j1 + 1, l + 1)) {
                            BPos blockpos18 = Util.offset(blockpos16,rotation.rotate(Direction.SOUTH),5);
                            pieceList.add(new Piece("roof_inner_corner", blockpos18, rotation));
                        }
                        if (!Grid.isHouse(simpleGrid1, j1, l - 1)) {
                            pieceList.add(new Piece("roof_corner", blockpos16, rotation.add(Rotation.COUNTERCLOCKWISE_90)));
                        } else if (Grid.isHouse(simpleGrid1, j1 + 1, l - 1)) {
                            BPos blockpos19 = Util.offset(blockpos4,rotation.rotate(Direction.EAST),9);
                            blockpos19 = Util.offset(blockpos19,rotation.rotate(Direction.NORTH),2);
                            pieceList.add(new Piece("roof_inner_corner", blockpos19, rotation.add(Rotation.CLOCKWISE_90)));
                        }
                    }
                    if (!Grid.isHouse(simpleGrid1, j1 - 1, l)) {
                        BPos blockpos17 = Util.offset(blockpos4,rotation.rotate(Direction.EAST),0);
                        blockpos17 = Util.offset(blockpos17,rotation.rotate(Direction.SOUTH),0);
                        if (!Grid.isHouse(simpleGrid1, j1, l + 1)) {
                            BPos blockpos20 = Util.offset(blockpos17,rotation.rotate(Direction.SOUTH), 6);
                            pieceList.add(new Piece("roof_corner", blockpos20, rotation.add(Rotation.CLOCKWISE_90)));
                        } else if (Grid.isHouse(simpleGrid1, j1 - 1, l + 1)) {
                            BPos blockpos21 = Util.offset(blockpos17,rotation.rotate(Direction.SOUTH),8);
                            blockpos21 = Util.offset(blockpos21,rotation.rotate(Direction.WEST),3);
                            pieceList.add(new Piece("roof_inner_corner", blockpos21, rotation.add(Rotation.COUNTERCLOCKWISE_90)));
                        }

                        if (!Grid.isHouse(simpleGrid1, j1, l - 1)) {
                            pieceList.add(new Piece("roof_corner", blockpos17, rotation.add(Rotation.CLOCKWISE_180)));
                        } else if (Grid.isHouse(simpleGrid1, j1 - 1, l - 1)) {
                            BPos blockpos22 = Util.offset(blockpos17,rotation.rotate(Direction.SOUTH), 1);
                            pieceList.add(new Piece("roof_inner_corner", blockpos22, rotation.add(Rotation.CLOCKWISE_180)));
                        }
                    }
                }
            }
        }
    }

    private void entrance(List<Piece> pieceList, PlacementData placementData) {
        Direction direction = placementData.rotation.rotate(Direction.WEST);
        pieceList.add(new Piece("entrance", Util.offset(placementData.pos,direction,9), placementData.rotation));
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.SOUTH),16);
    }

    private void traverseWallPiece(List<Piece> pieceList, PlacementData placementData) {
        pieceList.add(new Piece(placementData.wallType, Util.offset(placementData.pos,placementData.rotation.rotate(Direction.EAST), 7), placementData.rotation));
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.SOUTH), 8);
    }

    private void traverseTurn(List<Piece> pieceList, PlacementData placementData) {
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.SOUTH),-1);
        pieceList.add(new Piece("wall_corner", placementData.pos, placementData.rotation));
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.SOUTH), -7);
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.WEST), -6);
        placementData.rotation = placementData.rotation.add(Rotation.CLOCKWISE_90);
    }

    private void traverseInnerTurn(List<Piece> pieceList, PlacementData placementData) {
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.SOUTH), 6);
        placementData.pos = Util.offset(placementData.pos,placementData.rotation.rotate(Direction.EAST), 8);
        placementData.rotation = placementData.rotation.add(Rotation.COUNTERCLOCKWISE_90);
    }

    private void addRoom1x1(List<Piece> p_191129_1_, BPos p_191129_2_, Rotation p_191129_3_, Direction p_191129_4_, RoomCollection p_191129_5_) {
        Rotation rotation = Rotation.NONE;
        String s = p_191129_5_.get1x1(this.rand);
        if (p_191129_4_ != Direction.EAST) {
            if (p_191129_4_ == Direction.NORTH) {
                rotation = rotation.add(Rotation.COUNTERCLOCKWISE_90);
            } else if (p_191129_4_ == Direction.WEST) {
                rotation = rotation.add(Rotation.CLOCKWISE_180);
            } else if (p_191129_4_ == Direction.SOUTH) {
                rotation = rotation.add(Rotation.CLOCKWISE_90);
            } else {
                s = p_191129_5_.get1x1Secret(this.rand);
            }
        }

        BPos blockpos = Util.getZeroPositionWithTransform(new BPos(1, 0, 0), Mirror.NONE, rotation, 7, 7);
        rotation = rotation.add(p_191129_3_);
        blockpos = Util.rotate(blockpos,p_191129_3_);
        BPos blockpos1 = p_191129_2_.add(blockpos.getX(), 0, blockpos.getZ());
        p_191129_1_.add(new Piece(s, blockpos1, rotation));
    }

    private void addRoom1x2(List<Piece> p_191132_1_, BPos p_191132_2_, Rotation p_191132_3_, Direction p_191132_4_, Direction p_191132_5_, RoomCollection p_191132_6_, boolean p_191132_7_) {
        if (p_191132_5_ == Direction.EAST && p_191132_4_ == Direction.SOUTH) {
            BPos blockpos13 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos13, p_191132_3_));
        } else if (p_191132_5_ == Direction.EAST && p_191132_4_ == Direction.NORTH) {
            BPos blockpos12 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            blockpos12 = blockpos12.offset(p_191132_3_.rotate(Direction.SOUTH), 6);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos12, p_191132_3_, Mirror.LEFT_RIGHT));
        } else if (p_191132_5_ == Direction.WEST && p_191132_4_ == Direction.NORTH) {
            BPos blockpos11 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 7);
            blockpos11 = blockpos11.offset(p_191132_3_.rotate(Direction.SOUTH), 6);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos11, p_191132_3_.add(Rotation.CLOCKWISE_180)));
        } else if (p_191132_5_ == Direction.WEST && p_191132_4_ == Direction.SOUTH) {
            BPos blockpos10 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 7);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos10, p_191132_3_, Mirror.FRONT_BACK));
        } else if (p_191132_5_ == Direction.SOUTH && p_191132_4_ == Direction.EAST) {
            BPos blockpos9 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos9, p_191132_3_.add(Rotation.CLOCKWISE_90), Mirror.LEFT_RIGHT));
        } else if (p_191132_5_ == Direction.SOUTH && p_191132_4_ == Direction.WEST) {
            BPos blockpos8 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 7);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos8, p_191132_3_.add(Rotation.CLOCKWISE_90)));
        } else if (p_191132_5_ == Direction.NORTH && p_191132_4_ == Direction.WEST) {
            BPos blockpos7 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 7);
            blockpos7 = blockpos7.offset(p_191132_3_.rotate(Direction.SOUTH), 6);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos7, p_191132_3_.add(Rotation.CLOCKWISE_90), Mirror.FRONT_BACK));
        } else if (p_191132_5_ == Direction.NORTH && p_191132_4_ == Direction.EAST) {
            BPos blockpos6 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            blockpos6 = blockpos6.offset(p_191132_3_.rotate(Direction.SOUTH), 6);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2SideEntrance(this.rand, p_191132_7_), blockpos6, p_191132_3_.add(Rotation.COUNTERCLOCKWISE_90)));
        } else if (p_191132_5_ == Direction.SOUTH && p_191132_4_ == Direction.NORTH) {
            BPos blockpos5 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            blockpos5 = blockpos5.offset(p_191132_3_.rotate(Direction.NORTH), 8);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2FrontEntrance(this.rand, p_191132_7_), blockpos5, p_191132_3_));
        } else if (p_191132_5_ == Direction.NORTH && p_191132_4_ == Direction.SOUTH) {
            BPos blockpos4 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 7);
            blockpos4 = blockpos4.offset(p_191132_3_.rotate(Direction.SOUTH), 14);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2FrontEntrance(this.rand, p_191132_7_), blockpos4, p_191132_3_.add(Rotation.CLOCKWISE_180)));
        } else if (p_191132_5_ == Direction.WEST && p_191132_4_ == Direction.EAST) {
            BPos blockpos3 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 15);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2FrontEntrance(this.rand, p_191132_7_), blockpos3, p_191132_3_.add(Rotation.CLOCKWISE_90)));
        } else if (p_191132_5_ == Direction.EAST && p_191132_4_ == Direction.WEST) {
            BPos blockpos2 = p_191132_2_.offset(p_191132_3_.rotate(Direction.WEST), 7);
            blockpos2 = blockpos2.offset(p_191132_3_.rotate(Direction.SOUTH), 6);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2FrontEntrance(this.rand, p_191132_7_), blockpos2, p_191132_3_.add(Rotation.COUNTERCLOCKWISE_90)));
        } else if (p_191132_5_ == Direction.UP && p_191132_4_ == Direction.EAST) {
            BPos blockpos1 = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 15);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2Secret(this.rand), blockpos1, p_191132_3_.add(Rotation.CLOCKWISE_90)));
        } else if (p_191132_5_ == Direction.UP && p_191132_4_ == Direction.SOUTH) {
            BPos blockpos = p_191132_2_.offset(p_191132_3_.rotate(Direction.EAST), 1);
            blockpos = blockpos.offset(p_191132_3_.rotate(Direction.NORTH), 0);
            p_191132_1_.add(new Piece(p_191132_6_.get1x2Secret(this.rand), blockpos, p_191132_3_));
        }

    }

    private void addRoom2x2(List<Piece> p_191127_1_, BPos p_191127_2_, Rotation p_191127_3_, Direction p_191127_4_, Direction p_191127_5_, RoomCollection p_191127_6_) {
        int i = 0;
        int j = 0;
        Rotation rotation = p_191127_3_;
        Mirror mirror = Mirror.NONE;
        if (p_191127_5_ == Direction.EAST && p_191127_4_ == Direction.SOUTH) {
            i = -7;
        } else if (p_191127_5_ == Direction.EAST && p_191127_4_ == Direction.NORTH) {
            i = -7;
            j = 6;
            mirror = Mirror.LEFT_RIGHT;
        } else if (p_191127_5_ == Direction.NORTH && p_191127_4_ == Direction.EAST) {
            i = 1;
            j = 14;
            rotation = p_191127_3_.add(Rotation.COUNTERCLOCKWISE_90);
        } else if (p_191127_5_ == Direction.NORTH && p_191127_4_ == Direction.WEST) {
            i = 7;
            j = 14;
            rotation = p_191127_3_.add(Rotation.COUNTERCLOCKWISE_90);
            mirror = Mirror.LEFT_RIGHT;
        } else if (p_191127_5_ == Direction.SOUTH && p_191127_4_ == Direction.WEST) {
            i = 7;
            j = -8;
            rotation = p_191127_3_.add(Rotation.CLOCKWISE_90);
        } else if (p_191127_5_ == Direction.SOUTH && p_191127_4_ == Direction.EAST) {
            i = 1;
            j = -8;
            rotation = p_191127_3_.add(Rotation.CLOCKWISE_90);
            mirror = Mirror.LEFT_RIGHT;
        } else if (p_191127_5_ == Direction.WEST && p_191127_4_ == Direction.NORTH) {
            i = 15;
            j = 6;
            rotation = p_191127_3_.add(Rotation.CLOCKWISE_180);
        } else if (p_191127_5_ == Direction.WEST && p_191127_4_ == Direction.SOUTH) {
            i = 15;
            mirror = Mirror.FRONT_BACK;
        }

        BPos blockpos = p_191127_2_.offset(p_191127_3_.rotate(Direction.EAST), i);
        blockpos = blockpos.offset(p_191127_3_.rotate(Direction.SOUTH), j);
        p_191127_1_.add(new Piece(p_191127_6_.get2x2(this.rand), blockpos, rotation, mirror));
    }

    private void addRoom2x2Secret(List<Piece> p_191128_1_, BPos p_191128_2_, Rotation p_191128_3_, RoomCollection p_191128_4_) {
        BPos blockpos = p_191128_2_.offset(p_191128_3_.rotate(Direction.EAST), 1);
        p_191128_1_.add(new Piece(p_191128_4_.get2x2Secret(this.rand), blockpos, p_191128_3_, Mirror.NONE));
    }
}

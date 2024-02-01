package Xinyuiii.MansionGenerator.piece;

import Xinyuiii.MansionGenerator.reecriture.util.*;
import com.seedfinding.mccore.rand.ChunkRand;
import com.seedfinding.mccore.util.data.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Grid {
    public final SimpleGrid baseGrid;
    public final SimpleGrid thirdFloorGrid;
    public final SimpleGrid[] floorRooms;
    private final ChunkRand rand;
    public Grid(ChunkRand rand) {
        this.rand = rand;
        int i = 11;
        baseGrid = new SimpleGrid(11, 11, 5);
        baseGrid.set(7, 4, 8, 5, 3);
        baseGrid.set(6, 4, 6, 5, 2);
        baseGrid.set(9, 3, 10, 7, 5);
        baseGrid.set(8, 2, 8, 3, 1);
        baseGrid.set(8, 6, 8, 7, 1);
        baseGrid.set(6, 3, 1);
        baseGrid.set(6, 6, 1);
        baseGrid.set(0, 0, 11, 1, 5);
        baseGrid.set(0, 9, 11, 11, 5);
        recursiveCorridor(baseGrid, 7, 2, Direction.WEST, 6);
        recursiveCorridor(baseGrid, 7, 7, Direction.WEST, 6);
        recursiveCorridor(baseGrid, 5, 3, Direction.WEST, 3);
        recursiveCorridor(baseGrid, 5, 6, Direction.WEST, 3);
        while(cleanEdges(baseGrid)) {
            //NULL
        }
        floorRooms = new SimpleGrid[3];
        floorRooms[0] = new SimpleGrid(11, 11, 5);
        floorRooms[1] = new SimpleGrid(11, 11, 5);
        floorRooms[2] = new SimpleGrid(11, 11, 5);
        identifyRooms(baseGrid, floorRooms[0]);
        identifyRooms(baseGrid, floorRooms[1]);
        floorRooms[0].set(8, 4, 8, 5, 8388608);
        floorRooms[1].set(8, 4, 8, 5, 8388608);
        thirdFloorGrid = new SimpleGrid(baseGrid.width, baseGrid.height, 5);
        setupThirdFloor();
        identifyRooms(thirdFloorGrid, floorRooms[2]);
    }

    public static boolean isHouse(SimpleGrid simpleGrid, int a, int b) {
        int i = simpleGrid.get(a, b);
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public boolean isRoomId(SimpleGrid simpleGrid, int a, int b, int c, int d) {
        return (floorRooms[c].get(a, b) & '\uffff') == d;
    }

    @Nullable
    public Direction get1x2RoomDirection(SimpleGrid simpleGrid, int a, int b, int c, int d) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (isRoomId(simpleGrid, a + direction.getXOffset(), b + direction.getZOffset(), c, d)) {
                return direction;
            }
        }
        return null;
    }

    private void recursiveCorridor(SimpleGrid simpleGrid, int a, int b, Direction blockDirection, int c) {
        if (c > 0) {
            simpleGrid.set(a, b, 1);
            simpleGrid.setIf(a + blockDirection.getXOffset(), b + blockDirection.getZOffset(), 0, 1);
            for(int i = 0; i < 8; ++i) {
                Direction direction = Direction.byHorizontalIndex(rand.nextInt(4));
                if (direction != blockDirection.getOpposite() && (direction != Direction.EAST || !rand.nextBoolean())) {
                    int j = a + blockDirection.getXOffset();
                    int k = b + blockDirection.getZOffset();
                    if (simpleGrid.get(j + direction.getXOffset(), k + direction.getZOffset()) == 0 && simpleGrid.get(j + direction.getXOffset() * 2, k + direction.getZOffset() * 2) == 0) {
                        recursiveCorridor(simpleGrid, a + blockDirection.getXOffset() + direction.getXOffset(), b + blockDirection.getZOffset() + direction.getZOffset(), direction, c - 1);
                        break;
                    }
                }
            }
            Direction direction1 = blockDirection.rotateY();
            Direction direction2 = blockDirection.rotateYCCW();
            simpleGrid.setIf(a + direction1.getXOffset(), b + direction1.getZOffset(), 0, 2);
            simpleGrid.setIf(a + direction2.getXOffset(), b + direction2.getZOffset(), 0, 2);
            simpleGrid.setIf(a + blockDirection.getXOffset() + direction1.getXOffset(), b + blockDirection.getZOffset() + direction1.getZOffset(), 0, 2);
            simpleGrid.setIf(a + blockDirection.getXOffset() + direction2.getXOffset(), b + blockDirection.getZOffset() + direction2.getZOffset(), 0, 2);
            simpleGrid.setIf(a + blockDirection.getXOffset() * 2, b + blockDirection.getZOffset() * 2, 0, 2);
            simpleGrid.setIf(a + direction1.getXOffset() * 2, b + direction1.getZOffset() * 2, 0, 2);
            simpleGrid.setIf(a + direction2.getXOffset() * 2, b + direction2.getZOffset() * 2, 0, 2);
        }
    }

    private boolean cleanEdges(SimpleGrid simpleGrid) {
        boolean flag = false;
        for(int i = 0; i < simpleGrid.height; ++i) {
            for(int j = 0; j < simpleGrid.width; ++j) {
                if (simpleGrid.get(j, i) == 0) {
                    int k = 0;
                    k = k + (isHouse(simpleGrid, j + 1, i) ? 1 : 0);
                    k = k + (isHouse(simpleGrid, j - 1, i) ? 1 : 0);
                    k = k + (isHouse(simpleGrid, j, i + 1) ? 1 : 0);
                    k = k + (isHouse(simpleGrid, j, i - 1) ? 1 : 0);
                    if (k >= 3) {
                        simpleGrid.set(j, i, 2);
                        flag = true;
                    } else if (k == 2) {
                        int l = 0;
                        l = l + (isHouse(simpleGrid, j + 1, i + 1) ? 1 : 0);
                        l = l + (isHouse(simpleGrid, j - 1, i + 1) ? 1 : 0);
                        l = l + (isHouse(simpleGrid, j + 1, i - 1) ? 1 : 0);
                        l = l + (isHouse(simpleGrid, j - 1, i - 1) ? 1 : 0);
                        if (l <= 1) {
                            simpleGrid.set(j, i, 2);
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    private void setupThirdFloor() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        SimpleGrid woodlandmansionpieces$simplegrid = floorRooms[1];

        for(int i = 0; i < thirdFloorGrid.height; ++i) {
            for(int j = 0; j < thirdFloorGrid.width; ++j) {
                int k = woodlandmansionpieces$simplegrid.get(j, i);
                int l = k & 983040;
                if (l == 131072 && (k & 2097152) == 2097152) {
                    list.add(new Pair<>(j, i));
                }
            }
        }
        if (list.isEmpty()) {
            thirdFloorGrid.set(0, 0, thirdFloorGrid.width, thirdFloorGrid.height, 5);
        } else {
            Pair<Integer, Integer> pair = list.get(rand.nextInt(list.size()));
            int l1 = woodlandmansionpieces$simplegrid.get(pair.getFirst(), pair.getSecond());
            woodlandmansionpieces$simplegrid.set(pair.getFirst(), pair.getSecond(), l1 | 4194304);
            Direction direction1 = get1x2RoomDirection(baseGrid, pair.getFirst(), pair.getSecond(), 1, l1 & '\uffff');
            int i2 = pair.getFirst() + direction1.getXOffset();
            int i1 = pair.getSecond() + direction1.getZOffset();
            for(int j1 = 0; j1 < thirdFloorGrid.height; ++j1) {
                for(int k1 = 0; k1 < thirdFloorGrid.width; ++k1) {
                    if (!isHouse(baseGrid, k1, j1)) {
                        thirdFloorGrid.set(k1, j1, 5);
                    } else if (k1 == pair.getFirst() && j1 == pair.getSecond()) {
                        thirdFloorGrid.set(k1, j1, 3);
                    } else if (k1 == i2 && j1 == i1) {
                        thirdFloorGrid.set(k1, j1, 3);
                        floorRooms[2].set(k1, j1, 8388608);
                    }
                }
            }
            List<Direction> list1 = new ArrayList<>();
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                if (thirdFloorGrid.get(i2 + direction.getXOffset(), i1 + direction.getZOffset()) == 0) {
                    list1.add(direction);
                }
            }
            if (list1.isEmpty()) {
                thirdFloorGrid.set(0, 0, thirdFloorGrid.width, thirdFloorGrid.height, 5);
                woodlandmansionpieces$simplegrid.set(pair.getFirst(), pair.getSecond(), l1);
            } else {
                Direction direction2 = list1.get(rand.nextInt(list1.size()));
                recursiveCorridor(thirdFloorGrid, i2 + direction2.getXOffset(), i1 + direction2.getZOffset(), direction2, 4);
                while(cleanEdges(thirdFloorGrid)) {
                }
            }
        }
    }

    private void identifyRooms(SimpleGrid simpleGrid1, SimpleGrid simpleGrid2) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for(int i = 0; i < simpleGrid1.height; ++i) {
            for(int j = 0; j < simpleGrid1.width; ++j) {
                if (simpleGrid1.get(j, i) == 2) {
                    list.add(new Pair<>(j, i));
                }
            }
        }
        Util.shuffle(list,rand);
        int k3 = 10;
        for(Pair<Integer, Integer> pair : list) {
            int k = pair.getFirst();
            int l = pair.getSecond();
            if (simpleGrid2.get(k, l) == 0) {
                int i1 = k;
                int j1 = k;
                int k1 = l;
                int l1 = l;
                int i2 = 65536;
                if (simpleGrid2.get(k + 1, l) == 0 && simpleGrid2.get(k, l + 1) == 0 && simpleGrid2.get(k + 1, l + 1) == 0 && simpleGrid1.get(k + 1, l) == 2 && simpleGrid1.get(k, l + 1) == 2 && simpleGrid1.get(k + 1, l + 1) == 2) {
                    j1 = k + 1;
                    l1 = l + 1;
                    i2 = 262144;
                } else if (simpleGrid2.get(k - 1, l) == 0 && simpleGrid2.get(k, l + 1) == 0 && simpleGrid2.get(k - 1, l + 1) == 0 && simpleGrid1.get(k - 1, l) == 2 && simpleGrid1.get(k, l + 1) == 2 && simpleGrid1.get(k - 1, l + 1) == 2) {
                    i1 = k - 1;
                    l1 = l + 1;
                    i2 = 262144;
                } else if (simpleGrid2.get(k - 1, l) == 0 && simpleGrid2.get(k, l - 1) == 0 && simpleGrid2.get(k - 1, l - 1) == 0 && simpleGrid1.get(k - 1, l) == 2 && simpleGrid1.get(k, l - 1) == 2 && simpleGrid1.get(k - 1, l - 1) == 2) {
                    i1 = k - 1;
                    k1 = l - 1;
                    i2 = 262144;
                } else if (simpleGrid2.get(k + 1, l) == 0 && simpleGrid1.get(k + 1, l) == 2) {
                    j1 = k + 1;
                    i2 = 131072;
                } else if (simpleGrid2.get(k, l + 1) == 0 && simpleGrid1.get(k, l + 1) == 2) {
                    l1 = l + 1;
                    i2 = 131072;
                } else if (simpleGrid2.get(k - 1, l) == 0 && simpleGrid1.get(k - 1, l) == 2) {
                    i1 = k - 1;
                    i2 = 131072;
                } else if (simpleGrid2.get(k, l - 1) == 0 && simpleGrid1.get(k, l - 1) == 2) {
                    k1 = l - 1;
                    i2 = 131072;
                }
                int j2 = rand.nextBoolean() ? i1 : j1;
                int k2 = rand.nextBoolean() ? k1 : l1;
                int l2 = 2097152;
                if (simpleGrid1.edgesTo(j2, k2, 1)) {
                    j2 = j2 == i1 ? j1 : i1;
                    k2 = k2 == k1 ? l1 : k1;
                    if (simpleGrid1.edgesTo(j2, k2, 1)) {
                        k2 = k2 == k1 ? l1 : k1;
                        if (simpleGrid1.edgesTo(j2, k2, 1)) {
                            j2 = j2 == i1 ? j1 : i1;
                            k2 = k2 == k1 ? l1 : k1;
                            if (simpleGrid1.edgesTo(j2, k2, 1)) {
                                l2 = 0;
                                j2 = i1;
                                k2 = k1;
                            }
                        }
                    }
                }
                for(int i3 = k1; i3 <= l1; ++i3) {
                    for(int j3 = i1; j3 <= j1; ++j3) {
                        if (j3 == j2 && i3 == k2) {
                            simpleGrid2.set(j3, i3, 1048576 | l2 | i2 | k3);
                        } else {
                            simpleGrid2.set(j3, i3, i2 | k3);
                        }
                    }
                }
                ++k3;
            }
        }
    }
}
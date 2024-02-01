package Xinyuiii.MansionGenerator.piece;

public enum PieceType {
    ROOM,
    OTHER;

    public boolean isRoom() {
        return this.equals(ROOM);
    }
}
public enum Direction {

    N(-1, 0),
    S(1, 0),
    E(0, 1),
    W(0, -1),
    NE(-1, 1),
    NW(-1, -1),
    SE(1, 1),
    SW(1, -1);

    private final int rowOffset;
    private final int colOffset;

    Direction(int rowOffset, int colOffset){
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public int getRowOffset(){ return rowOffset;}
    public int getColOffset() {return colOffset;}
}

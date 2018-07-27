package WEBminiTuringMachine;

public class TuringMachineStateAction {

    private char tapeSymbol;
    private char writeSymbol;
    private char moveDirection;
    private int nextStateNumber;

    public TuringMachineStateAction(char tape, char write, char move, int go) {
       this.tapeSymbol=tape;
        this.writeSymbol = write;
        this.moveDirection = move;
        this.nextStateNumber = go;
    }

    public TuringMachineStateAction(char tape) {
        this.tapeSymbol=tape;
        this.writeSymbol = '0';
        this.moveDirection = '0';
        this.nextStateNumber = 0;
    }

    public char getMoveDirection() {
        return moveDirection;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public int getNextStateNumber() {
        return nextStateNumber;
    }

    public char getTapeSymbol() {
        if (this.tapeSymbol != '0') {
            return tapeSymbol;
        }
        else
            return '0';
    }
}

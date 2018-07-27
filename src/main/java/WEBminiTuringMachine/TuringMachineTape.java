package WEBminiTuringMachine;

public class TuringMachineTape {

    private String tape;
    private int tapePosition;

    public void moveTapeNext() {
        this.tapePosition++;
    }

    public void moveTapePrevious() {
        this.tapePosition--;
    }

    public char readTape() {
        try {
            return tape.charAt(tapePosition);
        } catch (StringIndexOutOfBoundsException e) {
            StringBuilder sb = new StringBuilder(this.tape);
            sb.append("#");
            this.tape = sb.toString();
        }

        return tape.charAt(tapePosition);
    }

    private String convertToUnarySystem(int inputNumber) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < inputNumber; i++) {
            sb.append("1");
        }
        return sb.toString();
    }

    private String createTape(int firstNumber, int secondNumber, String operation) {
        this.tapePosition = 0;
        String firstInputUnaryNumber = convertToUnarySystem(firstNumber);
        String secondInputUnaryNumber = convertToUnarySystem(secondNumber);
        StringBuilder sb = new StringBuilder("#");
        sb.append(firstInputUnaryNumber);
        sb.append(operation);
        sb.append(secondInputUnaryNumber);
        sb.append("#");
        return sb.toString();
    }

    public void createAdditionTape(int firstNumber, int secondNumber) {
        this.tape = createTape(firstNumber, secondNumber, "+");
    }

    public void createSubtractionTape(int firstNumber, int secondNumber) {
        this.tape = createTape(firstNumber, secondNumber, "-");
    }

    public void createMultiplicationTape(int firstNumber, int secondNumber) {
        this.tape = createTape(firstNumber, secondNumber, "*");
    }

    public void createDivisionTape(int firstNumber, int secondNumber) {
        if (firstNumber%secondNumber==0) {
            this.tape = createTape(firstNumber, secondNumber, ":");
        }
        else throw new IllegalArgumentException("Input is not distributable");
    }

    public String getTape() {
        return tape;
    }

    public int getDecimalTape() {
        int result = 0;
        short sign = 1;
        for (int i = 0; i < this.tape.length(); i++) {
            if (this.tape.charAt(i) == '1') {
                result++;
            }
            if (this.tape.charAt(i) == '-') {
                sign = -1;
            }
        }
        return result * sign;
    }

    public void writeOnTape(char newValue) {
        StringBuilder sb = new StringBuilder(this.tape);
        sb.setCharAt(this.tapePosition, newValue);
        this.tape = sb.toString();
    }

    public int getTapePosition() {
        return tapePosition;
    }
}



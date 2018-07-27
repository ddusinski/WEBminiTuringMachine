package WEBminiTuringMachine;

import java.util.HashMap;

public class TuringMachineState {
    private int stateNumber;
    private HashMap<Character, TuringMachineStateAction> turingMachineState;
    public TuringMachineState(int stateNumber, TuringMachineStateAction... stateAction) {

        this.turingMachineState = new HashMap<Character, TuringMachineStateAction>();
        this.stateNumber=stateNumber;

        for (TuringMachineStateAction i :stateAction) {

            this.turingMachineState.put(i.getTapeSymbol(),i);
        }
    }

    public int getStateNumber() {
        return this.stateNumber;
    }

    public TuringMachineStateAction getStateAction(char tapeChar) {
        return  this.turingMachineState.get(tapeChar);
    }


}

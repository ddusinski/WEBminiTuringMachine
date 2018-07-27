package WEBminiTuringMachine;

import java.util.ArrayList;

public class TuringMachineStatesListAddition implements TuringMachineStatesList {

    private ArrayList<TuringMachineState> statesList;

    public TuringMachineStatesListAddition() {

        this.statesList = new ArrayList<TuringMachineState>();

        this.statesList.add(new TuringMachineState(0,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('+'),
                new TuringMachineStateAction('#', '#', 'R', 1)
        ));
        this.statesList.add(new TuringMachineState(1,
                new TuringMachineStateAction('1', '1', 'R', 1),
                new TuringMachineStateAction('+', '1', 'R', 1),
                new TuringMachineStateAction('#', '#', 'L', 2)
        ));
        this.statesList.add(new TuringMachineState(2,
                new TuringMachineStateAction('1', '#', 'R', 3),
                new TuringMachineStateAction('+'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(3,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('+'),
                new TuringMachineStateAction('#')
        ));

    }

    public TuringMachineState getState(int stateNumber) {
        return this.statesList.get(stateNumber);
    }

    public int getMaxStatesNumber()
    {
        return this.statesList.size()-1;
    }





}

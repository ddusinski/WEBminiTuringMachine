package WEBminiTuringMachine;

import java.util.ArrayList;

public class TuringMachineStatesListSubtraction implements TuringMachineStatesList {

    private ArrayList<TuringMachineState> statesList;

    public TuringMachineStatesListSubtraction() {

        this.statesList = new ArrayList<TuringMachineState>();

        this.statesList.add(new TuringMachineState(0,
                new TuringMachineStateAction('1' ),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#', '#', 'R', 1)
        ));
        this.statesList.add(new TuringMachineState(1,
                new TuringMachineStateAction('1', '#', 'R', 2),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(2,
                new TuringMachineStateAction('1', '1', 'R', 2),
                new TuringMachineStateAction('-', '-', 'R', 3),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(3,
                new TuringMachineStateAction('1', '1', 'R', 3),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#', '#', 'L', 4)
        ));
        this.statesList.add(new TuringMachineState(4,
                new TuringMachineStateAction('1', '#', 'L', 5),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(5,
                new TuringMachineStateAction('1', '1', 'L', 6),
                new TuringMachineStateAction('-', '#', 'R', 9),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(6,
                new TuringMachineStateAction('1', '1', 'L', 6),
                new TuringMachineStateAction('-', '-', 'L', 7),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(7,
                new TuringMachineStateAction('1', '1', 'L', 8),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#', '#', 'R', 9)
        ));
        this.statesList.add(new TuringMachineState(8,
                new TuringMachineStateAction('1', '1', 'L', 8),
                new TuringMachineStateAction('-'),
                new TuringMachineStateAction('#', '#', 'R', 1)
        ));
        this.statesList.add(new TuringMachineState(9,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('-'),
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

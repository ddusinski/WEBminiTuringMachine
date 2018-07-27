package WEBminiTuringMachine;

import java.util.ArrayList;

public class TuringMachineStatesListMultiplication  implements TuringMachineStatesList {

    private ArrayList<TuringMachineState> statesList;

    public TuringMachineStatesListMultiplication() {

        this.statesList = new ArrayList<TuringMachineState>();

        this.statesList.add(new TuringMachineState(0,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#', '#', 'R', 1)
        ));

        this.statesList.add(new TuringMachineState(1,
                new TuringMachineStateAction('1', '#', 'R', 2),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#')
        ));

        this.statesList.add(new TuringMachineState(2,
                new TuringMachineStateAction('1', '1', 'R', 5),
                new TuringMachineStateAction('*', '1', 'R', 3),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(3,
                new TuringMachineStateAction('1', '1', 'R', 3),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z', '1', 'R', 3),
                new TuringMachineStateAction('#', '#', 'L', 4)
        ));
        this.statesList.add(new TuringMachineState(4,
                new TuringMachineStateAction('1', '#', 'R', 11),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(5,
                new TuringMachineStateAction('1', '1', 'R', 5),
                new TuringMachineStateAction('*', '*', 'R', 6),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(6,
                new TuringMachineStateAction('1', 'E', 'R', 7),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z', 'Z', 'L', 9),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(7,
                new TuringMachineStateAction('1', '1', 'R', 7),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z', 'Z', 'R', 7),
                new TuringMachineStateAction('#', 'Z', 'L', 8)
        ));
        this.statesList.add(new TuringMachineState(8,
                new TuringMachineStateAction('1', '1', 'L', 8),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E', 'E', 'R', 6),
                new TuringMachineStateAction('Z', 'Z', 'L', 8),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(9,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('*', '*', 'L', 10),
                new TuringMachineStateAction('E','1', 'L', 9),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#')
        ));
        this.statesList.add(new TuringMachineState(10,
                new TuringMachineStateAction('1', '1', 'L', 10),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
                new TuringMachineStateAction('#','#','R',1)
        ));
        this.statesList.add(new TuringMachineState(11,
                new TuringMachineStateAction('1'),
                new TuringMachineStateAction('*'),
                new TuringMachineStateAction('E'),
                new TuringMachineStateAction('Z'),
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

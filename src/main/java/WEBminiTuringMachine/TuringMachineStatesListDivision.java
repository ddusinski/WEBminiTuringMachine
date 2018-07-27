package WEBminiTuringMachine;

import java.util.ArrayList;

public class TuringMachineStatesListDivision implements TuringMachineStatesList{
        private ArrayList<TuringMachineState> statesList;

        public TuringMachineStatesListDivision() {

            this.statesList = new ArrayList<TuringMachineState>();

            this.statesList.add(new TuringMachineState(0,
                    new TuringMachineStateAction('1'),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#','#','R',1)
            ));
            this.statesList.add(new TuringMachineState(1,
                    new TuringMachineStateAction('1','#','R',2),
                    new TuringMachineStateAction(':','#','R',11),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(2,
                    new TuringMachineStateAction('1','1','R',3),
                    new TuringMachineStateAction(':',':','R',4),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));

            this.statesList.add(new TuringMachineState(3,
                    new TuringMachineStateAction('1','1','R',3),
                    new TuringMachineStateAction(':',':','R',4),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(4,
                    new TuringMachineStateAction('1','1','R',4),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E','E','R',4),
                    new TuringMachineStateAction('Z','Z','L',5),
                    new TuringMachineStateAction('#','#','L',5)
            ));
            this.statesList.add(new TuringMachineState(5,
                    new TuringMachineStateAction('1','E','L',6),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E','E','L',5),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(6,
                    new TuringMachineStateAction('1','1','L',9),
                    new TuringMachineStateAction(':',':','R',7),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(7,
                    new TuringMachineStateAction('1'),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E','1','R',7),
                    new TuringMachineStateAction('Z','Z','R',7),
                    new TuringMachineStateAction('#','Z','L',9)
            ));
            this.statesList.add(new TuringMachineState(8,
                    new TuringMachineStateAction('1'),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(9,
                    new TuringMachineStateAction('1','1','L',9),
                    new TuringMachineStateAction(':',':','L',10),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z','Z','L',9),
                    new TuringMachineStateAction('#')
            ));
            this.statesList.add(new TuringMachineState(10,
                    new TuringMachineStateAction('1','1','L',10),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z'),
                    new TuringMachineStateAction('#','#','R',1)
            ));
            this.statesList.add(new TuringMachineState(11,
                    new TuringMachineStateAction('1','#','R',11),
                    new TuringMachineStateAction(':'),
                    new TuringMachineStateAction('E'),
                    new TuringMachineStateAction('Z','1','R',11),
                    new TuringMachineStateAction('#','#','R',12)
            ));
            this.statesList.add(new TuringMachineState(12,
                    new TuringMachineStateAction('1'),
                    new TuringMachineStateAction(':'),
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

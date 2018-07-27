package WEBminiTuringMachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;


public class TuringMachineHead {
    private TuringMachineStatesList statesList;
    private TuringMachineTape tape;
    private TuringMachineState tempState;
    private SimpMessagingTemplate template;
    private String templateDestination;




    private static final Logger log = LoggerFactory.getLogger(TuringMachineHead.class);


    public TuringMachineHead(TuringMachineStatesList statesList, TuringMachineTape tape,SimpMessagingTemplate template, String templateDestination)  {
        this.statesList = statesList;
        this.tape = tape;
        this.template=template;
        this.templateDestination=templateDestination;
        run();
    }

    private void run() {
        setState(0);
        int operationNumber=0;

        int tempStateNumber = this.tempState.getStateNumber();

        while (tempStateNumber != this.statesList.getMaxStatesNumber()) {
            computeState();
            tempStateNumber = this.tempState.getStateNumber();
            operationNumber++;
            log.info(this.tape.getTape() + " @ " +tempStateNumber+ " @" +operationNumber);

           template.convertAndSend(this.templateDestination,this.tape.getTape() + " @ " +
                   tempStateNumber+ " @" + this.tape.getTapePosition()+" @" +operationNumber);
           try {
               Thread.sleep(1);
           }
           catch (Exception e)
           {

           }
        }
        template.convertAndSend(this.templateDestination,"Decimal result: " + this.tape.getDecimalTape());

    }

    private void setState(int stateNumber) {
        this.tempState = statesList.getState(stateNumber);
    }

    private TuringMachineStateAction getStateAction(char tapeChar) {
        return this.tempState.getStateAction(tapeChar);
    }

    private void computeState() {
        TuringMachineStateAction tempStateAction = getStateAction(this.tape.readTape());
        this.tape.writeOnTape(tempStateAction.getWriteSymbol());
        if (tempStateAction.getMoveDirection() == 'R') {
            this.tape.moveTapeNext();
        } else {
            this.tape.moveTapePrevious();
        }
        setState(tempStateAction.getNextStateNumber());
    }

}

package WEBminiTuringMachine;

import org.springframework.messaging.simp.SimpMessagingTemplate;

public class MiniTuringMachine extends Thread {


    private TuringMachineTape turingMachineTape;
    private TuringMachineStatesList statesList;
    private int firstInputNumber;
    private int secondInputNumber;
    private char machineOperation;
    private SimpMessagingTemplate template;
    private String templateDestination;
    private TuringMachineHead head;


    public MiniTuringMachine(int firstNumber, int secondNumber, char operation, SimpMessagingTemplate template) {
        this.firstInputNumber = firstNumber;
        this.secondInputNumber = secondNumber;
        this.machineOperation = operation;
        this.turingMachineTape = new TuringMachineTape();
        this.template = template;
    }

    private void calculateAddition() {
        this.turingMachineTape.createAdditionTape(this.firstInputNumber, this.secondInputNumber);
        this.statesList = new TuringMachineStatesListAddition();
        this.templateDestination = "/topic/addition";
    }

    private void calculateSubtraction() {
        this.turingMachineTape.createSubtractionTape(this.firstInputNumber, this.secondInputNumber);
        this.statesList = new TuringMachineStatesListSubtraction();
        this.templateDestination = "/topic/subtraction";
    }

    private void calculateMultiplication() {
        this.turingMachineTape.createMultiplicationTape(this.firstInputNumber, this.secondInputNumber);
        this.statesList = new TuringMachineStatesListMultiplication();
        this.templateDestination = "/topic/multiplication";

    }

    private void calculateDivision() {
        this.templateDestination = "/topic/division";
        this.turingMachineTape.createDivisionTape(this.firstInputNumber, this.secondInputNumber);
        this.statesList = new TuringMachineStatesListDivision();

    }

    public void run() {
        long startTime = System.currentTimeMillis();

        try {

            switch (this.machineOperation) {
                case '+':
                    calculateAddition();
                    break;
                case '-':
                    calculateSubtraction();
                    break;
                case '*':
                    calculateMultiplication();
                    break;
                case ':':
                    calculateDivision();
                    break;
            }

            this.head = new TuringMachineHead(this.statesList, this.turingMachineTape, this.template, this.templateDestination);

        } catch (Exception e) {

            template.convertAndSend(this.templateDestination, e.toString());
        }

        template.convertAndSend(this.templateDestination, "Operation time in ms: " + String.valueOf(System.currentTimeMillis() - startTime));

    }


}

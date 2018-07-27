package WEBminiTuringMachine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StompMessage {

    @JsonProperty("firstNumber")
    private String firstNumber;
    @JsonProperty("secondNumber")
    private String secondNumber;

    public String getFirstNumber() {
        return firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }
}

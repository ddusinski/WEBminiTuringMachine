package WEBminiTuringMachine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private static final Logger log = LoggerFactory.getLogger(MiniTuringMachine.class);

    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/getMessage")
    public void stompMessage(String inputMessage) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        StompMessage stompMessage = new StompMessage();

        try {
            stompMessage = mapper.readValue(inputMessage, StompMessage.class);
        } catch (Exception e) {
            log.info(e.toString());
        }

        log.info(stompMessage.getFirstNumber());
        log.info(stompMessage.getSecondNumber());

        int firstInputNumber = Integer.valueOf(stompMessage.getFirstNumber());
        int secondInputNumber = Integer.valueOf(stompMessage.getSecondNumber());

        MiniTuringMachine mtmA = new MiniTuringMachine(firstInputNumber, secondInputNumber, '+', this.template);
        MiniTuringMachine mtmS = new MiniTuringMachine(firstInputNumber, secondInputNumber, '-', this.template);
        MiniTuringMachine mtmM = new MiniTuringMachine(firstInputNumber, secondInputNumber, '*', this.template);
        MiniTuringMachine mtmD = new MiniTuringMachine(firstInputNumber, secondInputNumber, ':', this.template);

        mtmA.start();
        mtmS.start();
        mtmM.start();
        mtmD.start();

    }

}

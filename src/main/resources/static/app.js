var stompClient = null;



function connect() {
    var socket = new SockJS('/WEBminiTuringMachine-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        console.log('Connected' + frame);
        stompClient.subscribe('/topic/addition', function (message) {showAddition(message.body);})
        stompClient.subscribe('/topic/subtraction', function (message) {showSubtraction(message.body);})
        stompClient.subscribe('/topic/multiplication', function (message) {showMultiplication(message.body);})
        stompClient.subscribe('/topic/division', function (message) {showDivision(message.body);})
    })

}
    function showAddition(message) {
        $("#addition").append("<tr><td>"+message+"</tr></td>");
    }

    function showSubtraction(message) {
    $("#subtraction").append("<tr><td>"+message+"</tr></td>");
    }
    function showMultiplication(message) {
    $("#multiplication").append("<tr><td>"+message+"</tr></td>");
    }
    function showDivision(message) {
    $("#division").append("<tr><td>"+message+"</tr></td>");
    }

    function sendValues(){

    var inputData = {'firstNumber':$('#firstNumber').val(),'secondNumber':$('#secondNumber').val()}

    //console.log($("#firstNumber").val());
            stompClient.send("/app/getMessage", {}, JSON.stringify(inputData))
    }

    $(function () {
        $("form").on('submit',function (e)
            {
                e.preventDefault();
            }
        );


        $("#send").click(function (){

            sendValues();
        });
        $("#clear").click(function (){
            $("#additionTable tbody > tr").remove();
            $("#subtractionTable tbody > tr").remove();
            $("#divisionTable tbody > tr").remove();
            $("#multiplicationTable tbody > tr").remove();
        });
    })

$( document ).ready(function() {
    connect();
});


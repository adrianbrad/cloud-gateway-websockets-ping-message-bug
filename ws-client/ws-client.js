const WebSocket = require('ws');
var ws;

const arg = process.argv[2]
if (arg == 'gateway') {
    ws = new WebSocket("ws://localhost:8080/")
    console.log("connection to ws://localhost:8080/")
} else {
    ws = new WebSocket("ws://localhost:8090/")
    console.log("cconnection to ws://localhost:8080/")
}

ws.on('open', function open() {
    addTimestamp()
    console.log('Connection opened on: ' + ws._socket.remoteAddress + ":" +  ws._socket.remotePort)
})

ws.on('ping', function ping(data) {
    addTimestamp()
    console.log('ping received')
})

ws.on('close', function close(closeEvent) {
    addTimestamp()
    console.log(closeEvent)
    console.log('CONNECTION CLOSE')
})

ws.on('error', function error(error) {
    addTimestamp()
    console.log("ERROR")
    console.log(error)
})

function addTimestamp() {
    var dNow = new Date();
    var localdate = dNow.getHours() + ':' + dNow.getMinutes() + ":" + dNow.getSeconds();
    console.log(localdate)
}

process.stdin.setRawMode(true);
process.stdin.resume();
process.stdin.on('data', process.exit.bind(process, 0));
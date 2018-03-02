<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Demo Chat</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.0.2/socket.io.js"></script>
    <script src="/static/js/moment.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

    <script>
        // 开发
        var path = '/websocket';
        // var host = 'ws://192.168.184.80:8881';
        // var params = '?token=SOCKET-20170608102135-Q19DTElFTlQsS09VQkVJX1RFU1QsMTAwLDExNDIzOSxTSE9Q-314&userId=100&source=KOUBEI_TEST';

        // 内测
        var host = 'ws://192.168.184.11:8881';
        var params = '?token=SOCKET-20170608174404-Q19DTElFTlQsS09VQkVJX1RFU1QsMTAwLDExNDIzOSxTSE9Q-1002&userId=100&source=KOUBEI_TEST';

        var url = host + path + params;
        console.log(url);
        /*var socket = io.connect(url, {
            path: '/websocket' + params,
            transports: ['websocket']
        });
        socket.on('connect', function () {
            output('<span class="connect-msg">Client has connected to the server!</span>');
        });*/

        var socket = new WebSocket(url);
        socket.onopen = function(event) {
            alert("连接成功!");
        };

        socket.onmessage = function(event, data) {
            var res = document.getElementById('responseText');
            res.value = res.value + '\n' + event.data
        }
    </script>
</head>

<body>
    <h1>Netty-socketio Demo Chat</h1>
    <br/>
    <div id="console" class="well">
        <textarea id="responseText" style="width: 500px; height: 300px;" contenteditable="false"></textarea>
    </div>
</body>

</html>
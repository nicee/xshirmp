package psn.lotus.cloud.transport;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @project lotus
 * @time 2018/4/18 16:15
 */
public class AsyncAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

    private final AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncAcceptHandler(AsynchronousServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            result.read(buffer).get(100, TimeUnit.SECONDS);
            // 回写
//            buffer.flip();
//            result.write(buffer);
            ByteBuffer resData = responseAHtml();
            result.write(resData);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String message = new String(buffer.array());
        System.out.println("receive message length: " + message.length() + ", detail: " + message);

        try {
            result.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 继续监听下个连接
        serverSocketChannel.accept(serverSocketChannel, this);
    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
        System.out.println("fail on : " + exc.getMessage());
    }

    private ByteBuffer responseAHtml() {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        StringBuilder builder = new StringBuilder(1024);
        String html = "<!DOCTYPE html><html lang=\"zh-cn\">" +
                "<head><meta charset=\"utf-8\"/><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/></head>" +
                "<body><div>Hello World!</div></body>" +
                "</html>\r\n";

        builder.append("HTTP/1.1 200 OK\r\n").append("Server: lotus\r\n")
                .append("Date: " + LocalDateTime.now().format(sdf) + "\r\n")
                .append("Content-Type: text/html; charset=UTF-8\r\n").append("Vary: Accept-Encoding\r\n")
                .append("Connection: Keep-alive\r\n")
//                .append("Content-Length: " + html.length() + "\r\n")
                .append("Set-Cookie: Lotus_UID=C315392521E98FCFC51A1BEE98D0309D:FG=1; expires="
                        + LocalDateTime.now().plusDays(1).format(sdf) + "; max-age=31536000; path=/; domain=127.0.0.1; version=1\r\n")
//                .append("Expires: Thu, 26 Apr 2018 10:05:34 GMT\n")
//                .append("Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0\n")
                .append("Pragma: no-cache\r\n")
//                .append("Content-Encoding: gzip\r\n")
//                .append("Transfer-Encoding: chunked\r\n")
                .append("\r\n")
                .append(html);
        return ByteBuffer.wrap(builder.toString().getBytes(Charset.defaultCharset()));
    }


}

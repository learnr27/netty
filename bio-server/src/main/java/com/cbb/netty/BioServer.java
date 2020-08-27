package com.cbb.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengbb
 * @date 2020.8.19
 */
@Slf4j
public class BioServer {

    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        log.info("服务端启动啦! ");
        log.info("线程信息 =" + Thread.currentThread().getId() + "------" + Thread.currentThread().getName());
        while (true) {
            log.info("read............");
            final Socket socket = serverSocket.accept();
            log.info("连接到一个客户端");
            service.execute(new Runnable() {
                @Override
                public void run() {
                    clientHandler(socket);
                }
            });
        }

    }

    public static void clientHandler(Socket clientSocket) {
        try {
            log.info("线程信息 =" + Thread.currentThread().getId() + "------" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = clientSocket.getInputStream();
            while (true) {
                log.info("线程信息 =" + Thread.currentThread().getId() + "------" + Thread.currentThread().getName());
                log.info("clientHandler read");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    log.info("收到消息:{}", new String(bytes, 0, read));
                }else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

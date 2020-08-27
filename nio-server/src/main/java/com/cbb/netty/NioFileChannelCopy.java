package com.cbb.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chengbb
 * @date 2020.8.19
 */
@Slf4j
public class NioFileChannelCopy {

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("1.txt");
            FileChannel fileChannel01 = inputStream.getChannel();

            FileOutputStream outputStream = new FileOutputStream("2.txt");
            FileChannel fileChannel02 = outputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            while (true) {
                byteBuffer.clear();
                int read = fileChannel01.read(byteBuffer);
                if (read == 1) {
                    break;
                }
                byteBuffer.flip();
                fileChannel02.write(byteBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.cbb.netty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author chengbb
 * @date 2020.8.19
 */
public class NioFileChannelTransferFrom {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("1.png");
            FileOutputStream fileOutputStream = new FileOutputStream("2.png");
            FileChannel inChannel = fileInputStream.getChannel();
            FileChannel outChannel = fileOutputStream.getChannel();
            outChannel.transferFrom(inChannel, 0, inChannel.size());
            inChannel.close();
            outChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

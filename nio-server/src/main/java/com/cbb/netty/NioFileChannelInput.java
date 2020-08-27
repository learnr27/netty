package com.cbb.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chengbb
 * @date 2020.8.19
 */
@Slf4j
public class NioFileChannelInput {


    public static void main(String[] args) {
        try {
            File file = new File("e:\\test.txt");

            FileInputStream inputStream = new FileInputStream(file);
            //通过fileoutputstran 获取对应的filechannle
            FileChannel fileChannel = inputStream.getChannel();
            //创建一个缓冲区 bytebuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

            //将bytebuffer 数据写入到filechannel
            fileChannel.read(byteBuffer);
            log.info(":{}", new String(byteBuffer.array()));
            fileChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

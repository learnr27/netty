package com.cbb.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chengbb
 * @date 2020.8.19
 */
@Slf4j
public class NioFileChannelOutput {

    public static void main(String[] args) {
        try {
            String str = "程彬彬的netty nio 学习";
            //创建一个输出流->channel
            FileOutputStream fileOutputStream = new FileOutputStream("e:\\test.txt");
            //通过fileoutputstran 获取对应的filechannle
            FileChannel fileChannel = fileOutputStream.getChannel();
            //创建一个缓冲区 bytebuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将str放入bytebuffer
            byteBuffer.put(str.getBytes());
            //对bytebuffer 进行flip
            byteBuffer.flip();
            //将bytebuffer 数据写入到filechannel
            fileChannel.write(byteBuffer);
            fileChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

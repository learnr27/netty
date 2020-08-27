package com.cbb.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chengbb
 * @date 2020.8.21
 */
@Slf4j
public class NettyByteBuf01 {

    /**
     * 创建一个ByteBuf
     * 说明
     * 1. 创建 对象，该对象包含一个数组arr , 是一个byte[10]
     * 2. 在netty 的buffer中，不需要使用flip 进行反转底层维护了 readerindex 和 writerIndex
     * 3. 通过 readerindex 和  writerIndex 和  capacity， 将buffer分成三个区域
     * 0--->readerindex             已经读取的区域
     * readerindex--->writerIndex   可读的区域
     * writerIndex--->capacity      可写的区域
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            ByteBuf buffer = Unpooled.buffer(10);
            for (int i = 0; i < 10; i++) {
                buffer.writeByte(i);
            }
            log.info("buffer.capacity():{}", buffer.capacity());
            for (int i = 0; i < buffer.capacity(); i++) {
                log.info("getByte:{}", buffer.getByte(i));
            }

            //readerIndex ++
            for (int i = 0; i < buffer.capacity(); i++) {
                log.info("readByte:{}", buffer.readByte());
            }
            log.info("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

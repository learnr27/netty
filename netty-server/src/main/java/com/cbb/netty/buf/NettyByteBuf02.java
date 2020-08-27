package com.cbb.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author chengbb
 * @date 2020.8.21
 */
@Slf4j
public class NettyByteBuf02 {

    public static void main(String[] args) {
        //创建ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world!@#程彬彬", Charset.forName("UTF-8"));
        //使用相关的方法
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();

            log.info("content:{}", new String(content, Charset.forName("utf-8")));
            log.info("content:{}", content);
            log.info("byteBuf:{}", byteBuf);

            log.info("byteBuf arrayOffset:{}", byteBuf.arrayOffset());
            log.info("byteBuf readerIndex:{}", byteBuf.readerIndex());
            log.info("byteBuf writerIndex:{}", byteBuf.writerIndex());
            log.info("byteBuf capacity:{}", byteBuf.capacity());
            log.info("byteBuf getByte(0):{}", byteBuf.getByte(0));
            log.info("byteBuf readableBytes:{}", byteBuf.readableBytes());
            log.info("byteBuf readByte:{}", byteBuf.readByte());

            for (int i = 0; i < byteBuf.readableBytes(); i++) {
                log.info("char:{}",(char)byteBuf.getByte(i) );
            }


            log.info("byteBuf getCharSequence:{}", byteBuf.getCharSequence(0,6,Charset.forName("utf-8")));

            log.info("byteBuf getCharSequence:{}", byteBuf.getCharSequence(4,6,Charset.forName("utf-8")));
        }
    }
}

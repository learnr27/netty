package com.cbb.netty;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author chengbb
 * @date 2020.8.19
 */
@Slf4j
public class BasicBuffer {

    public static void main(String[] args) {

        //初始化 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        log.info("origin -> capacity = " + byteBuffer.capacity());
        log.info("origin -> limit = " + byteBuffer.limit());
        log.info("origin -> position = " + byteBuffer.position());
        log.info("origin -> mark = " + byteBuffer.mark());

        //执行put()，写入数据
        String name = "Hibernate Pano";
        byteBuffer.put(name.getBytes());
        log.info("put -> capacity = " + byteBuffer.capacity());
        log.info("put -> limit = " + byteBuffer.limit());
        log.info("put -> position = " + byteBuffer.position());
        log.info("put -> mark = " + byteBuffer.mark());

        //执行filp()，转换成读模式
        byteBuffer.flip();
        log.info("flip -> capacity = " + byteBuffer.capacity());
        log.info("flip -> limit = " + byteBuffer.limit());
        log.info("flip -> position = " + byteBuffer.position());
        log.info("flip -> mark = " + byteBuffer.mark());

        //设置limit长度的数据，读取数据
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        log.info("get -> String = " + new String(bytes));

        log.info("get -> capacity = " + byteBuffer.capacity());
        log.info("get -> limit = " + byteBuffer.limit());
        log.info("get -> position = " + byteBuffer.position());
        log.info("get -> mark = " + byteBuffer.mark());

        //清空缓冲区，转换成写模式 ---> 数据没有真正被清空，只是被遗忘掉了
        byteBuffer.clear();
        log.info("clear -> capacity = " + byteBuffer.capacity());
        log.info("clear -> limit = " + byteBuffer.limit());
        log.info("clear -> position = " + byteBuffer.position());
        log.info("clear -> mark = " + byteBuffer.mark());


    }

    public void test() {

        //创建一个buffer 大小为5 校验存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            //向buffer 存放数据
            intBuffer.put(i * 2);
        }
        //将buffer转换 读写切换
        intBuffer.flip();

        //读取buffer
        while (intBuffer.hasRemaining()) {
            log.info("intBuffer:{}", intBuffer.get());
        }
    }
}

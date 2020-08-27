package com.cbb.netty.simple;

import io.netty.util.NettyRuntime;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chengbb
 * @date 2020.8.21
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        log.info("NettyRuntime.availableProcessors():{}", NettyRuntime.availableProcessors());
    }
}

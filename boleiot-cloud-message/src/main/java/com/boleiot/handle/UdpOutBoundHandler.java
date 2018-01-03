package com.boleiot.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UdpOutBoundHandler extends ChannelOutboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(UdpOutBoundHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        if (msg instanceof byte[]) {
            byte[] bytesWrite = (byte[]) msg;
            ByteBuf buf = ctx.alloc().buffer(bytesWrite.length);
            //logger.info("向设备下发的信息为：" + TCPServerNetty.bytesToHexString(bytesWrite));

            buf.writeBytes(bytesWrite);
            ctx.writeAndFlush(buf).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future)
                        throws Exception {
                    logger.info("下发成功！");
                }
            });
        }
    }
}

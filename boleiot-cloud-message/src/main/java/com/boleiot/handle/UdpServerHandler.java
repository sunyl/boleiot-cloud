package com.boleiot.handle;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;


public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger log = LoggerFactory.getLogger(UdpServerHandler.class);

    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String receiveMsg = packet.content().toString(CharsetUtil.UTF_8);
        log.info("Received UDP Msg:" + receiveMsg);

        if (StringUtils.isNotEmpty(receiveMsg)) {
            ctx.write(new DatagramPacket(Unpooled.copiedBuffer("QOTM: Got UDP Message!", CharsetUtil.UTF_8), packet.sender()));
        } else {
            log.error("Received Error UDP Messsage:" + receiveMsg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
    }

    public Timestamp getTime() {
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        return time;
    }

}
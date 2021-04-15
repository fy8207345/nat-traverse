package org.nat.common.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleInboundToOutboundHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private final ChannelHandlerContext channelOut;

    public SimpleInboundToOutboundHandler(ChannelHandlerContext channelOut) {
        this.channelOut = channelOut;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if(log.isTraceEnabled()){
            StringBuilder stringBuilder = new StringBuilder();
            ByteBufUtil.appendPrettyHexDump(stringBuilder, byteBuf);
            log.trace("transfer inbound: {} to outbound: {} \n {}", channelHandlerContext, channelOut, stringBuilder.toString());
        }
        channelOut.writeAndFlush(byteBuf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        channelOut.close();
    }
}

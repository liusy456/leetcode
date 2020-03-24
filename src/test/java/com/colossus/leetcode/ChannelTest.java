package com.colossus.leetcode;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author Tlsy1
 * @since 2019-03-14 15:33
 **/
public class ChannelTest {

    @Test
    public void channelTest() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\Tlsy1\\Desktop\\ebay测试账号.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        try {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer  = CharBuffer.allocate(1024);
            Charset charset = Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            int read = fileChannel.read(byteBuffer);
            while (read!=-1){
                byteBuffer.flip();
                decoder.decode(byteBuffer,charBuffer,false);
                charBuffer.flip();
                while (charBuffer.hasRemaining()){
                    System.out.print(charBuffer.get());
                }

                byteBuffer.clear();
                charBuffer.clear();
                read = fileChannel.read(byteBuffer);
            }
        }finally {
            accessFile.close();
            fileChannel.close();
        }
    }
}

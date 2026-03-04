package com.cxz.TCP1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os); //包装成特殊数据流
        dos.writeUTF("hello,我是客户端");
        dos.writeInt(100);
        socket.close();
    }
}

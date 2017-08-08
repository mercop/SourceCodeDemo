package com.marving.code.java.concurrent.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mercop on 2017/8/3.
 */

public class SimpleHttpSever {

    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();

    static int port = 8080;

    public static void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    public static void main(String[] args) throws IOException {
        SimpleHttpSever.start();
    }
}

class HttpRequestHandler implements Runnable {

    private Socket socket;

    private String basePath = "d:\\";

    public HttpRequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String header = reader.readLine();
            String filePath = basePath + header.split(" ")[1];
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            if (filePath.endsWith("jpg")) {
                InputStream in = new FileInputStream(filePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int i = 0;
                while ((i = in.read()) != 1) {
                    baos.write(i);
                }
                byte[] array = baos.toByteArray();

                out.println("HTTP/1.1 200 OK");
                out.println("Server: Molly");
                out.println("Content-Type: image/jpeg");
                out.println("");
                socket.getOutputStream().write(array, 0, array.length);

            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

                out.println("HTTP/1.1 200 OK");
                out.println("Server: Molly");
                out.println("Content-Type: text/html;charset=UTF-8");
                out.println("");
                String line = null;
                while ((line = br.readLine()) != null) {
                    out.println(line);
                }
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

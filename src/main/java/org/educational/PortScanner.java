package org.educational;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PortScanner {

    public int[] ports = {22, 2222, 80, 8080, 8081, 20, 25, 53};


    public PortScanner(String ip) {
        ConcurrentLinkedQueue openPorts = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(ports.length);
        AtomicInteger port = new AtomicInteger(0);
        for (int i = 0; i <= ports.length; i++) {
            final int targetPort = port.getAndIncrement();
            executorService.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, targetPort), 200);
                    socket.close();
                    openPorts.add(targetPort);
                    System.out.println(ip + " ,port open: " + targetPort);
                } catch (IOException e) {
                    System.err.println(e);
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List openPortList = new ArrayList<>();
        System.out.println("Open ports: " + openPorts.size());
        while (!openPorts.isEmpty()) {
            openPortList.add(openPorts.poll());
        }
        openPortList.forEach(p -> System.out.println("port " + p + " is open"));
    }
}
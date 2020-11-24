package chatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * @author ME
 * @creat 2020/11/21
 */
public class Send implements Runnable {

    private int sendPort;

    public Send(int sendPort) {
        this.sendPort = sendPort;
    }

    @Override
    public synchronized void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), 0, s.getBytes().length, InetAddress.getByName("me"), sendPort);
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

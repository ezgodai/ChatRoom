package chatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * @author ME
 * @creat 2020/11/21
 */
public class Recevie implements Runnable {
    private int receivePort;

    public Recevie(int receivePort) {
        this.receivePort = receivePort;
    }

    @Override
    public synchronized void run() {

        try {
            DatagramSocket datagramSocket = new DatagramSocket(receivePort);

            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            while (true) {
                datagramSocket.receive(datagramPacket);
                System.out.println(new String(bytes, 0, bytes.length));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

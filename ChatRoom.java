package chatRoom;

import java.util.Scanner;

/*
 * @author ME
 * @creat 2020/11/21
 */
public class ChatRoom {
    public static void main(String[] args) {
        System.out.println("欢迎进入聊天室！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入本程序发送端端口号：");
        int sendPort = scanner.nextInt();
        System.out.println("请输入本程序接收端端口号：");
        int receivePort = scanner.nextInt();
        System.out.println("聊天室启动");
        new Thread(new Send(sendPort), "发送端").start();
        new Thread(new Recevie(receivePort), "接收端").start();
    }
}

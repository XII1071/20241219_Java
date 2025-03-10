package p12network;

import java.net.*;
import java.io.*;
import java.util.*;

public class Ex01TcpipMultiChatServer {
  public static void main(String args[]) {
    new Ex01TcpipMultiChatServer().start();
  }

  HashMap clients;

  Ex01TcpipMultiChatServer() {
    clients = new HashMap();
    Collections.synchronizedMap(clients);
  }

  public void start() {
    ServerSocket serverSocket = null;
    Socket socket = null;

    try {
      serverSocket = new ServerSocket(7777);
      System.out.println("Server started...");

      while (true) {
        // 누군가 접속을 하게 되면 socket을 생성하고
        socket = serverSocket.accept();
        System.out.println("Connected from ["
            + socket.getInetAddress() + ":" + socket.getPort() + "]");
        // 사용자당 각각의 thread를 생성
        ServerReceiver thread = new ServerReceiver(socket);
        thread.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // start()

  // 메세지를 모두에게 보내줄 때 호출
  void sendToAll(String msg) {
    Iterator it = clients.keySet().iterator();

    while (it.hasNext()) {
      try {
        DataOutputStream out = (DataOutputStream) clients.get(it.next());
        out.writeUTF(msg);
      } catch (IOException e) {
      }
    } // while
  } // sendToAll


  class ServerReceiver extends Thread {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    ServerReceiver(Socket socket) {
      this.socket = socket;
      try {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
      }
    }

    public void run() {
      String name = "";
      try {
        // 처음 입장하면 in으로 처음 받는 메시지가 이름임.
        name = in.readUTF();
        sendToAll("#" + name + " 님이 입장하셨습니다.");

        clients.put(name, out);
        System.out.println("현재 접속자수: " + clients.size());
        // 사용자가 계속적으로 메시지를 보낼 수 있기에 보낼 때 모두에게 전송
        while (in != null) {
          sendToAll(in.readUTF());
        }
      } catch (IOException e) {
        // ignore
      } finally {
        sendToAll("#" + name + " 님이 나가셨습니다.");
        clients.remove(name);
        System.out.println("Terminated from [" + socket.getInetAddress() + ":" + socket.getPort() + "]");
        System.out.println("현재 접속자수: " + clients.size());
      } // try
    } // run
  } // ReceiverThread
} // class
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer{
	static ServerSocket sSocket;
	static Socket socket;
	static DataInputStream dataIn;
	static DataOutputStream dataOut;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Who are you?");
		String name = sc.next();
		
		try{
			System.out.println("Please Wait untill you get connected...");
			sSocket = new ServerSocket(12596);
			socket = sSocket.accept();
			if(socket.isConnected()){
				System.out.println("Connected Successfully!!! Please wait for message...");
			}
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream(socket.getOutputStream());
			String msg = "";
			while(!msg.equals("exit")){
				
				msg = dataIn.readUTF();
				System.out.println(msg);
				msg = sc.nextLine();
				msg = name+": "+msg;
				dataOut.writeUTF(msg);
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

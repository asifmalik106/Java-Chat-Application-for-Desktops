import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient{
	static Socket socket;
	static DataInputStream dataIn;
	static DataOutputStream dataOut;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Who are you?");
		String name = sc.next();
		
		try{
			System.out.println("Enter Destination IP:");
			sc.nextLine();
			String ip = sc.nextLine();
			socket = new Socket(ip, 12596);
			if(socket.isConnected()){
				System.out.println("Connected Successfully!!! Please enter a message to proceed...");
			}
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream(socket.getOutputStream());
			String msg = "";
			dataOut.writeUTF(name+": "+sc.nextLine());
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

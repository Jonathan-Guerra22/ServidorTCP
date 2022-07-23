package ServidorTCP;
import java.net.*;
import java.io.*;

public class ServidorTCP {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(5000); 
		
		String msg = "Cliente, se comunica el servidor Java\n";
		
		byte [] datos = new byte [256];
		System.out.println("Iniciando el servidor");
		
		while(true) {
			
			System.out.println("Esperando clientes... \n");
			
			Socket socket = server.accept();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			dis.read(datos,0,datos.length);
			System.out.println("Se detecto un cliente, el cliente dice: " + new String(datos));
			System.out.println("Enviando el mensaje de respuesta: "+msg+"...");
			dos.write(msg.getBytes(),0,msg.length());
			
			dis.close();
			dos.close();
			socket.close();
		}

	}

}

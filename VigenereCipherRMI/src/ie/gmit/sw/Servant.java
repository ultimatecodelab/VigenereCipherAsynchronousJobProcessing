package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
//Runner class
public class Servant {
	public static void main(String[] args) throws Exception {
		
		//starting the rmi service
		try{
		LocateRegistry.createRegistry(1099);
		//System.setProperty("java.rmi.server.hostname","192.168.1.2");
		Naming.bind("cypher-service", new VigenereBreakerImpl());
		System.out.println("service started...");
		}
		catch(Exception e){
			System.out.println("Looks like the port is in use already...");
		}
		
	}
}

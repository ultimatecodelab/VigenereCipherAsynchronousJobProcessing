package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
//Runner class
public class Servant {
	public static void main(String[] args) throws Exception {
		System.out.println("starting remote service");
		
		LocateRegistry.createRegistry(1099);
		
		Naming.bind("cypher-service", new VigenereBreakerImpl());
		
		System.out.println("service started...");
		
		
	}
}

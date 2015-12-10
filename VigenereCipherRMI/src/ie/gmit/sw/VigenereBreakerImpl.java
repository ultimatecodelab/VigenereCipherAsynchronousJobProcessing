package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//implementation of a VigenereBreaker interface.
public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker {

	private static final long serialVersionUID = 1L;
	private KeyEnumerator breaker;
	
	public VigenereBreakerImpl() throws Exception {
		breaker = new KeyEnumerator();
	}
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException {
		System.out.println("Decrypting............");
		return breaker.crackCypher(cypherText, maxKeyLength);
	}

	
	
}

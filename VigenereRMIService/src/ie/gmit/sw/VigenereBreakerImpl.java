package ie.gmit.sw;

import java.rmi.server.UnicastRemoteObject;

//implementation of a VigenereBreaker interface.
public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker {

	private static final long serialVersionUID = 1L;
	
	public VigenereBreakerImpl() throws Exception {
		
	}
	public String decrypt(String cypherText, int maxKeyLength) throws Exception {
		
		System.out.println("Deciphering..." );
		/*We must create a new instance of KeyEnumerator for every job that was submitted, or else it 
		will cause conflict with the BESTKEY, and the reason is, if we instantiate in the class level,
		there will be only one instance created and it will assume the first BESTKEY a best key for 
		every other new request.*/
		KeyEnumerator breaker = new KeyEnumerator() ;
		return breaker.crackCypher(cypherText, maxKeyLength);
		
	}

	
	
}

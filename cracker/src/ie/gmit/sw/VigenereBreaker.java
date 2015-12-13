package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
/*A remote interface for communicating with the rmi service
 * The RMI vigenere cracking  is created as a seperate project and we are communicatig via this interface in 
 * the server side (tomcat)
 */
public interface VigenereBreaker extends Remote{
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException;
}

package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VigenereBreaker extends Remote{
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException;
}

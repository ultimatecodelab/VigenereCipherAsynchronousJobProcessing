﻿##Developer : Arjun Kharel (G00298984) - Async Vigenere Cipher Breaker
﻿![Alt text](https://github.com/ultimatecodelab/VigenereCipherAsynchronousJobProcessing/blob/master/img.PNG "Optional title")

**Clone:https://github.com/ultimatecodelab/VigenereCipherAsynchronousJobProcessing.git**

**Source Code -  https://github.com/ultimatecodelab/VigenereCipherAsynchronousJobProcessing (VigenereRMIService AND cracker )folder.**

G00298984 (Zip archive contains the following)
- cracker.war
- vigenere.jar
- ReadMe.txt


**INSTRUCTIONS**

Starting the RMI service
1: Open command prompt and cd into G00298984 folder.

2: Please make sure the "Quadgrams.txt" and "vigenere.jar" are on the same folder.

3:Start the RMI service by the command provided below (windows)
	
	Running on linux java -cp "./vigenere.jar:lib/*" ie.gmit.sw.Servant

	java –cp ./vigenere.jar ie.gmit.sw.Servant

			or

	java -cp "./vigenere.jar;lib/*" ie.gmit.sw.Servant (Windows)

4: Copy the cracker.war to **webapps** folder and start the apache tomcat server

5: open your browser and go to **http://localhost:8080/cracker/**

**Features** 

The project is fully functional and is comprises of the following features / Technologies

1: Asynchronous - Extra features : **MultiThreaded (AsyncContext, ExecutorService , CachedThreadPool)** 

2: RMI and Tomcat is completely isolated(two different project) and Tomcat (webapp) uses an interface to communicate to RMI service remotely.

3: Messages Queues / Maps fully implemented.

3: OOP techniques applied. 

4: Decipher the ciphered text with very high accuracy.

**Sample english paragraph first enciphered with the key JAVA**

The running key variant of the Vigenère cipher was also considered 
unbreakable at one time. This version uses as the key a block of text
 as long as the plaintext. The problem with the running key Vigenère cipher
 is that the cryptanalyst has statistical information about the key (assuming 
that the block of text is in a known language) and that information will be reflected in the ciphertext.

**When you cipher the above plane text with the key JAVA you get this.**

CHZRDNIIWGFEHVVRRAITXFOHNVDGNNMELIKHNRRABAGSXCJNBIYEAEYUWBMEJKVBUEVTXNZTRMZTQINVNRNIXNPSNSVSCHZKNYVBUOXKX
FOEGTVSUOIGJSOHNPGARNOEGTOHNPMOKLZMFIOHCHZRDNIIWGFEHVDGNNMELIKHNRDSCHVTCHZ


**Now lets crack the cipher text by using the KEY LENGTH (4) - Bruit force attack. (Successfully returned the original key, 100% cracked)**

THERUNNINGKEYVARIANTOFTHEVIGENRECIPHERWASALSOCONSIDEREDUNBREAKABLEATONETIMETHISVERSIONUSESASTHEKEYABLOCKOF
TEXTASLONGASTHEPLAINTEXTTHEPROBLEMWITHTHERUNNINGKEYVIGENRECIPHERISTHATTHE

**It it recommended to use the key of (length 4) when enciphering the text. It is bit quicker compare to the key length of 5.**

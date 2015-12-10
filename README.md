# Vigenere Cipher Asynchronous Job Processing  - Arjun Kharel - G00298984

College:Galway-Mayo Institute of Technology

Module : Distributed Systems

##Project Description
Vigenere Breaker  - Asynchronous message processing (Java / JSP)
INSTRUCTIONS

**Starting the RMI service**
1: Open command prompt and cd into G00298984 folder.

2: Please make sure the **"Quadgrams.txt" and "vigenere.jar" are on the same folder**.

3:Start the RMI service by the command provided below (windows)

	**java -cp "./vigenere.jar;lib/*" ie.gmit.sw.Servant** 
	
4: Copy the cracker.war to webapps folder and start the apache server

5: open your browser and go to http://localhost:8080/cracker/

##Features: 
The project is fully functional and is composed of the following features / Technologies:

1: Asynchronous - MultiThreaded (AsyncContext, ExecutorService , CachedThreadPool) 

2: RMI and Tomcat is completely isolated(two different project) and Tomcat (webapp) uses an interface to communicate to RMI service remotely.

3: Messages Queues / Maps fully implemented.

3: OOp techniques used for development. 

4: Decipher the cipher text with very high efficiency.

Sample english paragraph first enciphered with the key **JAVA**

Hundreds of Syrians, including rebel fighters, have left the last rebel-held area 
of Homs as part of a rare local ceasefire deal negotiated between the opposition 
and the government.The fighters and their families were being moved to rebel-held 
areas of the northwest near the Turkish border on Wednesday.

**When you decipher the above plane text with the key JAVA you get this.**

QUIDAEYSXFNYAIVNBIICUUYIWGMEKEGFRGCTNRNHJVZLNFOTQEGABTMEKEGHNLYAAEVOOHJMBANPJROOOA
MAAEGOLAGCNANEOIMEMEVLWEBOCIVTNDWECWZEWTCEXPKOBIOIXNVNMTCEPOQEANHEWTOHNFDGQTZRBAIDCH
ZIAFVMRLDEBWZRNBZIWGHOEEYTXRZBNLCEUDVRNANOOTCEWOMTQWZSCNZAATCECUMKRSCBXRYEAOIWNDIEBDVY

**Now lets crack the cipher text by using the KEY LENGTH (4) - Bruit force attack.**
HUNDREDSOFSYRIANSINCLUDINGREBELFIGHTERSHAVELEFTTHELASTREBELHELDAREAOFHOMSASPARTOFARARE
LOCALCEASEFIREDEALNEGOTIATEDBETWEENTHEOPPOSITIONANDTHEGOVERNMENTTHEFIGHTERSANDTHEIR
FAMILIESWEREBEINGMOVEDTOREBELHELDAREASOFTHENORTHWESTNEARTHETURKISHBORDERONWEDNESDAY




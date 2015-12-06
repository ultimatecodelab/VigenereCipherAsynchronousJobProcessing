package ie.gmit.sw.rmi;

import java.util.*;
import java.io.*;

public class QuadgramMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public QuadgramMap(String filename) throws Exception {
		parse(filename);
	}
	
	
	public float getScore(String text){
		float score = 0.00f;
		for (int i = 0; i < text.length(); i+=4) {
			
			if (i + 4 >= text.length()) break;
			String next = text.substring(i, i+4);
			
			if(map.containsKey(next)){	
				if (map.get(next) != null){
						float frequency = (float)map.get(next);
						float total = (float) map.size();
						//score += Math.log10((frequency/total));	
						//score += (frequency/total);
						
						score+=map.get(next)/1000;
					}
				}
			}
	
		return score;
	}

	
	private void parse(String filename) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();
		String str = null;
		
		int j;
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z'){
				sb.append(next);
				str = sb.toString();
			}
			else{
				if(next!= '\n'){
					sb2.append(next);
				}
				
			}
			
			if(sb.length() == 4){
				
				String qGram = sb.toString().toUpperCase();
				str = qGram;
				sb = new StringBuffer();
				int frequency = 0;
				frequency++;
			////	System.out.println("Word: "+ qGram + " Freq: " + frequency);
				//.put(qGram, 0);
				map.put(qGram,0);
					
			}
			if(next== '\n')
			{
				//System.out.println("Word: "+ str +" freq "+sb2.toString());
				map.put(str, Integer.parseInt(sb2.toString().trim()));
				sb2.setLength(0);
			}
		}
		br.close();
		//Testing random key from the map...
		System.out.println("Size of Map" +map.size());
		System.out.println("AIQF: " +map.get("AIQF"));
		System.out.println("TEST: " +map.get("TEST"));
		System.out.println("SAZZ: " +map.get("SAZZ"));
		System.out.println("JAVA: " +map.get("JAVA"));
		System.out.println("TION: " + map.get("TION"));
		//Testing finished..
	}

	
	public static void main(String[] args) throws Exception {
		//new QuadgramMap("Quadgrams.txt");
	}
}

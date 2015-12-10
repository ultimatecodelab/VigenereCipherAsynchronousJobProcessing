package ie.gmit.sw;
import java.util.*;
import java.io.*;

public class QuadgramMap {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	private static final int DIVIDING_FACTOR = 1000;
	private static final int QUAD_LENGTH = 4;

	public QuadgramMap(String filename) throws Exception {
		parse(filename);
	}
	//get score returns the score - englishy looking text
	public float getScore(String text){
		float score = 0.00f;
		for (int i = 0; i < text.length(); i+=4) {
			
			if (i + 4 >= text.length()) break;
			String next = text.substring(i, i+4);
			
			if(map.containsKey(next)){	
				if (map.get(next) != null){
						float frequency = map.get(next);
						score+=frequency/DIVIDING_FACTOR;
					}
				}
		}
		return score;
	}
	//parsing the file
	private void parse(String filename) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer key = new StringBuffer();
		StringBuilder value = new StringBuilder();
		String str = null;
		
		int j;
		while((j = br.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z'){
				key.append(next);
				str = key.toString();
			}
			else{
				if(next!= '\n'){
					value.append(next);
				}
			}
			
			if(key.length() == QUAD_LENGTH){
				String qGram = key.toString().toUpperCase();
				str = qGram;
				key = new StringBuffer();
				map.put(qGram,0);
					
			}
			if(next== '\n'){
				map.put(str, Integer.parseInt(value.toString().trim()));
				value.setLength(0);
			}
		}
		br.close();
		System.out.println("Size of Map: " +map.size());
		//Testing finished..
	}
}

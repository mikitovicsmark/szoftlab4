package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapReader {
	
	public void loadMap(int level){
		
		String levelPath = "";
		
		switch(level){
			case 0:
				levelPath = "/testmap";
				break;
		}
		
		InputStream is = this.getClass().getResourceAsStream(levelPath);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

	public List<String> loadMap(int level) {

		String levelPath = "";

		switch (level) {
		case 0:
			levelPath = "/level10";
			break;
		case 13:
			levelPath = "/testmap13";
			break;
		case 10:
			levelPath = "/Test10";
			break;
		case 11:
			levelPath = "/Test11";
			break;
		case 12:
			levelPath = "/Test12";
			break;
		}

		InputStream is = this.getClass().getResourceAsStream(levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		List<String> lines = new ArrayList<String>();
		String line;

		try {
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

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
		//cases for test maps
		case 0:
			levelPath = "/testmap";
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
		//cases for the gaming maps, it begins with from 20 to avoid the conflict with the test maps.
		case 21:
			levelPath = "/level1";
			break;
		case 22:
			levelPath = "/level2";
			break;
		case 23:
			levelPath = "/level3";
			break;
		case 24:
			levelPath = "/level4";
			break;
		case 25:
			levelPath = "/level5";
			break;
		case 26:
			levelPath = "/level6";
			break;
		case 27:
			levelPath = "/level7";
			break;
		case 28:
			levelPath = "/level8";
			break;
		case 29:
			levelPath = "/level9";
			break;
		case 30:
			levelPath = "/level10";
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

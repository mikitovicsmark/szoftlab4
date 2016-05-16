package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.util.Scanner;

import javax.swing.JFrame;

import enums.Color;
import enums.Direction;
import gameElements.NormalFloor;

public class Game {
	
	public static void main(String[] args) {
		
		GameField gameField = new GameField();
		//gameField.Initialize(0);
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		Menu mymenu = new Menu();
		
		//creating the panel holder frame
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLayout(new BorderLayout());
		GamePanel gamePanel = null;
		gamePanel = new GamePanel();
		
		//showing the menu
		frame.add(mymenu,BorderLayout.CENTER);
		frame.pack();
		frame.addKeyListener(mymenu);
		frame.setFocusable(true);
		frame.setVisible(true);
		while(mymenu.needmenu){
			mymenu.repaint();
		}
		//initializing the selected map
		gameField.Initialize(mymenu.getSelectedMap()+20);
		
		//removing the menu panel
		frame.setVisible(false);
		frame.setFocusable(false);
		frame.removeKeyListener(mymenu);
		frame.remove(mymenu);
		
		
		//showing the game panel
		frame.add(gamePanel, BorderLayout.CENTER);
		frame.pack();
	    frame.addKeyListener(gamePanel);
	    frame.setFocusable(true);
	    frame.setVisible(true);
		
		//random move of Replicator
		gameField.getReplicator().randomMove();	
		while (!exit) {
			if (gamePanel !=null) {
				gamePanel.setGameField(gameField);
				gamePanel.repaint();
			}
		}
		
		scanner.close();

	}

}

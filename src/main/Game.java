package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;

import enums.Color;
import enums.Direction;
import gameElements.NormalFloor;

public class Game {
	
	public static void main(String[] args) {
		
		GameField gameField = new GameField();
		gameField.Initialize(0);
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		Menu mymenu = new Menu();
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLayout(new BorderLayout());
		GamePanel gamePanel = null;
		gamePanel = new GamePanel();
		/*
		frame.add(mymenu,BorderLayout.CENTER);
		frame.pack();
		frame.addKeyListener(mymenu);
		frame.setFocusable(true);
		frame.setVisible(true);
		while(!exit){
			mymenu.repaint();
		}*/
		
		
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

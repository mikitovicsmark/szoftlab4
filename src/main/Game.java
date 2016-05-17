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
import main.GameField;

public class Game {
	public static boolean exit;
	private static JFrame frame;
	private static Menu mymenu;
	private static Scanner scanner;
	private static GamePanel gamePanel;
	private static GameField gameField;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		gameField = new GameField();
		exit = false;
		mymenu = new Menu();

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLayout(new BorderLayout());
		gamePanel = null;
		gamePanel = new GamePanel();
		showMenu();
		scanner.close();
	}

	public static void showMenu() {
		frame.add(mymenu, BorderLayout.CENTER);
		frame.pack();
		frame.addKeyListener(mymenu);
		frame.setFocusable(true);
		frame.setVisible(true);
		while (mymenu.needmenu) {
			mymenu.repaint();
		}
		startGame();
	}

	public static void removeMenu() {
		frame.setVisible(false);
		frame.setFocusable(false);
		frame.removeKeyListener(mymenu);
		frame.remove(mymenu);
	}

	public static void removeGame() {
		frame.setVisible(false);
		frame.setFocusable(false);
		frame.removeKeyListener(gamePanel);
		frame.remove(gamePanel);
	}

	public static void startGame() {

		gameField.Initialize(mymenu.getSelectedMap() + 20);
		removeMenu();
		frame.add(gamePanel, BorderLayout.CENTER);
		frame.pack();
		frame.addKeyListener(gamePanel);
		frame.setFocusable(true);
		frame.setVisible(true);

		// random move of Replicator
		gameField.getReplicator().randomMove();
		while (!exit) {
			if (gamePanel != null) {
				gamePanel.setGameField(gameField);
				gamePanel.repaint();
			}
		}

		mymenu.needmenu = true;
		exit=false;
		removeGame();
		showMenu();
	}

}

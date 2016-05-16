package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Menu extends JPanel implements KeyListener {
	private Image background,selectframe;
	
	//static paramters for drawing the menu
	private static final int xgap = 41; //distance between the map logos
	private static final int ygap = 125; //distance between the map logos
	private static final int xoffset = 242; // offset where to begin the frame
	private static final int yoffset = 135; // offset where to begin the frame
	
	private int selectedmap = 1;//selected map's number
	
	public Menu(){
		try{
			this.background = ImageIO.read(new File("src/images/background_level_select.png"));
			this.selectframe	= ImageIO.read(new File("src/images/selectframe.png"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		g.drawImage(background, 0, 0, 800, 800,null);//drawing the background
		g.setColor(Color.CYAN);
		g.drawString("If you like our game please support us.", 75, 75);
			if (selectedmap < 6){//drawing image to the first row in the menu
				g.drawImage(selectframe, (selectedmap * xgap) + xoffset, yoffset, null);
			}
			if (selectedmap > 5){//drawing image to the second row in the menu
				g.drawImage(selectframe, ((selectedmap-5) * xgap) + xoffset , yoffset + ygap, null);
			}
			
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (selectedmap < 6){ //valid for the first row of the menu
			switch(e.getKeyChar()){
			case 'w' ://jump to the second row
				selectedmap += 5;
				break;
				
			case 's' ://jump to the second row
				selectedmap += 5;
				break;
				
			case 'a' :
				if(selectedmap == 1){
					selectedmap = 10;
				}else{
					selectedmap -=1;
				}				
				break;
				
			case 'd' :
				selectedmap +=1;
				break;
			}
			return;
		}
		if (selectedmap > 5){ //valid for the second row of the menu
			switch(e.getKeyChar()){
			case 'w' ://jump to the first row
				selectedmap -= 5;
				break;
			case 's' ://jump to the first row
				selectedmap -= 5;
				break;
			case 'a' :
				selectedmap -= 1;
				break;
			case 'd' :
				if (selectedmap == 10){
					selectedmap = 1;
				}
				else{selectedmap += 1;}
				break;
			}
			return;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public int getSelectedMap(){return selectedmap;}

}

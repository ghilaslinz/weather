package com.parlonscode.weatho;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Mainframe mainframe = new Mainframe("weatho");
				mainframe.setResizable(false);
				mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainframe.pack(); //The pack method sizes the frame so that all its contents are at or above their preferred sizes. An alternative to pack is to establish a frame size explicitly by calling setSize or setBounds (which also sets the frame location). In general, using pack is preferable to calling setSize, since pack leaves the frame layout manager in charge of the frame size, and layout managers are good at adjusting to platform dependencies and other factors that affect component size.
				//mainframe.setLocationRelativeTo(null); // centrer la fenétre
				mainframe.setVisible(true);
				
			}
		});
		

	}

}

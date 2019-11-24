package com.parlonscode.weatho.utilities;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Alert {
public static void error(Component parentComponent, String titre, String message) {
	JOptionPane.showMessageDialog(parentComponent, message, titre, JOptionPane.ERROR_MESSAGE);
	
}

public static void error(Component parentComponent, String message) {
	error(parentComponent, "Erreur", message);	
}

public static void info(Component parentComponent, String titre, String message) {
	JOptionPane.showMessageDialog(parentComponent, message, titre, JOptionPane.INFORMATION_MESSAGE);
}

public static void info(Component parentComponent, String message) {
	error(parentComponent, "Information", message);	
}
}

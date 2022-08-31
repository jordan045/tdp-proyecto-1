package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {           
            	try {
            		Student alumno = new Student(131338, "Carranza Benítez", "Jordan David", "jordancarranza045@gmail.com", "https://github.com/jordan045", "./images/tdp.png");
            		SimplePresentationScreen GUI = new SimplePresentationScreen(alumno);
        			GUI.setVisible(true);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            }
        });
    }
}

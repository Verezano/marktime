package org.hannes.marktime;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

public class MarkTime {
	final static Logger logger = Logger.getLogger(MarkTime.class);

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			UI app=new UI();
			app.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			        if (JOptionPane.showConfirmDialog(app, 
			            "Weet je zeker dat je het programma wilt stoppen?", "Afsluiten?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			        		logger.info("Program exit");
			            	System.exit(0);
			        }
			    }
			});

			app.setVisible(true);
		} catch (Exception e) {
			 e.printStackTrace(System.out);
			System.out.println(e.getMessage());
		}
	}
}

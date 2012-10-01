import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;     
import net.miginfocom.*;
import net.miginfocom.swing.MigLayout;

public class GUI {
    private JTextArea url;
    private JTextField begin;
    private JTextField end;
    
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Basic Webscraper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);

        //init panel
        JPanel content = new JPanel(new MigLayout(""));
        
        JLabel label = new JLabel("URL(s)");
        content.add(label, "wrap");
        
        //Add window items
        url = new JTextArea(5, 50);
        content.add(url, "wrap, span 4");
        
        JLabel beginLabel = new JLabel("Begin");
        content.add(beginLabel, "width 10%");
        begin = new JTextField(20);
        content.add(begin, "width 40%");
        beginLabel.setLabelFor(begin);
        
        JLabel endLabel = new JLabel("End");
        content.add(endLabel, "width 10%, align right");
        end = new JTextField(20);
        content.add(end, "wrap, width 40%");
        
        JButton go = new JButton("Ok");
        content.add(go, "wrap");
        go.addActionListener(new ActionListener() { 
    	  public void actionPerformed(ActionEvent e) { 
    	    goClick();
    	  } 
    	});
        
        //Display the window.
        frame.add(content);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void goClick() {
    	String[] urls = url.getText().split("\\n");
    	try {
			new Parser(urls, begin.getText(), end.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public GUI() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
package mplayer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MusicPlayer extends JPanel implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constant for the number of character on the display. 
     * 
     */
    public static final int DISPLAY_WIDTH = 40;

    //Graphical interface components (buttons and text fields)
    private JButton begin, end, next, previous, start;
    private JTextField display;

    //the play list object
    private PlayList music;

    
    /**
     * Creates a new <code>MusicPlayer</code> instance.
     *  Builds the user interface
     */
    public MusicPlayer(){
	//create the play list
	music = new PlayList();

	//create user interface components
	begin = new JButton("|<");
	end = new JButton(">|");
	next = new JButton(">>");
	previous = new JButton("<<");
	start = new JButton("Start");
	
	display = new JTextField(DISPLAY_WIDTH);
	

	//set up the display text field
	display.setEditable(false);

	//get the initial data to display
	String title = music.first();
	int track = music.getCurrentTrackNumber();
	display.setText(track + ": " + title);

	//make the display pretty
	display.setHorizontalAlignment(JTextField.CENTER);
	display.setBackground(Color.BLACK);
	display.setForeground(Color.GREEN);
	display.setFont(new Font("Courier", Font.BOLD, 18));

	//make all of the buttons call the actionPerformed method when clicked
	begin.addActionListener(this);
	end.addActionListener(this);
	next.addActionListener(this);
	previous.addActionListener(this);
	start.addActionListener(this);
	
	//layout the display
	setLayout(new BorderLayout());


	//create a button subpanel
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(begin);
	buttonPanel.add(previous);
	buttonPanel.add(next);
	buttonPanel.add(end);
	buttonPanel.add(start);
	
	//add the panels and the display
	add(buttonPanel, BorderLayout.CENTER);
	add(display, BorderLayout.NORTH);
	
       
    }


    /**
     * actionPerformed is called when the user clicks a button
     *
     * @param e an <code>ActionEvent</code> value
     */
    public void actionPerformed(ActionEvent e){
	if(e.getSource() == begin){
	    //the user hit the begin button |<
	    String title = music.first();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	}
	else if(e.getSource() == end){
	    //the user hit the end button >|
	    String title = music.last();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == next){
	    //the user hit next >>
	    String title = music.getNext();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == previous){
	    //the user hit previous <<
	    String title = music.getPrevious();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	} 
	else if(e.getSource() == start){
	    //the user hit previous <<
	    String title = music.getCurrent();
	    int track = music.getCurrentTrackNumber();
	    display.setText(track + ": " + title);
	    MakeSound mk = new MakeSound();
	    mk.playSound(title);
	} 
	else{
	}
    }

    public static void main(String[] args){
	//create the JFrame
	JFrame f = new JFrame("Music Player");

	//add a MusicPlayer panel
	f.add(new MusicPlayer());

	//make sure the x button works
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//make it resize itself
	f.pack();

	//display it
	f.setVisible(true);
    }

}

package mplayer;
/**
 * PlayList describes the behavior of a play list for a music player. It
 * stores in order and allows a program to navigate the songs using its methods.
 * The playlist keeps track of the current song being played as well.
 *
 * @author <a href="mailto:cpresser@gettysburg.edu">Clif Presser</a>
 * @version 1.0
 */
public class PlayList {

    //A place to put the names of the songs
    protected String[] songs;

    //The current track index in the array.
    protected int current;

    /**
     * Creates a new <code>PlayList</code> instance.
     *
     */
    public PlayList(){
    	current = 0;

	//For a real application you would want to 
	//load these from a file.
    	songs = new String[10];
    	songs[0] = "/home/ivan/luciano-pavarotti-nessun-dorma-giacomo-puccini-tur.wav";
    	songs[1] = "The Stand";
    	songs[2] = "Three blind mice";
    	songs[3] = "This Corrosion";
    	songs[4] = "Lola";
    	songs[5] = "Hotel California";
    	songs[6] = "Still Lovin' you";
    	songs[7] = "Pride";
    	songs[8] = "Return to Sender";
    	songs[9] = "Rave On";
    }


    /**
     * Set the current song to the first song on the list.
     *
     * @return The name of the first song.
     */
    public String first(){
    	current = 0;
    	return songs[current];

    }

    /**
     * Set the current song to the last song on the list.
     *
     * @return The name of the last song.
     */
    public String last(){
    	current = songs.length - 1;
    	return songs[current];
    }

    /**
     * Returns the track number of the current song. In a play list,
     * the first song is track 1.
     *
     * @return The current track number.
     */
    public int getCurrentTrackNumber(){
    	return current + 1;
    }

    /**
     * Advances the current track by one and returns the new current song's name.
     * If the current song is the last on the list, the next song will be the first 
     * on the list. 
     *
     *
     * @return a <code>String</code> value
     */
    public String getNext(){
    	current++; //current = current + 1
    	if(current >= songs.length){
    		current = 0;
    	}
    	
    	return songs[current];
    }

    /**
     * Gets the name of the current track.
     *
     * @return The name of the current track.
     */
    public String getCurrent(){
    	return songs[current];
    }

    /**
     * Decrements the current track by one and returns the new current song's name.
     * If the current song is the first on the list, the previous song will be the last
     * on the list.
     *
     * @return a <code>String</code> value
     */
    public String getPrevious(){
    	current--;
    	if(current < 0){
    		current = songs.length - 1;
    	}
    	return songs[current];
    }

    /**
     * Returns the number of songs in this playlist.
     *
     * @return The number of songs in the playlist.
     */
    public int getTotalTracks(){
    	return songs.length;
    }

} //end class PlayList


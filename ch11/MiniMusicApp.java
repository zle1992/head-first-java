import javax.sound.midi.*;
public class MiniMusicApp{
    public static void main(String[] args){
    MiniMusicApp mini = new MiniMusicApp();
    mini.play();
   }
    public void play(){
        try {
            Sequencer player = MidiSystem.getSequencer();// 1.get Sequencer and open
	    player.open();

     	    Sequence seq = new Sequence(Sequence.PPQ,4);//2.

            Track track = seq.createTrack();//3.get track

	    ShortMessage a = new ShortMessage();//4.add MidiEvent to track
            a.setMessage(144,1,44,100);
	    MidiEvent noteOn = new MidiEvent(a,11);
	    track.add(noteOn);

	    ShortMessage b = new ShortMessage();
	    b.setMessage(128,1,44,120);
	    MidiEvent noteOff = new MidiEvent(b,40);
	    track.add(noteOff);

	    player.setSequence(seq);//add  Sequence to Sequencer 
            player.start();

        }catch(Exception ex){
            ex.printStackTrace();
        }
     }
}

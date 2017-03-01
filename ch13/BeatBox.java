import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox{
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer ;
    Sequence sequence;
    Track track;
    JFrame theFrame;
    String[] instrumentsNames ={"instruments_1","instruments_2","instruments_3","instruments_4","instruments_5","instruments_6","instruments_7","instruments_7","instruments_8","instruments_9","instruments_10","instruments_11","instruments_12","instruments_13","instruments_14","instruments_15","instruments_16"};
    int[] instruments = {34,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    
    public static void main(String [] args){
        new BeatBox().buildGUI();
    }
    public void buildGUI(){
        theFrame = new JFrame("BeatBo ");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("START");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        
        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton uptempo = new JButton("uptempo");
        uptempo.addActionListener(new MyuptemopListener());
        buttonBox.add(uptempo);

        JButton downtempo = new JButton("downtempo");
        downtempo.addActionListener(new MydowntempoListener());
        buttonBox.add(downtempo);
        
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(int i = 0;i<16;i++){
            nameBox.add(new Label(instrumentsNames[i]));
        }
        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);

        theFrame.getContentPane().add(background);
        
        GridLayout grid =new GridLayout(16,16);
        grid.setVgap(1);
        grid.setVgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);

        for(int i = 0;i<256;i++){
            JCheckBox  c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }
        
        setUpMidi();
        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);



    }
    public void setUpMidi(){
      
        try{
           Sequencer sequencer = MidiSystem.getSequencer();
           sequencer.open();
           Sequence seq = new Sequence(Sequence.PPQ,4);
           Track track = seq.createTrack();  
           sequencer.setTempoInBPM(120);
          }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void buildTrackAndStart(){
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i =0;i<16;i++){
            trackList = new int[16];
            int key = instruments[i];
            for(int j = 0 ;j<16;i++){
                JCheckBox jc = ( JCheckBox) checkboxList.get(j+(16*i));
                if(jc.isSelected()){
                    trackList[j]=key;
                }
                else{
                    trackList[j]=0;
                }
            }

            makeTracks(trackList);

            track.add(makeEvent(176,1,127,0,16));
        
        }
        track.add(makeEvent(176,1,127,0,16));
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        }catch(Exception e){
             e.printStackTrace();
        }
    }
    public class MyStartListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            buildTrackAndStart();
        }
    }

    public class MyStopListener  implements ActionListener{
        public void actionPerformed(ActionEvent a){
            sequencer.stop();
        }
    }
    public class MyuptemopListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float temopFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(temopFactor*1.03));
        }
    }
    public class MydowntempoListener implements ActionListener{ 
        public void actionPerformed(ActionEvent a){
            float temopFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(temopFactor*0.97));
        }
    }

    public void makeTracks(int[] list){
        for(int i =0;i<16;i++){
            int key =list[i];
            if(key!=0){

                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(144,9,key,100,i+1));
            }
        }
    }
    public MidiEvent makeEvent (int comd, int chan ,int one, int two, int tick){
            
        MidiEvent event = null;
        try{
                ShortMessage a = new ShortMessage();
                a.setMessage(comd,chan,one,two);
                event =new MidiEvent(a,tick);
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return event;
    }
}

package simulation;

import java.awt.*;
public class Main {
    
    public static TitleScreen TS;
    static SimulationScreen SS;
    public static StyleConfig SC;
    public static void main(String[] args) {
        SC = new StyleConfig();
        SC.Initialize();
        TS  = new TitleScreen(); 
        //set the visibility of the window to true on start
        //TS.setVisible(true);
        SS = new SimulationScreen();
        SS.setVisible(true);
    }
}
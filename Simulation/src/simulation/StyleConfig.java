/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Xander Ison
 */

public class StyleConfig {
    // COLORS!! YEY
    public static Color BUTTON_BACKGROUND_COLOR = HexToColor("#ff6100");   
    public static Color BUTTON_TEXT_COLOR = Color.WHITE;
    
    // BUTTON STYLES CONFIGURATION :)
    // SIZES
    public static int BUTTON_WIDTH = 100;
    public static int BUTTON_HEIGHT = 40;
    public static float BUTTON_TEXT_SIZE = 16f;
    public static Dimension BUTTON_DIMENSION;
    
    // WINDOW STYLES CONFIGURATION
    public static int MAIN_WINDOW_WIDTH = 1024;
    public static int MAIN_WINDOW_HEIGHT = 568;
    
    public static GraphicsEnvironment GE;
//    0. HelveticaNowDisplay Black  
//    1. HelveticaNowDisplay Bold  
//    2. HelveticaNowDisplay Hairline  
//    3. HelveticaNowDisplay Light  
//    4. HelveticaNowDisplay Medium  
//    5. HelveticaNowDisplay Regular  
//    6. HelveticaNowDisplay Thin
//    6. bold
    
    public static Font HND_FONTS[] = new Font[25];
    public static String FONTS_DIRECTORY = "fonts/";
    
    //TEXTS
    public static int TITLE_SCREEN_TEXT_WIDTH= 370;
    
    //INITIAL METAL LIST 
    public static String DEFAULT_METAL_NAMES[] = {"Gold", "Aluminum", "Copper"};
    
    //this is in N x 10^-6 where N is the input
    public static int DEFAULT_METAL_COUNT = 3;
    public static Float DEFAULT_METAL_COEFFS[] = {14.2f, 23.6f, 16.5f};
    public static Color DEFAULT_METAL_COLORS[] = {Color.BLUE, Color.CYAN, Color.GREEN};
    public static String DEFAULT_METAL_IMAGEPATHS[] = {"assets/Images/goldrod.png", "assets/Images/metalrod.png", "assets/Images/copperrod.png"};

    //SIMULATION STYLES
    public static int METAL_SELECTOR_WIDTH = 100;
    public static int METAL_SELECTOR_HEIGHT = 30;
    public static int METAL_SELECTOR_X = 20;
    public static int METAL_SELECTOR_Y = 20;
    
    
    //WINDOW CONFIGURATION
    void Initialize(){
        BUTTON_DIMENSION = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
        
        
        try {
            File FONTS_DIR = new File(FONTS_DIRECTORY);
            File[] FONTS_FILE_LIST =  FONTS_DIR.listFiles();
            
            int fontCounter = 0;
            for(File fontFile: FONTS_FILE_LIST){
                HND_FONTS[fontCounter] = Font.createFont(Font.TRUETYPE_FONT, fontFile);
                GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GE.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
                fontCounter++;
            }
            
        } catch (IOException|FontFormatException e) {
             System.out.printf("Error loading fonts:");
        }
        
//        System.out.printf("Fonts:");
//        for(Font f: HND_FONTS){
//            System.out.printf( "%s, ", f.getName());
//        }
    }
    
    public static Color HexToColor(String hex) 
{
    hex = hex.replace("#", "");
    switch (hex.length()) {
        case 6:
            return new Color(
            Integer.valueOf(hex.substring(0, 2), 16),
            Integer.valueOf(hex.substring(2, 4), 16),
            Integer.valueOf(hex.substring(4, 6), 16));
        case 8:
            return new Color(
            Integer.valueOf(hex.substring(0, 2), 16),
            Integer.valueOf(hex.substring(2, 4), 16),
            Integer.valueOf(hex.substring(4, 6), 16),
            Integer.valueOf(hex.substring(6, 8), 16));
    }
    return null;
}
    //initializes fonts
    //offsetObj is the object that the function needs to get the width, for offset.
    public static int getWindowCenterWidth(int objectWidth){
        return (MAIN_WINDOW_WIDTH / 2) - (objectWidth/2);
    }
}

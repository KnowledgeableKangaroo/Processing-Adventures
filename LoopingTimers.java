package movement;
 
import processing.core.PApplet;
import processing.core.PImage;
 
 
public class LoopingTimers extends PApplet {
	public int startTime;
    public int stopwatch;
    public int count;
    public int interval;
    public double seconds;
    
    public int colorState = 0;
    public int sizeState = 3;
    public int speedState = 1;
 
    public static void main(String[] args) {
        PApplet.main("movement.LoopingTimers");
    }
 
    //2D array with (x, y) locations of the points of the cat.
    public int[][] catPoints = {{10, 10}, {12, 12}, {14, 14}, {15, 18}, 
            {18, 22}, {21, 27}, {21, 32}, {24, 28}, {23, 24}, {23, 20}, 
            {25, 18}, {28, 18}, {27, 20}, {25, 21}, {25, 25}, {25, 30}, 
            {21, 34}, {13, 34}, {10, 34}, {11, 32}, {14, 33}, {11, 30}, 
            {11, 28}, {10, 30}, {9, 34}, {7, 33}, {8, 33}, {8, 30}, {7, 27}, 
            {7, 24}, {8, 21}, {9, 18}, {7, 17}, {6, 16}, {7, 13}, {9, 12}, 
            {10, 10}};
 
    public void settings() {
        size(800, 600);
    }
 
    public void setup() {
    	count = catPoints.length - 1;
    	startTime = millis();
        background(255, 255, 255);
        seconds = interval * 1000;
    }
 
    public void draw() {
    	stopwatch = millis() - startTime;
    	
        switch (colorState) {
        case 0:
        	stroke(255, 105, 0);
        	break;
        case 1:
        	stroke(0, 105, 255);
        	break;
        case 2:
            stroke(155, 155, 155);
        	break;
        }
        
        switch (sizeState) {
        case 3: 
        	scale(9);
        	break;
        case 4:
        	scale(12);
        	break;
        case 5:
        	scale(15);
        	break;
        }
        
        switch (speedState) {
        case 1:
        	interval = 500; // Every half a second
        	break;
        case 2:
        	interval = 250; // Every 1 second
        	break;
        case 3:
        	interval = 125;
        	break;
        }	
        
        if (stopwatch > interval && count > 0) {
            line(catPoints[count][0], catPoints[count][1], catPoints[count - 1][0], catPoints[count - 1][1]);
            count --;
        	seconds+= 0.5;
        	System.out.println(seconds + " seconds passed");
        	startTime = millis();
        }
        if (count == 15) {
        	stroke(255, 0, 0);
        }
        else {
        	stroke(0, 0, 0);
        }
    }
    
    public void keyReleased() {
    	if(key == ' ') {
            if(colorState < 2) {
                 colorState ++;
             }
             else {
                 colorState = 0;
             }
         }
    	if (key == 's') {
    		if (sizeState < 5) {
    			sizeState++;
    		}
    		else {
    			sizeState = 3;
    		}
    	}
    }
    
    public void mouseClicked() {
    	if (speedState < 3) {
    		speedState++;
    	}
    	else {
    		speedState = 1;
    	}
    }
}

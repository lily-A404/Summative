/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;
import processing.core.PImage;
import processing.core.PApplet;
import java.util.Random;
/**
 *
 * @author lilya
 */
public class MySketch extends PApplet {
    private boolean gameOver = false;
    
    private int speed = 5;
    private HouYi houyi;
    private Sun sun1, sun2, sun3, sun4, sun5, sun6, sun7, sun8, sun9;
    private int sunSpeed = 5;
    private int sunDiameter1 = 70;
    private boolean stage1Cleared = false;

    
    private PImage backgroundImg;
    private PImage deathScreen;
    
    //vars for projectile
    private boolean isShooting = false;
    private int arrowX, arrowY;
    private int arrowSpeed = 10;
    
    
    public void settings(){
        size(800,600);
    }
    
    public void setup(){
        backgroundImg = loadImage ("images/bg.png");
        deathScreen = loadImage("images/death screen.png");
        houyi = new HouYi(this, 0, 369, speed, "images/houyi.png");
        
        //creating enemie sun objects
        sun1 = new Sun (this, 100,30,sunSpeed+5, sunDiameter1);
        sun2 = new Sun (this, 700,30, sunSpeed+2, sunDiameter1);
        sun3 = new Sun(this, 300, 30, sunSpeed, sunDiameter1*2);
    }
    
    public void draw(){
        if (gameOver) {//end up game play
        image(deathScreen, 0, 0, 800, 600);
        return; // stop the rest of draw() from running 
        }
        
        image (backgroundImg,0, 0, 800, 600);
        fill(255);
        Sun[][] suns = new Sun[1][3];
        suns [0][0] = sun1;
        suns[0][1] = sun2;
        suns[0][2]= sun3;
        
        
        
        
        for (int row = 0; row < suns.length; row++) {
    for (int col = 0; col < suns[row].length; col++) {
        Sun sun = suns[row][col];
        if (sun != null) {  // always a good idea to null-check
            //drawing, moving and, firing suns
            if (!sun.getIsShot()) {
                sun.draw();
                sun.move(sun.getSpeed(), 50);

                Random random = new Random();
                int randomInt = random.nextInt(4);
                if (randomInt > 2) {
                    sun.shootFire();
                }

                sun.updateFire();
                
                //fire collision detection-------------------->
                
            Fire fire = sun.getFire();//grabing fire object through the sun
            
                if (fire != null && fire.getIsActive()) {//not empty and true on active fire
                    int fireX = fire.getX();
                    int fireY = fire.getY();

                    float houyiX = houyi.getX();
                    float houyiY = houyi.getY();
                    float houyiW = houyi.getWidth();
                    float houyiH = houyi.getHeight();

                    // Simple bounding box collision detection(fire)
                    if (fireX >= houyiX && fireX <= houyiX + houyiW &&
                        fireY >= houyiY && fireY <= houyiY + houyiH) {
                        houyi.hurt();
                        println("Fire hit HouYi! Health: " + houyi.getHealth());
                        sun.getFire().deactivate();  // optional: stop the fire after hit
                    }
                            
        
        //annimating arrow
        if (isShooting){
            line(arrowX + 50,arrowY, arrowX+50, arrowY+20);//line piece
            arrowY -= arrowSpeed;//going up
            
        //arrow collision with sun?
            float sunCenterX = sun.getX() + sun.getDiameter()/2;
            float sunCenterY = sun.getY() + sun.getDiameter()/2;
        
            float d = dist(arrowX, arrowY, sunCenterX, sunCenterY);
            
            if (d < sun.getDiameter()){
                println("Sun down!");
                sun.setIsShot(true);
                isShooting = false;
            }
        }//shooting arrow
                    if (houyi.getHealth() <= 0|| !houyi.getIsAlive()){
                        gameOver = true;
                    }
                    }//if fire is active and not null
            }//if sun isn't shot
        }//if sun is not null
    }//columnfor loop
        }//row for loop

        if (!stage1Cleared && sun1.getIsShot() &&sun2.getIsShot()&&sun3.getIsShot()){
            System.out.println("3/9 suns down!");
            stage1Cleared = true;
        }
        
        if (stage1Cleared){
            sun4 = new Sun (this, 100,30,sunSpeed+5, sunDiameter1);
            sun5 = new Sun (this, 700,30, sunSpeed+2, sunDiameter1);
            sun6 = new Sun(this, 300, 30, sunSpeed, sunDiameter1*2);
        }
        
        if (keyPressed) {//moving houYi
            houyi.draw();
                if (keyCode == LEFT) {
                    houyi.move(-speed, 0);
                } else if (keyCode == RIGHT) {
                    houyi.move(speed, 0);
                }
                    if (key == ' ') {
                        isShooting = true;
                        arrowX = houyi.getX() + 20;
                        arrowY = houyi.getY() + 20;
                    }else{
                        isShooting = false;
                    }
                
        }//outside of key press
        houyi.draw();

    }//END OF DRAW METHOD------------------------------------------------------------
    
@Override
public void keyPressed() {
    if (gameOver) {
        resetGame(); // restart game on ANY key
    }
}
    //-----------------------extra methods for sketch class specifically-----------------
    //i have no idae, chatgpt told me to add this bc of a mysterious error :(
    public static void main(String[] args) {
        PApplet.main("summative.MySketch");
    }
    
        public void resetGame() {
        // reset key game state
        houyi = new HouYi(this, 0, 369, speed, "images/houyi.png");
        sun1 = new Sun (this, 100,30,sunSpeed+5, sunDiameter1);
        sun2 = new Sun (this, 700,30, sunSpeed+2, sunDiameter1);
        sun3 = new Sun(this, 300, 30, sunSpeed, sunDiameter1*2);
        isShooting = false;
        arrowX = arrowY = 0;
        gameOver = false;
    }
}
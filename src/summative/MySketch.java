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
    private int speed = 5;
    private HouYi houyi;
    private Sun sun1;
    private Sun sun2;
    private int sunSpeed = 5;
    private int sunDiameter1 = 70;
    private PImage backgroundImg;
    
    //vars for projectile
    private boolean isShooting = false;
    private int arrowX, arrowY;
    private int arrowSpeed = 10;
    
    
    public void settings(){
        size(800,600);
    }
    
    public void setup(){
        backgroundImg = loadImage ("images/bg.png");
        houyi = new HouYi(this, 0, 369, speed, "images/houyi.png");
        sun1 = new Sun (this, 100,30,sunSpeed, sunDiameter1);
        sun2 = new Sun (this, 500,30, sunSpeed, sunDiameter1);
    }
    
    public void draw(){
        image (backgroundImg,0, 0, 800, 600);
        fill(255);
        
        if (!sun1.getIsShot()){
            sun1.draw();
            sun1.move(sun1.getSpeed(), 50);
            
            Random random = new Random();
            int randomInt = random.nextInt(4);//random int between 0-3
            
            if (randomInt > 2){
                sun1.shootFire();
            }
            
            sun1.updateFire();
            sun2.draw();
            sun2.move(sun1.getSpeed(), 50);
        }else{
            System.out.print("both are shot");
        }
        
        
        if (keyPressed) {//moving houYi
            houyi.draw();
                if (keyCode == LEFT) {
                    houyi.move(-speed, 0);
                } else if (keyCode == RIGHT) {
                    houyi.move(speed, 0);
                /*} else if (keyCode == UP) {
                    Houyi.move(0, -speed);
                } else if (keyCode == DOWN) {
                    houyi.move(0, speed);
                }
                System.out.print("moving");
                } else if (key == ' '){
                    line(houyi.getX()+70, houyi.getY()-200,houyi.getX()+70, houyi.getY()); */
                }
        }//outside of key press
        houyi.draw();
        
        //FIRE COLLISION?
        
        // Fire collision with HouYi
        Sun[] suns = {sun1, sun2};
        
        for (Sun sun : suns){
            Fire fire = sun.getFire();
            
            if (fire != null && fire.getIsActive()) {//not empty and true on active fire
                int fireX = fire.getX();
                int fireY = fire.getY();

                float houyiX = houyi.getX();
                float houyiY = houyi.getY();
                float houyiW = houyi.getWidth();
                float houyiH = houyi.getHeight();

                // Simple bounding box collision detection
                if (fireX >= houyiX && fireX <= houyiX + houyiW &&
                    fireY >= houyiY && fireY <= houyiY + houyiH) {
                    houyi.hurt();
                    println("Fire hit HouYi! Health: " + houyi.getHealth());
                    sun1.getFire().deactivate();  // optional: stop the fire after hit
                }
                
                if (houyi.getHealth() <= 0){
                    print("Dead");
                    
                }
            }
        }

        //annimating arrow
        if (isShooting){
            line(arrowX + 50,arrowY, arrowX+50, arrowY+20);//line piece
            arrowY -= arrowSpeed;//going up
        //arrow collision with sun?
            
            float sunCenterX = sun1.getX() + sun1.getDiameter()/2;
            float sunCenterY = sun1.getY() + sun1.getDiameter()/2;
        
            float d = dist(arrowX, arrowY, sunCenterX, sunCenterY);
            
            if (d < sun1.getDiameter()){
                println("Sun down!");
                sun1.setIsShot(true);
                isShooting = false;
            }
        }//shooting arrow
    }
    
    @Override
    public void keyPressed(){
        if (key == ' '){
            isShooting = true;
            arrowX= houyi.getX() + 20;
            arrowY = houyi.getY() + 20;
        }
    }
    
    //i have no idae, chatgpt told me to add this bc of a mysterious error :(
    public static void main(String[] args) {
        PApplet.main("summative.MySketch");
    }

}
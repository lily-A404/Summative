/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;

/**
 *
 * @author lilya
 */
public class MySketch extends PApplet {
    private int speed = 5;
    private HouYi Houyi;
    private Sun sun1;
    
    
    public void settings(){
        size(800,500);
    }
    
    public void setup(){
        background (100,100,100);
        Houyi = new HouYi(this, 50, 200, speed, "images/houyi.png");
    }
    
    
    public void draw(){
        background(100,100,100);
        fill(255);
        sun1 = new Sun (this, 10,10,5, 10);
        sun1.draw();
        if (keyPressed) {
            Houyi.draw();
            line(100, 100, 200, 200);
                if (keyCode == LEFT) {
                    Houyi.move(-speed, 0);
                } else if (keyCode == RIGHT) {
                    Houyi.move(speed, 0);
                //} else if (keyCode == UP) {
                    //Houyi.move(0, -speed);
                } else if (keyCode == DOWN) {
                    Houyi.move(0, speed);
                }
            }
        
            Houyi.draw();
    }
    
    public void keyPressed(){
        if (keyCode == UP){
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;

import processing.core.PApplet;
import processing.core.PImage;

/**
 *
 * @author lilya
 */
public class HouYi {
    private int x, y;
    int speed;
    int health = 10;
    private PImage image;
    private PApplet app;
    
    public HouYi(PApplet p, int x, int y, int speed, String imagePath){//String name
        this.app = p;
        this.x = x;
        this.y = y;
        this.speed = (speed);
        this.image = app.loadImage(imagePath);
    }
    //-------get/set methods
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    //-------
    public void draw(){
        app.image(image, x, y);
    }
    
    public void move(int dx, int dy){//keyboards
    x += dx;
    y += dy;
    }
    
}

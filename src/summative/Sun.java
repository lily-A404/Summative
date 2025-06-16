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
public class Sun {
    private PApplet app;
    private int x;
    private int y;
    private boolean isShot = false;
    private int speed;
    private float radius;//size
    
    private boolean forward = true;//moving
    private Fire fire;//projectile
    
    private int fireX =  x + Math.round(radius);//used for collision detection and moving
    private int fireY =  y + Math.round(radius)-70;
    
    public Sun(PApplet app, int x, int y, int speed, float radius){
        this.app = app;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.radius = radius;
    }
    
    public void shootFire(){//part 1
        if (fire == null || !fire.getIsActive()){//if fire is not ready to be shot, then we make it ready(insantiating object)
            fire = new Fire(app,  x + Math.round(radius),y + Math.round(radius)-70, 8, "images/fire.png");
        }
    }
    
    public void updateFire(){//part 2
        if (fire != null && fire.getIsActive()){//when fire is ready, move n draw it
            fire.move();
            fire.draw();
        }
    }
    
    public void move(int dx, int dy) {
        if (forward) {//if direction is forward, more forward
            x += dx;
            if (x >= 800 - dx) {//if reached the maximum forward, then go backwards
                forward = false;
            }
        } else {
            x -= dx;//if backward, move backward
            if (x <= 0) {//if reached maximum/edge of window, start forward again
                forward = true;
            }
        }

        y = dy; // Optional: vertical movement
    }
    
    public void draw(){
        app.fill(255, 255, 102);//yellow
        app.circle(x,y,radius);//plain circle
    }

    
    //-------------------------GET/SET METH0DS//------------------------->
    public boolean getIsShot(){
        return isShot;
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    public float getDiameter(){
        return radius*2;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public int getFireX(){
        return fireX;
    }
    
    public int getFireY(){
        return fireY;
    }
    
    public void setIsShot(boolean x){
        isShot = x;
    }
    
    public Fire getFire(){
        return fire;
    }
    
    //--------------------------GET/SET METHODS//------------------------->
}

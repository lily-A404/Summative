/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summative;
import processing.core.PImage;
import processing.core.PApplet;
import java.util.Random;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import java.io.PrintWriter;
import java.io.FileWriter;
/**
 *
 * @author lilya
 */
public class MySketch extends PApplet {
    
    //game function variables
    private boolean gameOver = false;
    private int currentLevel = 0;
    private int mainDialogIndex = -1;//setting to neg 1 for the homepage
    private boolean visualNovel = true;
    
    private int speed = 5;
    private HouYi houyi;
    private Sun sun1, sun2, sun3, sun4, sun5, sun6, sun7, sun8, sun9;
    
    
    
    //sun stuff
    private int sunSpeed = 5;
    private int sunDiameter1 = 70;
    Sun [][] sunWaves = new Sun[3][3];
    
    private PImage backgroundImg;
    private PImage deathScreen;
    
    //vars for projectile
    private boolean isShooting = false;
    private int arrowX, arrowY;
    private int arrowSpeed = 10;
    
    //visual novel character classes
    private CharacterSprite houyiSprite;
    private MessengerHawk hawk;
    private CharacterSprite scroll;
    private CharacterSprite elixir;
    private CharacterSprite ChangE;
    private CharacterSprite ChangEScene;
    
    
    private CharacterSprite sun;
    private CharacterSprite jadeEmporerNervous;
    private CharacterSprite jadeEmporer;
    
    //dialog
    private String[] mainDialog = loadDialogue("dialogue.txt");
    
    
    private String userInput = "";//reviews of the game!
    
    
    public void settings(){
        size(800,600);
    }
    
    public void setup(){
        //images for game play
        backgroundImg = loadImage ("images/bg.png");
        deathScreen = loadImage("images/death screen.png");
        houyi = new HouYi(this, 0, 369, speed, "images/houyi.png");
        
        //sprites for visual novel intro/end
        houyiSprite = new CharacterSprite(this, 400, 100, "images/houyi sprite.png");
        hawk = new MessengerHawk(this, 50, 100, "images/message hawk.png");
        scroll = new CharacterSprite (this, 50, 100, "images/scroll.png");
        sun = new CharacterSprite (this, 50, 100, "images/crow.png");
        jadeEmporerNervous = new MessengerHawk(this, 50, 50, "images/jade emporer nervous.png");
        jadeEmporer= new MessengerHawk(this, 50, 50, "images/jade emporer normal.png");
        elixir= new MessengerHawk(this, 50, 50, "images/elixir.png");
        ChangE= new MessengerHawk(this, 50, 50, "images/ChangE on moon.png");
        ChangEScene= new MessengerHawk(this, 50, 0, "images/ChangE scene.png");
        
        //creating enemie sun objects
        sun1 = new Sun (this, 100,30,sunSpeed+5, sunDiameter1);
        sun2 = new Sun (this, 700,30, sunSpeed+2, sunDiameter1);
        sun3 = new Sun(this, 300, 30, sunSpeed, sunDiameter1*2);
        
        sun4 = new Sun (this, 700,30, sunSpeed+2, 80);
        sun5 = new Sun(this, 300, 30, sunSpeed, sunDiameter1);
        sun6 = new Sun (this, 200,30, sunSpeed+2, 50);
        
        sun7 = new Sun(this, 100, 30, sunSpeed, 30);
        sun8 = new Sun(this, 300, 30, sunSpeed, 50);
        sun9 = new Sun (this, 700,30, sunSpeed+2, 20);
        sunWaves [0][0] = sun1;
        sunWaves [0][1] = sun2;
        sunWaves [0][2] = sun3;
        sunWaves [1][0] = sun4;
        sunWaves [1][1] = sun5;
        sunWaves [1][2] = sun6;
        sunWaves [2][0] = sun7;
        sunWaves [2][1] = sun8;
        sunWaves [2][2] = sun9;
    }
    
    public void draw(){
                
        if (gameOver) {//end up game play
        image(deathScreen, 0, 0, 800, 600);
        return; // stop the rest of draw() from running 
        }
        //beginning of story
        background(255);
        if (mainDialogIndex ==-1){
            fill(0);
            scroll.draw();
            textSize(24);
            text("ICS SUMMATIVE! HouYi and the 10 Suns!", 150, 300);
            textSize(14);
            text("By Lily An", 150, 330);
            
            textSize(18);
            text("click your mouse to continue!", 150, 400);
            
        }else if(mainDialogIndex == 0){
            fill(0);
            houyiSprite.draw();
            textSize(15);
            text(setText(houyiSprite), 150, 70);
            mousePressed();
            
        }else if (mainDialogIndex == 1){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(houyiSprite), 150, 70);
        
        }else if (mainDialogIndex ==2){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(houyiSprite), 500, 70);
            
        }else if (mainDialogIndex ==3){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(hawk), 100, 70);
            
        }else if(mainDialogIndex ==4){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(houyiSprite), 100, 70);
        }else if(mainDialogIndex ==5){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(houyiSprite), 70, 70);
        }else if(mainDialogIndex ==6){
            fill(0);
            houyiSprite.draw();
            hawk.draw();
            text(setText(houyiSprite), 10, 70);
        }else if(mainDialogIndex ==7){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 500, 70);
        }else if(mainDialogIndex ==8){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 100, 70);
        }else if(mainDialogIndex ==9){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 300, 70);
        }else if(mainDialogIndex ==10){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 100, 70);
        }else if(mainDialogIndex ==11){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 400, 70);
        }else if(mainDialogIndex ==12){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 100, 70);
        }else if(mainDialogIndex ==13){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 500, 70);
        }else if(mainDialogIndex ==14){
            
        
        //-------------------------------------------------------- GAMEPLAY START-------------------------------------------------------
        visualNovel = false;
        image (backgroundImg,0, 0, 800, 600);
        Sun[][] suns = new Sun[1][3];
        suns [0][0] = sun1;
        suns[0][1] = sun2;
        suns[0][2]= sun3;
        
        
        
        for (int i = 0; i < 3; i++){
        Sun sun = sunWaves[currentLevel][i];
        
        if (sun != null) {  // null-check
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
                            
        
        //annimating arrow-------------------->
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
        }//for loop
        
        //after loop/after three suns have been defeated
        
        
        boolean levelCleared = true;

        for (int i = 0; i < 3; i++) {
            if (!sunWaves[currentLevel][i].getIsShot()) {
                levelCleared = false;
                break;
            }
        }

        if (levelCleared && currentLevel < 2) {
            currentLevel++; // move to next batch
            println("Level up! Now showing batch " + (currentLevel + 1));
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
        
        
boolean allSunsShot = true;

for (int r = 0; r < sunWaves.length; r++) {
    for (int c = 0; c < sunWaves[r].length; c++) {
        if (!sunWaves[r][c].getIsShot()) {
            allSunsShot = false;
            break;
        }
    }
    if (!allSunsShot) break;
}

if (allSunsShot) {//only occurs when the whole checking loop has gone through and checked EVERY sun in the 2d array
    mainDialogIndex++;
    visualNovel = true;
    println("All suns are down!");
}//-------------------------------------------------------- GAMEPLAY END-------------------------------------------------------
    



      }else if(mainDialogIndex ==15){//if else chain for visual novel thing
            fill(0);
            houyiSprite.draw();
            sun.draw();
            sun.setX(350);
            sun.setY(-15);
            text(setText(houyiSprite), 170, 100);
            mousePressed();
    }else if(mainDialogIndex ==16){
            fill(0);
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 500, 70);
    }else if(mainDialogIndex ==17){
            fill(0);
            jadeEmporerNervous.draw();
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 150, 70);
    }else if(mainDialogIndex ==18){
            fill(0);
            jadeEmporerNervous.draw();
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 150, 70);
    }else if(mainDialogIndex ==19){
            fill(0);
            jadeEmporer.draw();
            houyiSprite.draw();
            sun.draw();
            text(setText(houyiSprite), 500, 70);
    }else if(mainDialogIndex ==20){
            fill(0);
            jadeEmporerNervous.setX(-50);
            jadeEmporerNervous.draw();
            houyiSprite.setX(500);
            houyiSprite.draw();
            elixir.draw();
            elixir.setX(350);
            elixir.setY(100);
            sun.draw();
            text(setText(houyiSprite), 100, 70);
    }else if(mainDialogIndex ==21){
            fill(0);
            ChangEScene.setY(100);
            ChangEScene.draw();
            text(setText(houyiSprite), 100, 70);
    }else if(mainDialogIndex ==22){
            fill(0);
            ChangEScene.draw();
            text(setText(houyiSprite), 100, 70);
    }else if(mainDialogIndex ==22){
            fill(0);
            ChangEScene.draw();
            text(setText(houyiSprite), 100, 70);
    }else if(mainDialogIndex ==23){
            fill(0);
            ChangE.setX(100);
            ChangE.draw();
            text(setText(houyiSprite), 100, 30);
    }else if(mainDialogIndex ==24){
            fill(0);

            ChangE.draw();
            text(setText(houyiSprite), 100, 30);
    }else if(mainDialogIndex ==25){
            fill(0);
            ChangE.draw();
            text(setText(houyiSprite), 100, 70);
    }else if(mainDialogIndex ==26){
            visualNovel = false;
            text("Write a review of the game! How did you find it? \\(ˊoˋ )/", 200, 100);
            text("Enter here: " + userInput, 200,150);
            text("thanks 4 playing !!", 200, 300);
    }
    }//END OF DRAW METHOD------------------------------------------------------------
    
@Override
public void keyPressed() {
    if (gameOver) {
        resetGame(); // restart game on ANY key
    }
    
        // For review input
    if (mainDialogIndex == 26) {
        if (key == BACKSPACE && userInput.length() > 0) {
            userInput = userInput.substring(0, userInput.length() - 1);
        } else if (key == ENTER || key == RETURN) {//typing stuff
            println("User submitted: " + userInput);
            saveReview(userInput);
        } else if (key != CODED) {
            userInput += key; // Add typed key to input string
        }
    }
    
    }

public void mousePressed() {
    if (visualNovel) {
        mainDialogIndex++;
    }
}
    //-----------------------extra methods for sketch class specifically-----------------
    //i have no idae, chatgpt told me to add this bc of a mysterious error :(
    public static void main(String[] args) {
        PApplet.main("summative.MySketch");
    }
    
    
    
        public void resetGame() {//after game over, reset game meth is called
        houyi = new HouYi(this, 0, 369, speed, "images/houyi.png");
        
        //receate all sun enemies
        //--------------------------------------------->sun copy pasting
        sun1 = new Sun (this, 100,30,sunSpeed+5, sunDiameter1);
        sun2 = new Sun (this, 700,30, sunSpeed+2, sunDiameter1);
        sun3 = new Sun(this, 300, 30, sunSpeed, sunDiameter1*2);
        
        sun4 = new Sun (this, 700,30, sunSpeed+2, 80);
        sun5 = new Sun(this, 300, 30, sunSpeed, sunDiameter1);
        sun6 = new Sun (this, 200,30, sunSpeed+2, 50);
        
        sun7 = new Sun(this, 100, 30, sunSpeed, 30);
        sun8 = new Sun(this, 300, 30, sunSpeed, 50);
        sun9 = new Sun (this, 700,30, sunSpeed+2, 20);
        
        
         // Reset sun wave batches
    sunWaves = new Sun[3][3];
    sunWaves[0][0] = sun1;
    sunWaves[0][1] = sun2;
    sunWaves[0][2] = sun3;

    sunWaves[1][0] = sun4;
    sunWaves[1][1] = sun5;
    sunWaves[1][2] = sun6;

    sunWaves[2][0] = sun7;
    sunWaves[2][1] = sun8;
    sunWaves[2][2] = sun9;
    //--------------------------------------------->wave copy pasting
    
     // Reset state variables
    currentLevel = 0;
    isShooting = false;
    arrowX = arrowY = 0;
    gameOver = false;
    }
        
            public static String [] loadDialogue(String filename){
        String allText = "";
                try{
        Scanner reader = new Scanner(new File(filename));
        while (reader.hasNextLine()){
            allText += reader.nextLine();
        }
        reader.close();
                }catch (IOException e){
                    println("Error: " + e);
                }
                
        return allText.split("\\|");//special way to escape to the pipe
    }
            
     public String setText(CharacterSprite guy){
         String speech = "ended up empty :(";
             if (mainDialog == null || mainDialog.length == 0) {
        return "No dialog loaded";
    }
             
         speech = mainDialog[mainDialogIndex];
         
         if (guy instanceof MessengerHawk){
             speech = ((MessengerHawk) guy).getSpeak();
         }
         return speech;
     }
     
     public void saveReview(String review) {//taking in user responses!!
    try {
        PrintWriter writer = new PrintWriter(new FileWriter("reviews.txt", true));
        writer.println(review);
        writer.close();
        println("Review saved successfully.");
    } catch (IOException e) {
        println("Error saving review: " + e);
    }
}
}
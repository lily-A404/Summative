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
public class MessengerHawk extends CharacterSprite {
    private String currentLine;
    public MessengerHawk(PApplet p, int x, int y, String imagePath) {
        super(p, x, y, imagePath);

        // Set the hawk-specific dialog
        this.dialog = new String[]{
            "Squawk!",
            "Caw!",
            "Kee-eeeee-arr!",
            "Chwirk!"
        };
    }
    

    @Override
    public String getSpeak() {
        if (currentLine ==null){
            int randIndex = (int)app.random(dialog.length);//random integer within the range of the array of dialog
            currentLine = dialog[randIndex];
        }
        return currentLine;
    }
}

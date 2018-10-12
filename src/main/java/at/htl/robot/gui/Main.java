package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;

/**
 * Felix Dumfarth
 */

public class Main extends PApplet {
    int leftMargin = 20;
    int upperMargin = 50;
    int boxLenght = 50;
    Robot robot;


    // Hier die Member-Attribute eintragen

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        robot = new Robot();
        robot.setX(1);
        robot.setY(1);

    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {

        textSize((int) (upperMargin * 0.5));
        text("<F> Forward   <L> Rotate Left",10,30);
        strokeWeight(2);
        for (int i = 0; i < 11; i++) {


            line(leftMargin, upperMargin + i * boxLenght, leftMargin + 10 * boxLenght, upperMargin + i * boxLenght);
            line(leftMargin + i * boxLenght, upperMargin, leftMargin + i * boxLenght, upperMargin + 10 * boxLenght);
            int boxCenterX = leftMargin + robot.getX() * boxLenght - boxLenght / 2;
            int boxCenterY = upperMargin + robot.getY() * boxLenght - boxLenght / 2;

            ellipse(boxCenterX,
                    boxCenterY,
                    (int) (boxLenght * 0.8),
                    (int) (boxLenght * 0.8));



        }
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);
        int boxCenterX = leftMargin + robot.getX() * boxLenght - boxLenght / 2;
        int boxCenterY = upperMargin + robot.getY() * boxLenght - boxLenght / 2;


        if (key == 'f' || key == 'F') {
            deleteAll();
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}

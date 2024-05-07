import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // Global Variables

  // Images
  PImage imgMrP;  
  PImage backgroundMap;
  PImage imgPorter;
  PImage imgPiper;
  PImage imgWasted;
  PImage imgMrPEmote;
  PImage imgMandy;
  PImage imgMandyEmote;

  // Porter Variables
  float fltPorterX = 0;
  float fltPorterY = 325;
  double fltPorterSpdX = 10;  
  double fltPorterSpdY = 10;
  boolean stopPorterAnimation = false;

  // Circle Variables
  float circleX = 50; 
  float circleY = 50; 
  float circleSpeed = 8; 
  boolean stopCircleAnimation = false; 

  
  public void settings() {
    // Canvas Size
    size(500, 500);
  }

  public void setup() {
    // Default Background Color (does not matter since I am covering it with image)
    background(0, 255, 0);
    
    // Load Images
    backgroundMap = loadImage("fkyg6rxenqrc1.jpg");
    imgMrP = loadImage("e8390ed3817186c000b1326f3d4e9574.png");
    imgPorter = loadImage("Mr._P_Minion-Agent (1).png");
    imgPiper = loadImage("download (8).png");
    imgWasted = loadImage("wasted hohoho.png");
    imgMrPEmote = loadImage("thumbs down.png");
    imgMandy = loadImage("mandy.png");
    imgMandyEmote = loadImage("Mandy_Pin-Facepalm.png");

    // Resize Images
    imgMrP.resize(height/3, width/3);
    imgPorter.resize(height/5, width/5);
    imgPiper.resize(height/4, width/4);
    imgWasted.resize(height/3, width/3);
    imgMrPEmote.resize(height/5, width/5);
    imgMandy.resize(height/3, width/3);
    imgMandyEmote.resize(height/7, width/7);
  }

  public void draw() {
    // Draw Background Image
    image(backgroundMap, 0, 0, width, height);

    // Draw initial images and drawing
    image(imgPorter, fltPorterX, fltPorterY);
    image(imgMrP, 0, 325);
    image(imgPiper, 300, 0);
    image(imgMandy, 0, 0);
    ellipse(circleX, circleY, 30, 30); 
    
    // Porter Animation
    if (!stopPorterAnimation) {
      fltPorterX += fltPorterSpdX;
      fltPorterY += fltPorterSpdY;

      // Check if image hits the canvas edge
      if (fltPorterX + imgPorter.width >= width || fltPorterX <= 0) {
        fltPorterSpdX *= -1;
      }
      
      if (fltPorterY <= 0 || fltPorterY + imgPorter.height >= height) {
        fltPorterSpdY *= -1;
      }
      
      // Check if the image moves a bit to the left after bouncing off the right wall
      if (fltPorterY <= 50) {
        stopPorterAnimation = true;
      }
    }

    // Bullet/Circle Animation
    if (!stopCircleAnimation) {
      circleX += circleSpeed;

      // Color Change
      fill(0, 150, 255);

      // Check if it reaches past 400 on x axis
      if (circleX >= 400) { 
        stopCircleAnimation = true; 
      }
    }

    // Images appear after the porter and bullet/circle reaches "Piper"
    if (stopPorterAnimation) {
      image(imgWasted, 285, -25);
      image(imgMrPEmote, 140, 280);
      image(imgMandyEmote, 120, 90);
    }

  }
}
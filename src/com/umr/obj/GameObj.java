package com.umr.obj;

import com.umr.GameWin;

import java.awt.*;

public class GameObj {
    private Image img;
    private int x;
    private int y;
    private int width;
    private int height;
    private double speed;
    private GameWin frame;//?为什么要有这个

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public GameObj() {
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //？这个的作用是？
    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics gImage){
        gImage.drawImage(img,x,y,null);
    }
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}

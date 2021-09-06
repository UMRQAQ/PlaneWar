package com.umr.utils;

import com.umr.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static Image bgImg=Toolkit.getDefaultToolkit().getImage("img/bg.jpg");
    public static Image djImg=Toolkit.getDefaultToolkit().getImage("img/boss.png");
    public static Image bzImg=Toolkit.getDefaultToolkit().getImage("img/explode/e6.gif");
    public static Image plImg=Toolkit.getDefaultToolkit().getImage("img/plane.png");
    public static Image shellImg=Toolkit.getDefaultToolkit().getImage("img/shell.png");
    public static Image enemyImg=Toolkit.getDefaultToolkit().getImage("img/enemy.png");
    public static Image bossImg=Toolkit.getDefaultToolkit().getImage("img/boss.png");
    public static Image bulletImg=Toolkit.getDefaultToolkit().getImage("img/bullet.png");

    public static List<BulletObj> bulletObjList=new ArrayList<>();
    public static List<ShellObj> shellObjList=new ArrayList<>();
    public static List<EnemyObj> enemyObjList=new ArrayList<>();
    public static List<GameObj> removeList=new ArrayList<>();
    public static List<GameObj> gameObjList=new ArrayList<>();
    public static List<ExplodeObj> explodeObjList=new ArrayList<>();


    public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }

}

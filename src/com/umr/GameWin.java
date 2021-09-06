package com.umr;

import com.umr.obj.*;
import com.umr.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWin extends JFrame {
    public static int state=0;
    private int width=600;
    private int height=600;
    private int paintCount=1;
    private Image offScreenImage=null;
    public static int score=0;
    private int enemyCount=0;

    BgObj bjObj=new BgObj(GameUtils.bgImg,0,-2000,2);
    public PlaneObj planeObj=new PlaneObj(GameUtils.plImg,290,550,20,30,0,this);
    ShellObj shellObj=new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,14,29,5,this);
    public BossObj bossObj=null;

    public void launch(){
        this.setVisible(true);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("飞机大战");
        GameUtils.gameObjList.add(bjObj);
        GameUtils.gameObjList.add(planeObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1&&(state==0)){
                    state=1;
                    repaint();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32){
                    switch (state){
                        case 1:state=2;break;
                        case 2:state=1;break;
                    }
                }
            }
        });
        while (true){
            if(state==1){
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        if(offScreenImage==null){
            offScreenImage=createImage(width,height);
        }
        Graphics gImage=offScreenImage.getGraphics();
        //gImage.fillRect(0,0,width,height);//?有什么用
        if(state==0){
            gImage.drawImage(GameUtils.bgImg,0,0,this);
            gImage.drawImage(GameUtils.djImg,220,120,this);
            gImage.drawImage(GameUtils.bzImg,270,350,this);
            GameUtils.drawWord(gImage,"点击开始游戏",Color.YELLOW,40,180,300);
        }
        if(state==1){
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
            for(int i=0;i<GameUtils.gameObjList.size();i++){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state==3){
            gImage.drawImage(GameUtils.bzImg,planeObj.getX()-35,planeObj.getY()-50,this);
            GameUtils.drawWord(gImage,"GAME OVER",Color.RED,40,180,300);
        }
        if(state==4){
            gImage.drawImage(GameUtils.bzImg,bossObj.getX()+30,bossObj.getY(),this);
            GameUtils.drawWord(gImage,"游戏通关",Color.GREEN,40,190,300);
        }
        GameUtils.drawWord(gImage,score+"分",Color.green,40,30,100);
        g.drawImage(offScreenImage,0,0,width,height,this);
        paintCount++;
    }

    void createObj(){
        if(paintCount%15!=0){
            return;
        }
        GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,14,29,5,this));
        GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,36,5,this));
        GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
        enemyCount++;
        System.out.println(enemyCount);
        if (bossObj!=null){
            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImg,bossObj.getX()+76,bossObj.getY()+85,15,25,5,this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size()-1));
        }
        if (enemyCount>=10&&bossObj==null){
            bossObj=new BossObj(GameUtils.bossImg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }
    }
    public static void main(String[] args) {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}

package com.umr.obj;

import java.awt.*;

public class ExplodeObj extends GameObj{
    static Image[] pic =new Image[16];
    private int explodeCount=0;

    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i]=Toolkit.getDefaultToolkit().getImage("img/explode/e"+(i+1)+".gif");
        }
    }

    @Override
    public void paintSelf(Graphics gImage) {
        if (explodeCount<16){
            System.out.println("???"+explodeCount);
            setImg(pic[explodeCount]);
            super.paintSelf(gImage);
            explodeCount++;
        }
    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }
}

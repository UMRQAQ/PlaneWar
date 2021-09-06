package com.umr.obj;

import com.umr.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj{
    public PlaneObj() {
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        getFrame().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                setX(e.getX()-11);
                setY(e.getY()-16);
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(getFrame().bossObj!=null&&getRec().intersects(getFrame().bossObj.getRec())){
            GameWin.state=3;
        }
    }
}

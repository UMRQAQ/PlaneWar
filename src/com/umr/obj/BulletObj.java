package com.umr.obj;

import com.umr.GameWin;
import com.umr.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj() {
        super();
    }

    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        setY((int)(getY()+getSpeed()));
        if(getY()>600){
            GameUtils.removeList.add(this);
            return;
        }
        if (this.getRec().intersects((getFrame().planeObj.getRec()))){
            GameWin.state=3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

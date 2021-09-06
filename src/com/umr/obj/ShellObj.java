package com.umr.obj;

import com.umr.GameWin;
import com.umr.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj{
    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        setY((int)(getY()-getSpeed()));
        if(getY()<0){
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

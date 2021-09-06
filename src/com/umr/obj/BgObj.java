package com.umr.obj;

import java.awt.*;

public class BgObj extends GameObj {
    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        setY((int)(getY()+getSpeed()));
        if(getY()>0){
            setY(-2000);
        }
    }
}

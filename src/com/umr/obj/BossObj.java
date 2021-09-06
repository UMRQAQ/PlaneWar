package com.umr.obj;

import com.umr.GameWin;
import com.umr.utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj{
    private int life=10;
    public BossObj() {
        super();
    }

    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (getX()>550||getX()<-50){
            setSpeed(-getSpeed());
        }
        setX((int)(getX()+getSpeed()));
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(getRec().intersects((shellObj.getRec()))){
                shellObj.setX(-100);
                GameUtils.removeList.add(shellObj);
                life--;
            }
            if (life<=0){
                GameWin.state=4;
            }
        }
        gImage.setColor(Color.WHITE);
        gImage.fillRect(20,40,100,10);
        gImage.setColor(Color.RED);
        gImage.fillRect(20,40,life*10,10);

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

package com.umr.obj;

import com.umr.GameWin;
import com.umr.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj {
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
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
        for (ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){
                ExplodeObj explodeObj=new ExplodeObj(getX(),getY());
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                this.setX(-100);
                GameUtils.removeList.add(this);
                GameUtils.removeList.add(shellObj);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

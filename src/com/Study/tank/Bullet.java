package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH = 5, HEIGHT = 5;

    private int x, y;
    private Dir dir;

    private boolean live = true;
    TankFrame tf=null;


    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g) {//绘制子弹
        if(!live){
            tf.bullets.remove(this);//如果没有存活 就移除
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y+24, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x+50, y+24, null);
                break;

            case UP:
                g.drawImage(ResourceMgr.bulletU, x+20, y, null);
                break;

            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x+20, y+50, null);
                break;

        }

        move();//子弹也需要有移动状态


    }

    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
        }

        //超出边界就结束
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;
    }
}

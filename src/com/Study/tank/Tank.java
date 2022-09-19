package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Tank {//将坦克固有类封装给坦克 并且实现构造方法 以调用方向速度等
    private int x, y;
    private Dir dir = Dir.DOWN;//特有属性 默认朝向
    private static final int SPEED = 5;//不能呗改变

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    private boolean moving = false;
    private boolean living = true;
    private TankFrame tf = null;


    public Tank(int x, int y, Dir dir, TankFrame tf) {//将子弹引入
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g) {

        if (!living) {
            tf.tanks.remove(this);//如果没有存活 就不绘制 被消灭的话 就移除
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;

            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;

            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;

        }


        move();
    }

    private void move() {
        if (!moving) return;


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
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//坦克发射子弹的位置
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//坦克发射子弹的位置
        tf.bullets.add(new Bullet(bx, by, this.dir, this.tf));//从坦克的位置发射出来子弹
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void die() {
        this.living=false;
    }
}

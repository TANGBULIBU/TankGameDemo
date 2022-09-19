package com.Study.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Tank {//将坦克固有类封装给坦克 并且实现构造方法 以调用方向速度等
    private int x, y;
    private Dir dir = Dir.DOWN;//特有属性 默认朝向
    private static final int SPEED = 4;//不能呗改变

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;

    private Random random = new Random();//生成随机数
    private Group group = Group.BAD;


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {//将子弹引入
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
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

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();//只有敌人才是随机发射


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

    }

    private void randomDir() {//随机方向

        this.dir = Dir.values()[random.nextInt(4)];//values() 返回到一个数组 数组内是能取的值
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//坦克发射子弹的位置
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//坦克发射子弹的位置

        tf.bullets.add(new Bullet(bx, by, this.dir, this.group, this.tf));//从坦克的位置发射出来子弹
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        this.living = false;
    }
}

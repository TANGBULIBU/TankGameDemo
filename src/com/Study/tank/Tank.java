package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Tank {//将坦克固有类封装给坦克 并且实现构造方法 以调用方向速度等
    private int x, y;
    private Dir dir = Dir.DOWN;//特有属性 默认朝向
    private static final int SPEED = 10;//不能呗改变

    private boolean moving = false;


    public Tank(int x, int y, Dir dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {

        g.fillRect(x, y, 50, 50);

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


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}

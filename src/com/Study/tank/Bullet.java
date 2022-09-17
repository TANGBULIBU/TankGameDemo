package com.Study.tank;

import java.awt.*;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH=5,HEIGHT=5;

    private int x, y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {//绘制子弹
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH,HEIGHT);
        g.setColor(c);

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
    }
}

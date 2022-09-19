package com.Study.tank;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class Bullet {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;

    private boolean living = true;
    TankFrame tf = null;


    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {//�����ӵ�
        if (!living) {
            tf.bullets.remove(this);//���û�д�� ���Ƴ�
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;

            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;

            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;

        }

        move();//�ӵ�Ҳ��Ҫ���ƶ�״̬


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


        //�����߽�ͽ���
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);// Rectangle ���� this�ӵ���λ������
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH, Tank.HEIGHT);// tank��λ������

        if (rect1.intersects(rect2)){//����1��2�ཻ
            tank.die();
            this.die();
        }

    }

    private void die() {
        this.living=false;
    }

}

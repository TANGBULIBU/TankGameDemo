package com.Study.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author ������
 * @version 1.0
 */
public class Tank {//��̹�˹������װ��̹�� ����ʵ�ֹ��췽�� �Ե��÷����ٶȵ�
    private int x, y;
    private Dir dir = Dir.DOWN;//�������� Ĭ�ϳ���
    private static final int SPEED = 4;//�����¸ı�

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;

    private Random random = new Random();//���������
    private Group group = Group.BAD;


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {//���ӵ�����
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }


    public void paint(Graphics g) {

        if (!living) {
            tf.tanks.remove(this);//���û�д�� �Ͳ����� ������Ļ� ���Ƴ�
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
            this.fire();//ֻ�е��˲����������


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

    }

    private void randomDir() {//�������

        this.dir = Dir.values()[random.nextInt(4)];//values() ���ص�һ������ ����������ȡ��ֵ
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;//̹�˷����ӵ���λ��
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;//̹�˷����ӵ���λ��

        tf.bullets.add(new Bullet(bx, by, this.dir, this.group, this.tf));//��̹�˵�λ�÷�������ӵ�
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

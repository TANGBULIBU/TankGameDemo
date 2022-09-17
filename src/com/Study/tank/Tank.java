package com.Study.tank;

import java.awt.*;

/**
 * @author ������
 * @version 1.0
 */
public class Tank {//��̹�˹������װ��̹�� ����ʵ�ֹ��췽�� �Ե��÷����ٶȵ�
    private int x, y;
    private Dir dir = Dir.DOWN;//�������� Ĭ�ϳ���
    private static final int SPEED = 5;//�����¸ı�

    private boolean moving = false;

    private TankFrame tf=null;



    public Tank(int x, int y, Dir dir,TankFrame tf) {//���ӵ�����
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }



    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);

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

    public void fire(){
        tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));//��̹�˵�λ�÷�������ӵ�
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

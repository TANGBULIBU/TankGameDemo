package com.Study.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ������
 * @version 1.0
 */
public class EnemyTank {

    private int x, y;
    private Dir dir = Dir.DOWN;//�������� Ĭ�ϳ���
    private static final int SPEED = 5;//�����¸ı�

    private boolean moving = false;

    private TankFrame tf=null;

    List<EnemyTank> enemyTanks = new ArrayList<>();//����



    public EnemyTank(int x, int y, Dir dir,TankFrame tf) {//���ӵ�����
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

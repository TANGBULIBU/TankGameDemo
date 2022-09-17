package com.Study.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class TankFrame extends Frame {


    Tank myTank = new Tank(200, 200, Dir.DOWN);


    public TankFrame() {


        setSize(800, 600);//设置窗口
        setResizable(false);
        setTitle("tank game");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {//监听窗口 如果关闭 则结束程序
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {

        myTank.paint(g);


//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {//按键
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {//抬起
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {//确定朝向

            if (!bL && !bU && !bD && !bR) myTank.setMoving(false);//不按下这些键 就不会移动
            else {

                myTank.setMoving(true);
                if (bL)
                    myTank.setDir(Dir.LEFT);
                if (bR)
                    myTank.setDir(Dir.RIGHT);
                if (bU)
                    myTank.setDir(Dir.UP);
                if (bD)
                    myTank.setDir(Dir.DOWN);

            }

        }
    }
}

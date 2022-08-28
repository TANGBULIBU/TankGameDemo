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


    int x = 200, y = 200;

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

        g.fillRect(x, y, 50, 50);

//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter{

        boolean bL=false;
        boolean bU=false;
        boolean bR=false;
        boolean bD=false;


        @Override
        public void keyPressed(KeyEvent e) {
           int key=e.getKeyCode();
           switch (key){
               case KeyEvent.VK_LEFT:
                   bL=true;
                   break;
               case KeyEvent.VK_RIGHT:
                   bR=true;
                   break;
               case KeyEvent.VK_UP:
                   bU=true;
                   break;
               case KeyEvent.VK_DOWN:
                   bD=true;
                   break;
               default:
                   break;
           }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

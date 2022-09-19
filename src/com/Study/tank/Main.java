package com.Study.tank;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));
        }

        while (true){
            Thread.sleep(60);//线程休眠
            tf.repaint();
        }
    }
}

package com.Study.tank;

/**
 * @author ¼¦ÍÈ×Ó
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        while (true){
            Thread.sleep(60);//Ïß³ÌÐÝÃß
            tf.repaint();
        }
    }
}

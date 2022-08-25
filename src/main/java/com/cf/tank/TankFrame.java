package com.cf.tank;

import com.cf.tank.facade.GameModel;
import com.cf.tank.factory.tank.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-11 08:08:12
 */
public class TankFrame extends Frame {
    public static int GAME_WIDTH = PropertyMgr.getInt("gameWidth"), GAME_HEIGHT = PropertyMgr.getInt("gameHeight");
    /** 这里可以通过配置文件，动态切换一套皮肤 **/
    public GameAbsFactory gf = new RectFactory();

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("cf tank");
        setVisible(true);

        // 1. 监听键盘事件
        addKeyListener(new MyKeyListener());
        // 2. 监听窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
//                super.windowClosing(e);
            }
        });

    }



    @Override
    public void paint(Graphics g) {
        GameModel.getInstance().paint(g);
    }


    /**
     * 双缓冲，解决闪烁问题
     * 原因：当一个画布中，画布不断刷新，频率较高,虽然较高，但是屏幕较大无法一次花完；
     * 而我们通过 fillRect 画图效率较低；两者由于色调差距较大，轮流交替绘制，结果就是闪烁。
     * （本质就是两者交替将绘制的图形复制到显存中，出现闪烁）
     * 解决方案：双缓冲，直接将需要绘制的图形先绘制在和画布一样大的内存对象（offScreenImage）中，
     * 然后一次拷贝到显存中，从而解决闪烁问题
     **/
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        // 1. 绘制屏幕
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        // 2. 将图像绘制到图片（内存对象）中（将图片的画笔传入 paint 方法）
        paint(gOffScreen);
        // 3. 将屏幕+图片一次写入画布
        g.drawImage(offScreenImage, 0, 0, null);
        // 4. update 在 paint 之前执行，update 里面执行 paint；我们重写后不会再次执行 paint
    }

    class MyKeyListener extends KeyAdapter {

        private Boolean dL = false;
        private Boolean dR = false;
        private Boolean dU = false;
        private Boolean dD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    dL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    dR = true;
                    break;
                case KeyEvent.VK_UP:
                    dU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    dD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    ((BaseTank)GameModel.getInstance().selfTank).fire();
                default:
                    break;
            }
            setTankDirection();
//            x = dL ? x - 10 : dR ? x + 10 : x;
//            y = dD ? y + 10 : dU ? y - 10 : y;
        }

        private void setTankDirection() {
            if (!dL && !dR && !dU && !dD) {
            } else {
                if (dL) {
                    ((Tank)GameModel.getInstance().selfTank).setDir(DirEnum.LEFT);
                }
                if (dR) {
                    ((Tank)GameModel.getInstance().selfTank).setDir(DirEnum.RIGHT);
                }
                if (dU) {
                    ((Tank)GameModel.getInstance().selfTank).setDir(DirEnum.UP);
                }
                if (dD) {
                    ((Tank)GameModel.getInstance().selfTank).setDir(DirEnum.DOWN);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    dL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    dR = false;
                    break;
                case KeyEvent.VK_UP:
                    dU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    dD = false;
                    break;
                default:
                    break;
            }
        }
    }
}

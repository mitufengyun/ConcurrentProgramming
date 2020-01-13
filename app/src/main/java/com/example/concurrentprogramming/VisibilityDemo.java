package com.example.concurrentprogramming;

/**
 * author: xpf
 * date: 2020/1/12 10:03
 * description: 变量可见性demo
 */
public class VisibilityDemo {

    // 状态标识
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (VisibilityDemo.flag) {
                    i++ ;
                }
                System.out.println(i);
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 设置flag为false, 使上面的线程结束while循环
        VisibilityDemo.flag = false;
        System.out.println("flag被置为false了");

    }
}

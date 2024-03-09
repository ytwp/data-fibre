package io.datafiber.fiber.test;

import io.datafiber.fiber.mysql.MysqlServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jiaxin
 * @Description : TODO
 * @date: 2024/3/8 14:20
 **/

public class ScheduledExecutorServiceTest {
    private static final Logger log = LogManager.getLogger(ScheduledExecutorServiceTest.class);
    public static void main(String[] args) {

        ScheduledExecutorService scheduler  = Executors.newScheduledThreadPool(5);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        scheduler.schedule(()->{
            /*log.info("开始执行...time {}", format.format(new Date()));*/
            try {
                System.out.println("开始执行...time"+format.format(new Date()));
                Thread.sleep(1000);
                System.out.println("结束执行...time"+format.format(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        },5, TimeUnit.SECONDS);

        System.out.println("初始化成功: "+format.format(new Date()));
    }




}

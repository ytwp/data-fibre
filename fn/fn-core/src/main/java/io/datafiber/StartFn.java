package io.datafiber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author jiaxin
 * @version 1.0
 * @description: TODO 启动 DataFiber的FN 组件主程序，加载环境配置以及启动MysqlServer的环境
 * @date 2024/3/7 23:09
 */
public class StartFn {
    private static final Logger LOG = LogManager.getLogger(StartFn.class);
    public static final String DATA_FIBER_HOME_DIR = System.getenv("DATA_FIBER_HOME");
    public static void main(String[] args) {
        System.out.println("Hello DataFiber!");

        //初始化DataFiber 环境









    }


}

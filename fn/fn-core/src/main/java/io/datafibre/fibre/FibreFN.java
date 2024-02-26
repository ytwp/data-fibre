package io.datafibre.fibre;

import io.datafibre.fibre.common.Config;
import io.datafibre.fibre.qe.QeService;
import io.datafibre.fibre.service.ExecuteEnv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FibreFN {

    private static final Logger LOG = LogManager.getLogger(FibreFN.class);

    public static final String STARROCKS_HOME_DIR = System.getenv("STARROCKS_HOME");

    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {

            QeService qeService = new QeService(
                    Config.query_port,
                    Config.mysql_service_nio_enabled,
                    ExecuteEnv.getInstance().getScheduler()
            );
            qeService.start();

            Thread.sleep(99999999);
        } catch (Throwable e) {
            LOG.error("FibreFN start failed", e);
            System.exit(-1);
        }

        System.exit(0);
    }
}
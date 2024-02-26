package io.datafibre.fibre;

import io.datafibre.fibre.qe.QeService;

public class FibreFN {

//    private static final Logger LOG = LogManager.getLogger(FibreFN.class);


    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {

            QeService qeService = new QeService(Config.query_port, Config.mysql_service_nio_enabled,
                    ExecuteEnv.getInstance().getScheduler());
            qeService.start();

        } catch (Throwable e) {
//            LOG.error("FibreFN start failed", e);
            System.exit(-1);
        }

        System.exit(0);
    }
}
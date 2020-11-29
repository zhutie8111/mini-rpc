package com.mini.rpc.registry;

public class RegistryFactory {

    private static volatile RegistryService registryService;

    public static RegistryService getInstance(String registryAddr, RegistryType type) throws Exception {

        if (null == registryService) {
            synchronized (RegistryFactory.class) {
                if (null == registryService) {
                    switch (type) {
                        case ZOOKEEPER:
                            registryService = new ZookeeperRegistryService();
                            break;
                        case EUREKA:
                            registryService = new EurekaRegistryService();
                            break;
                    }
                }
            }
        }
        return registryService;
    }
}


package org.mule.modules.azureblobservice.pooling;

import javax.annotation.Generated;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-28T06:31:11-07:00", comments = "Build UNNAMED.2613.77421cc")
public class DevkitGenericKeyedObjectPool
    extends GenericKeyedObjectPool
{

        public DevkitGenericKeyedObjectPool(org.apache.commons.pool.KeyedPoolableObjectFactory factory, org.mule.config.PoolingProfile connectionPoolingProfile) {
        super(factory,toConfig(connectionPoolingProfile));
    }

    private static org.apache.commons.pool.impl.GenericKeyedObjectPool.Config toConfig(org.mule.config.PoolingProfile connectionPoolingProfile) {
        org.apache.commons.pool.impl.GenericKeyedObjectPool.Config config = new org.apache.commons.pool.impl.GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
            config.timeBetweenEvictionRunsMillis = connectionPoolingProfile.getEvictionCheckIntervalMillis();
            config.minEvictableIdleTimeMillis = connectionPoolingProfile.getMinEvictionMillis();
        }
        return config;
    }
}

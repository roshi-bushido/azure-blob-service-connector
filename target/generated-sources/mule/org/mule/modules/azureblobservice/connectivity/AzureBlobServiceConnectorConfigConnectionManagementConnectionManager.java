
package org.mule.modules.azureblobservice.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.common.DefaultTestResult;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.api.lifecycle.LifeCycleManager;
import org.mule.devkit.api.lifecycle.MuleContextAwareManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionManager;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorAdapter;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectorFactory;
import org.mule.devkit.internal.connection.management.ConnectionManagementProcessTemplate;
import org.mule.devkit.internal.connection.management.UnableToAcquireConnectionException;
import org.mule.devkit.internal.connectivity.ConnectivityTestingErrorHandler;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.azureblobservice.AzureBlobServiceConnector;
import org.mule.modules.azureblobservice.adapters.AzureBlobServiceConnectorConnectionManagementAdapter;
import org.mule.modules.azureblobservice.config.ConnectorConfig;
import org.mule.modules.azureblobservice.pooling.DevkitGenericKeyedObjectPool;


/**
 * A {@code AzureBlobServiceConnectorConfigConnectionManagementConnectionManager} is a wrapper around {@link AzureBlobServiceConnector } that adds connection management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-28T06:31:11-07:00", comments = "Build UNNAMED.2613.77421cc")
public class AzureBlobServiceConnectorConfigConnectionManagementConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<AzureBlobServiceConnectorConnectionManagementAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManagementConnectionManager<ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey, AzureBlobServiceConnectorConnectionManagementAdapter, ConnectorConfig>
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Azure Blob Service";
    private final static String MODULE_VERSION = "1.0.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.7.1";
    private final static String DEVKIT_BUILD = "UNNAMED.2613.77421cc";
    private final static String MIN_MULE_VERSION = "3.5.0";

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new ConnectionManagementConnectorFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public AzureBlobServiceConnectorConnectionManagementAdapter acquireConnection(ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey key)
        throws Exception
    {
        return ((AzureBlobServiceConnectorConnectionManagementAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey key, AzureBlobServiceConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey key, AzureBlobServiceConnectorConnectionManagementAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, AzureBlobServiceConnectorConnectionManagementAdapter> getProcessTemplate() {
        return new ConnectionManagementProcessTemplate(this, muleContext);
    }

    @Override
    public ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey getDefaultConnectionKey() {
        return new ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey(getUsername(), getPassword());
    }

    @Override
    public ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("username").getGenericType(), null, getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method connect can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("password").getGenericType(), null, getPassword()));
            if (_transformedPassword == null) {
                throw new UnableToAcquireConnectionException("Parameter password in method connect can't be null because is not @Optional");
            }
            return new ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey(_transformedUsername, _transformedPassword);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    @Override
    public ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey getConnectionKey(MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return getEvaluatedConnectionKey(event);
    }

    @Override
    public ConnectionManagementConnectionAdapter newConnection() {
        ConnectorConfigAzureBlobServiceConnectorAdapter connection = new ConnectorConfigAzureBlobServiceConnectorAdapter();
        return connection;
    }

    @Override
    public ConnectionManagementConnectorAdapter newConnector(ConnectionManagementConnectionAdapter<ConnectorConfig, ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey> connection) {
        AzureBlobServiceConnectorConnectionManagementAdapter connector = new AzureBlobServiceConnectorConnectionManagementAdapter();
        connector.setConfig(connection.getStrategy());
        return connector;
    }

    public ConnectionManagementConnectionAdapter getConnectionAdapter(ConnectionManagementConnectorAdapter adapter) {
        AzureBlobServiceConnectorConnectionManagementAdapter connector = ((AzureBlobServiceConnectorConnectionManagementAdapter) adapter);
        ConnectionManagementConnectionAdapter strategy = ((ConnectionManagementConnectionAdapter) connector.getConfig());
        return strategy;
    }

    public TestResult test() {
        try {
            ConnectorConfigAzureBlobServiceConnectorAdapter strategy = ((ConnectorConfigAzureBlobServiceConnectorAdapter) newConnection());
            ConnectionManagementConnectorAdapter connectorAdapter = newConnector(strategy);
            MuleContextAwareManager.setMuleContext(connectorAdapter, this.muleContext);
            LifeCycleManager.executeInitialiseAndStart(connectorAdapter);
            strategy.test(getDefaultConnectionKey());
            return new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (Exception e) {
            return ((DefaultTestResult) ConnectivityTestingErrorHandler.buildFailureTestResult(e));
        }
    }

}

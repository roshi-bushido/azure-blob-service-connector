
package org.mule.modules.azureblobservice.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.TestableConnection;
import org.mule.modules.azureblobservice.config.ConnectorConfig;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-28T06:31:11-07:00", comments = "Build UNNAMED.2613.77421cc")
public class ConnectorConfigAzureBlobServiceConnectorAdapter
    extends ConnectorConfig
    implements ConnectionManagementConnectionAdapter<ConnectorConfig, ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey> , TestableConnection<ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword());
    }

    @Override
    public void test(ConnectionManagementConfigAzureBlobServiceConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionId();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public ConnectorConfig getStrategy() {
        return this;
    }

}

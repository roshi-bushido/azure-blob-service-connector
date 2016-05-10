package org.mule.modules.azureblobservice.config;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;

@ConnectionManagement(friendlyName = "Azure Configuration")
public class ConnectorConfig {
	private CloudBlobClient serviceClient;
	
    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, @Password String password) throws ConnectionException {
    	String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s", username, password);
        try {
            CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
            this.serviceClient = account.createCloudBlobClient();
		} catch (Exception e) {
			throw new ConnectionException(org.mule.api.ConnectionExceptionCode.INCORRECT_CREDENTIALS, connectionString, connectionString, e);
		}    	
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
    	this.serviceClient = null;
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return (this.serviceClient != null);
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "azure-blob-service-id-001";
    }

	public CloudBlobClient getServiceClient() {
		return serviceClient;
	}

}
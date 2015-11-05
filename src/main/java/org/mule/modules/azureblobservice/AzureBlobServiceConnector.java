package org.mule.modules.azureblobservice;

import java.io.InputStream;
import java.net.URISyntaxException;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.azureblobservice.config.ConnectorConfig;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

@Connector(name="azure-blob-service", friendlyName="Azure Blob Service")
public class AzureBlobServiceConnector {

    @Config
    ConnectorConfig config;

    /**
     * Custom processor
     *
     * {@sample.xml ../../../doc/azure-blob-service-connector.xml.sample azure-blog-service:downloadBlob}
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     * @throws StorageException 
     * @throws URISyntaxException 
     */
    @Processor
    public InputStream downloadBlob(String container, String fileName) throws Exception {
        CloudBlobContainer blobContainer = this.config.getServiceClient().getContainerReference(container);
        CloudBlockBlob blob = blobContainer.getBlockBlobReference(fileName);
        return blob.openInputStream();
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}
package org.mule.modules.azureblobservice;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.azureblobservice.config.ConnectorConfig;
import org.mule.util.IOUtils;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

@Connector(name = "azure-blob-service", friendlyName = "Azure Blob Service")
public class AzureBlobServiceConnector {

	@Config
	ConnectorConfig config;

	/**
	 * Custom processor
	 *
	 * {@sample.xml ../../../doc/azure-blob-service-connector.xml.sample
	 * azure-blog-service:downloadBlob}
	 *
	 * @param friend
	 *            Name to be used to generate a greeting message.
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

	/**
	 *
	 * {@sample.xml ../../../doc/azure-blob-service-connector.xml.sample
	 * azure-blog-service:downloadBlob}
	 *
	 * @param friend
	 *            Name to be used to generate a greeting message.
	 * @return A greeting message
	 * @throws StorageException
	 * @throws URISyntaxException
	 */
	@Processor
	public void uploadBlob(String container, String fileName, InputStream fileStream) throws Exception {
		BlobContainerPermissions containerPermissions = new BlobContainerPermissions();
		containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

		CloudBlobContainer blobContainer = this.config.getServiceClient().getContainerReference(container);
		blobContainer.createIfNotExists();
		blobContainer.uploadPermissions(containerPermissions);

		CloudBlockBlob blob = blobContainer.getBlockBlobReference(fileName);
		blob.uploadText(IOUtils.toString(fileStream, "UTF-8"));
	}

	/**
	 *
	 * {@sample.xml ../../../doc/azure-blob-service-connector.xml.sample
	 * azure-blog-service:downloadBlob}
	 *
	 * @param friend
	 *            Name to be used to generate a greeting message.
	 * @return A greeting message
	 * @throws StorageException
	 * @throws URISyntaxException
	 */
	@Processor
	public void uploadBlobFromPath(String container, String fileName, String path) throws Exception {
		BlobContainerPermissions containerPermissions = new BlobContainerPermissions();
		containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

		CloudBlobContainer blobContainer = this.config.getServiceClient().getContainerReference(container);
		blobContainer.createIfNotExists();
		blobContainer.uploadPermissions(containerPermissions);

		CloudBlockBlob blob = blobContainer.getBlockBlobReference(fileName);
		blob.uploadFromFile(path);
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}
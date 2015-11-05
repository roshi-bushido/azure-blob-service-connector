package org.mule.modules.azureblobservice.automation;

import org.junit.Before;
import org.mule.modules.azureblobservice.AzureBlobServiceConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

public abstract class AbstractTestCase {
	
	private AzureBlobServiceConnector connector;
	private ConnectorDispatcher<AzureBlobServiceConnector> dispatcher;
	
	
	protected AzureBlobServiceConnector getConnector() {
		return connector;
	}


	protected ConnectorDispatcher<AzureBlobServiceConnector> getDispatcher() {
		return dispatcher;
	}

	@Before
	public void init() throws Exception {
		
		//Initialization for single-test run
        ConnectorTestContext.initialize(AzureBlobServiceConnector.class, false);
		
		//Context instance
		ConnectorTestContext<AzureBlobServiceConnector> context = ConnectorTestContext.getInstance(AzureBlobServiceConnector.class);
		
		//Connector dispatcher
		dispatcher = context.getConnectorDispatcher();
		
		connector = dispatcher.createMockup();
		
	}

}


package org.mule.modules.azureblobservice.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.azureblobservice.AzureBlobServiceConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>AzureBlobServiceConnectorProcessAdapter</code> is a wrapper around {@link AzureBlobServiceConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-28T06:31:11-07:00", comments = "Build UNNAMED.2613.77421cc")
public class AzureBlobServiceConnectorProcessAdapter
    extends AzureBlobServiceConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<AzureBlobServiceConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, AzureBlobServiceConnectorCapabilitiesAdapter> getProcessTemplate() {
        final AzureBlobServiceConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,AzureBlobServiceConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, AzureBlobServiceConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, AzureBlobServiceConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}

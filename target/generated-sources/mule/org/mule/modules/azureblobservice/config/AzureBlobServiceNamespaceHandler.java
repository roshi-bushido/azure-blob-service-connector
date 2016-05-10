
package org.mule.modules.azureblobservice.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/azure-blob-service</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2016-05-09T07:18:00-03:00", comments = "Build UNNAMED.2613.77421cc")
public class AzureBlobServiceNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(AzureBlobServiceNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [azure-blob-service] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [azure-blob-service] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new AzureBlobServiceConnectorConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("download-blob", new DownloadBlobDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("download-blob", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upload-blob", new UploadBlobDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upload-blob", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upload-blob-from-path", new UploadBlobFromPathDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upload-blob-from-path", "@Processor", ex);
        }
    }

}

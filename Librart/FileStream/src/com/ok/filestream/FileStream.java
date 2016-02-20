package com.ok.filestream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.BodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class FileStream {
	private FileStreamListener listener;
	public FileStream(FileStreamListener listener)
	{
		this.setListener(listener);
	}
	public FileStreamListener getListener() {
		return listener;
	}
	public void setListener(FileStreamListener listener) {
		this.listener = listener;
	}
	public void sendData(FileStreamItem fileStreamItem)
	{
		runSendThread(fileStreamItem);
	}
	private void runSendThread(FileStreamItem fileStreamItem)
	{
		final FileStreamItem fsItem=fileStreamItem;
        new Thread(){
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
                final ClientConfig config = new DefaultClientConfig();
                final Client client = Client.create(config);

                final WebResource resource = client.resource(fsItem.getRestUri()).path(fsItem.getRestMethod());

                final File fileToUpload = new File(fsItem.getFileLocation());

                final FormDataMultiPart multiPart = new FormDataMultiPart();
                if (fileToUpload != null) {

                    multiPart.bodyPart(new FileDataBodyPart(fsItem.getRestStreamName(), fileToUpload,
                            MediaType.APPLICATION_OCTET_STREAM_TYPE));
                    //get All BodyPart list add 
                    List<BodyPart> bodyList=fsItem.getBodyList();
                	for (BodyPart body :bodyList ) {
                		  multiPart.bodyPart(body);
        			}
                }
        		ClientResponse clientResp = (ClientResponse) resource.type(
                MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
                multiPart);
        		listener.responseMessage(clientResp.getClientResponseStatus());
        		client.destroy();
        	}
        }.start();;
	}
}

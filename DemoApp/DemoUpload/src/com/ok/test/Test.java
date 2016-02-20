package com.ok.test;

import java.net.URI;
import java.net.URISyntaxException;

import com.ok.filestream.FileStream;
import com.ok.filestream.FileStreamItem;
import com.ok.filestream.FileStreamListener;
import com.sun.jersey.api.client.ClientResponse.Status;

public class Test implements FileStreamListener{
		private FileStream fileStream;
		private FileStreamItem fileStreamItem;
		public void start() {

			try {
			fileStreamItem=new FileStreamItem(
					new URI("http://localhost:8080/JAXRS-FileUpload/rest/files/"), 
					"D:/Record.wav", "file", "upload");

			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileStream=new FileStream(this);
			fileStream.sendData(fileStreamItem);
		}
		public void responseMessage(Status status) {
			// TODO Auto-generated method stub
			System.out.println("Status:"+status.toString());
		}

	
}

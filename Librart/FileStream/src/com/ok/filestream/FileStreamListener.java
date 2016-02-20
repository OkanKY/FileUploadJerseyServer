package com.ok.filestream;

import com.sun.jersey.api.client.ClientResponse.Status;

public interface FileStreamListener {
	public void responseMessage(Status status);
}

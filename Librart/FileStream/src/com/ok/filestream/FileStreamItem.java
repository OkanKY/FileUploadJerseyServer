package com.ok.filestream;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.multipart.BodyPart;
public class FileStreamItem {
	private URI restUri;
	private String fileLocation;
	private String restStreamName;
	private String restMethod;
	private List<BodyPart> bodyList;

	public FileStreamItem(URI restUri,String fileLocation
			,String restStreamName,String restMethod)
	{
		this.restUri=restUri;
		this.fileLocation=fileLocation;
		this.restStreamName=restStreamName;
		this.restMethod=restMethod;
		this.bodyList=new ArrayList<BodyPart>();
	}
	public List<BodyPart> getBodyList() {
		return bodyList;
	}
	public void setBodyList(ArrayList<BodyPart> bodyList) {
		this.bodyList = bodyList;
	}
	public void addBody(BodyPart bodyPart)
	{
		bodyList.add(bodyPart);
	}
	public void removeBody(Integer index)
	{
		bodyList.remove(index);
	}
	public URI getRestUri() {
		return restUri;
	}

	public void setRestUri(URI uri) {
		this.restUri = uri;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getRestStreamName() {
		return restStreamName;
	}

	public void setRestStreamName(String restStreamName) {
		this.restStreamName = restStreamName;
	}

	public String getRestMethod() {
		return restMethod;
	}

	public void setRestMethod(String restMethod) {
		this.restMethod = restMethod;
	}
}

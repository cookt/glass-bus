/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.brain_power.glassbus.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Named;
import javax.xml.bind.DatatypeConverter;
import com.google.appengine.api.users.User;

/**
 * An endpoint class we are exposing
 */
@Api(name = "glassBus", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.glassbus.brain_power.com", ownerName = "backend.glassbus.brain_power.com", packagePath = ""))
public class MyEndpoint {
	private static final int ONE_MEGABYTE=1024*1024;
	/**
	 * A simple endpoint method that takes a name and says Hi back
	 */
	@ApiMethod(name = "sayHi")
	public DataBean sayHi(@Named("name") String name)
	{
		DataBean response = new DataBean();
		response.setData("Hi, " + name);

		return response;
	}

	@ApiMethod(name="getImage", path="get_image",httpMethod = ApiMethod.HttpMethod.GET)
	public GetResponse getImage(@Named("filename") String filename)
	{
		String encodedString="";
		GetResponse result=new GetResponse();
		try{
			File input=new File("assets/"+filename);
			InputStream inputStream=new FileInputStream(input);
			byte[] bytes;
			byte[] buffer=new byte[ONE_MEGABYTE];
			int bytesRead;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bytes = output.toByteArray();
			encodedString = DatatypeConverter.printBase64Binary(bytes);
			result.setMessageHeader("SUCCESS");
		} catch(Exception e){
			e.printStackTrace();
			result.setMessageHeader(e.getMessage());
		}

		result.setEncodedImageString(encodedString);
		return result;
	}


	@ApiMethod(name="getImageSecure",path="get_image_secure", httpMethod = ApiMethod.HttpMethod.GET)
	public GetResponse getImageSecure(@Named("filename")String filename, User user){

		return null;
	}


	@ApiMethod(name="getUserAccountStatus", path="get_user")
	public GetResponse getUserAccountInfo(@Named("email") String email)
	{
		DatastoreService datastore= DatastoreServiceFactory.getDatastoreService();


		return null;
	}

	@ApiMethod (name="getAvailableMedia",path="get_available_media")
	public GetResponse getAvailableMedia()
	{


		return null;
	}


	@ApiMethod (name="sendData", path="send_data",httpMethod = ApiMethod.HttpMethod.POST)
	public PostResponse sendData(DataBean dataBean)
	{
		DatastoreService datastore= DatastoreServiceFactory.getDatastoreService();



		return new PostResponse();
	}

}

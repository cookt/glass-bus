package com.brain_power.glassbus.models;


import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Thomas on 7/21/2015.
 */
public class GlassState {

	private List<String> dataFiles;

	public Date lastSync;

	private List<String>  mediaFiles;

	public GlassState(){

	}

	public List<String> getDataFiles() {

		return dataFiles;
	}

	public void setDataFiles(List<String> dataFiles) {
		this.dataFiles = dataFiles;
	}

	public Date getLastSync() {
		return lastSync;
	}

	public void setLastSync(Date lastSync) {
		this.lastSync = lastSync;
	}

	public List<String> getMediaFiles() {
		return mediaFiles;
	}

	public void setMediaFiles(List<String> mediaFiles) {
		this.mediaFiles = mediaFiles;
	}

	public void addMediaFile(String fileName){
		mediaFiles.add(fileName);
	}
}
package org.spoutcraft.launcher.technic.rest;

import org.codehaus.jackson.annotate.JsonProperty;

public class RestNews extends RestObject {

	@JsonProperty("id")
	private int id;
	@JsonProperty("message")
	private String message;
	@JsonProperty("title")
	private String title;
	@JsonProperty("views")
	private int views;
	@JsonProperty("replies")
	private int replies;
	@JsonProperty("lastpostid")
	private int lastPostId;
	@JsonProperty("time")
	private long time;

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public long getTime() {
		return time;
	}

	public String getTitle() {
		return title;
	}

	public int getLastPostId() {
		return lastPostId;
	}

	public int getReplies() {
		return replies;
	}

	public int getViews() {
		return views;
	}

	@Override
	public String toString() {
		return "{" + "\"id\":" + id + ",\"message\":" + message + ",\"title\":" + title + ",\"views\":" + views + ",\"replies\":" + replies + ",\"lastpostid\":" + lastPostId + ",\"time\":" + time;
	}
}

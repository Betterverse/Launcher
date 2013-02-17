/*
 * This file is part of Betterverse Launcher.
 *
 * Copyright (c) 2013, Betterverse <http://www.betterverse.net//>
 * Betterverse Launcher is licensed under the Spout License Version 1.
 *
 * Betterverse Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Betterverse Launcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.launcher.technic.rest;

import javax.swing.JTextArea;
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

	public void updateNewsPane(JTextArea news) {
		String newMessage = message.replaceAll("\\[([A-Za-z0-9\\/=:.?&-]+)]", "");
		news.setText(newMessage);
//		news.repaint();
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

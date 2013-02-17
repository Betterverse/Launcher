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

import org.spoutcraft.launcher.exceptions.RestfulAPIException;

public class Mod {
	private final String name;
	private final String version;
	private final String url;

	private RestAPI rest = null;

	public Mod(String name, String version, String downloadUrl) {
		this.name = name;
		this.version = version;
		this.url = downloadUrl;
	}

	public Mod(String name, String version, RestAPI rest) {
		this(name, version, rest.getModDownloadURL(name, version));
		this.rest = rest;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public String getURL() {
		return url;
	}

	public String getMD5() {
		if (rest != null) {
			try {
				return rest.getModMD5(name, version);
			} catch (RestfulAPIException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "{ Mod [name: " + name + ", version: " + version + "] }";
	}
}

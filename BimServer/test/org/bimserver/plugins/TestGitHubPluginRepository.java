package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class TestGitHubPluginRepository {
	@Test
	public void test() {
		MavenPluginRepository mavenPluginRepository = new MavenPluginRepository(Paths.get("maven"), "https://repo1.maven.org/maven2", null);
		GitHubPluginRepository gitHubPluginRepository = new GitHubPluginRepository(mavenPluginRepository, "opensourceBIM", "BIMserver-Repository");
		
		List<PluginLocation<?>> pluginLocations = gitHubPluginRepository.listPluginLocations();
		for (PluginLocation<?> pluginLocation : pluginLocations) {
			System.out.println(pluginLocation);
			for (PluginVersion pluginVersion : pluginLocation.getAllVersions()) {
				System.out.println(pluginVersion);
			}
		}
	}
}

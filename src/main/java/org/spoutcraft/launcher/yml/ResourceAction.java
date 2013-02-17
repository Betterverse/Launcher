package org.spoutcraft.launcher.yml;


public interface ResourceAction {
	public void beforeAction(YAMLProcessor previous);
	public void afterAction(YAMLProcessor current);
}

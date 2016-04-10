package com.store.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestActivator extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RestActivator() {
		singletons.add(new RestServices());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}


}

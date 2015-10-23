package com.celad.rental.ui;

import javax.inject.Inject;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RentalUIActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		RentalUIActivator.context = bundleContext;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		RentalUIActivator.context = null;
	}

}

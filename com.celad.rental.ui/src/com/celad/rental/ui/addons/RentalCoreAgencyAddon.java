package com.celad.rental.ui.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.core.helpers.RentalAgencyGenerator;

public class RentalCoreAgencyAddon implements RentalUIConstants {
	// private static RentalAgency agency =
	// RentalAgencyGenerator.createSampleAgency();

	@PostConstruct
	public void init(IEclipseContext context) {
		// Collections<RentalAgency> RentalAgencyCollection = new
		// Collections<RentalAgency>();
		context.set(RentalAgency.class, RentalAgencyGenerator.createSampleAgency());
		// RentalAgency agency = RentalAgencyGenerator.createSampleAgency();
		context.set(RENTAL_UI_REGISTRY, getLocalImageRegistry());
		context.set(IPreferenceStore.class, new ScopedPreferenceStore(InstanceScope.INSTANCE, "com.celad.rental.ui"));
	}

	@Inject
	public void getExtension(IExtensionRegistry reg) {
		IExtensionPoint extp = reg.getExtensionPoint("org.eclipse.core.runtime.adapters");
		IExtension[] extensions = extp.getExtensions();
		for (IExtension ext : extensions) {
			for (IConfigurationElement elt : ext.getConfigurationElements()) {
				String attValue = elt.getAttribute("class");
				System.out.println("Adapter :" + elt.getNamespaceIdentifier() + " Class:" + attValue);
			}
		}
	}

	ImageRegistry getLocalImageRegistry() {
		Bundle b = FrameworkUtil.getBundle(getClass());
		ImageRegistry reg = new ImageRegistry();
		reg.put(IMG_CUSTOMER, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMER)));
		reg.put(IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCY)));
		reg.put(IMG_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECT)));
		reg.put(IMG_RENTAL, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL)));
		return reg;
	}

}

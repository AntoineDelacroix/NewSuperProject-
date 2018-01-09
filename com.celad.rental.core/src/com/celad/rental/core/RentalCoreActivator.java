package com.celad.rental.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.helpers.RentalAgencyGenerator;


public class RentalCoreActivator implements BundleActivator {

	private static RentalAgency agency = RentalAgencyGenerator.createSampleAgency();

	public static RentalAgency getAgency() {
		return agency;
	}
 
	public static void setAgency(RentalAgency agency) {
		RentalCoreActivator.agency = agency;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}

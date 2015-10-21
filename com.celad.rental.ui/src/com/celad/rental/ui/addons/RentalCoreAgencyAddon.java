package com.celad.rental.ui.addons;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;

import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.core.helpers.RentalAgencyGenerator;

public class RentalCoreAgencyAddon {
	//private static RentalAgency agency = RentalAgencyGenerator.createSampleAgency();
	
	@PostConstruct
	public void init(IEclipseContext context) {
		//Collections<RentalAgency> RentalAgencyCollection = new Collections<RentalAgency>();
		context.set(RentalAgency.class, RentalAgencyGenerator.createSampleAgency());
		//RentalAgency agency = RentalAgencyGenerator.createSampleAgency();
	}
}

package com.celad.rental.ui.views;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyViewerPart {
	
	@PostConstruct
	public void createPartControl(Composite parent, RentalAgency agency) {
		TreeViewer tv = new TreeViewer(parent);
		tv.setContentProvider(new RentalAgencyTreeProvider());
		tv.setLabelProvider(new RentalAgencyLabelProvider());
		tv.setInput(Collections.singletonList(agency));
	}
};
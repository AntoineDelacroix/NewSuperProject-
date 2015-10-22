package com.celad.rental.ui.views;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyViewerPart {
	public TreeViewer tv;

	@Inject
	private ESelectionService selectionService;

	private void provideSelection() {
		tv.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				selectionService.setSelection(sel.size() == 1 ? sel.getFirstElement() : sel.toArray());

			}
		});
	}

	@Inject
	UISynchronize sync;
	Job job = new Job("My Job") {
		@Override
		protected IStatus run(IProgressMonitor monitor) {
			// do something long running
			// ...

			// If you want to update the UI
			sync.asyncExec(new Runnable() {
				public void run() {
					tv.refresh();
				}
			});
			return Status.OK_STATUS;
		}
	};

	@Inject
	IEclipseContext context;

	@PostConstruct
	public void createPartControl(Composite parent, RentalAgency agency) {
		tv = new TreeViewer(parent);
		tv.setContentProvider(new RentalAgencyTreeProvider());
		tv.setLabelProvider(ContextInjectionFactory.make(RentalAgencyLabelProvider.class, context));
		tv.setInput(Collections.singletonList(agency));
		provideSelection();
	}
};
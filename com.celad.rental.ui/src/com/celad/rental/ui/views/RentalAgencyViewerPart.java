package com.celad.rental.ui.views;

import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.celad.rental.ui.addons.RentalUIConstants;
import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyViewerPart implements RentalUIConstants {
	public TreeViewer tv;
	public Timer t;

	public void start() {
		t = new Timer();
		t.schedule(task, 200, 1000);
	}

	@Inject
	UISynchronize sync;
	private final TimerTask task = new TimerTask() {
		@Override
		public void run() {
			sync.asyncExec(new Runnable() {
				public void run() {

					tv.refresh();
					System.out.println("refresh");
				}
			});
		}
	};

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

	/*
	 * @Inject UISynchronize sync; Job job = new Job("My Job") {
	 * 
	 * @Override protected IStatus run(IProgressMonitor monitor) { // do
	 * something long running // ...
	 * 
	 * // If you want to update the UI sync.asyncExec(new Runnable() { public
	 * void run() { tv.refresh(); } }); return Status.OK_STATUS; } };
	 */

	@Inject
	IEclipseContext context;

	@PostConstruct
	public void createPartControl(Composite parent, RentalAgency agency, EMenuService menuService) {
		tv = new TreeViewer(parent);
		tv.setContentProvider(new RentalAgencyTreeProvider());
		tv.setLabelProvider(ContextInjectionFactory.make(RentalAgencyLabelProvider.class, context));
		tv.setInput(Collections.singletonList(agency));
		provideSelection();
		menuService.registerContextMenu(tv.getControl(), "com.celad.rental.eap1.popupmenu.amenu");
		// start();
	}

	@Inject
	public void refreshTree(@Preference(value = PREF_CUSTOMER_COLOR) String custColor, @Preference(value = PREF_OBJECT_COLOR) String objectColor) {
		if (tv != null && !tv.getTree().isDisposed()) {
			tv.refresh();
		}
	}
};

package com.celad.rental.eap1.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

public class MessageHandler {

	@Execute
	public void execute(@Named("com.celad.rental.eap1.parameter.title") String title,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		System.out.println("Message:" + title);
	}

	@CanExecute
	public boolean canExecute() {
		return true;
	}
}

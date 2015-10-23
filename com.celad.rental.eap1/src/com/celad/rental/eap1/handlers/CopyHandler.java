package com.celad.rental.eap1.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.impl.CustomerImpl;

public class CopyHandler {
	@Execute
	public void execute(Display display, @Named(IServiceConstants.ACTIVE_SELECTION) Object customer) {
		CustomerImpl customerSelected = (CustomerImpl) customer;
		System.out.println("Client : First name :" + customerSelected.getFirstName() + " | Last Name : "
				+ customerSelected.getLastName());
		Clipboard clipboard = new Clipboard(display);
		String textData = customer.toString();
		
		String rtfData = "{\\rtf1\\b\\i Hello World}";
		TextTransfer textTransfer = TextTransfer.getInstance();
		RTFTransfer rtfTransfer = RTFTransfer.getInstance();
		Transfer[] transfers = new Transfer[] { textTransfer, rtfTransfer };
		Object[] data = new Object[] { textData, rtfData };
		clipboard.setContents(data, transfers);
		clipboard.dispose();
	}
}

package com.celad.rental.ui.views;

import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.celad.rental.ui.addons.RentalUIConstants;
import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyLabelProvider extends LabelProvider
		implements IColorProvider, IFontProvider, RentalUIConstants {
	private static final String ColorRegistry = null;

	
    
	@Inject
	@Named(RENTAL_UI_REGISTRY)
	private ImageRegistry registry;

	public Image getImage(Object element) {
		/*
		 * String path = "icons/Agency.png";
		 * 
		 * Bundle bundle = Platform.getBundle("com.celad.rental.ui");
		 * 
		 * URL url = FileLocator.find(bundle, new Path(path), null);
		 * 
		 * ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
		 * 
		 * Image image = imageDesc.createImage();
		 */
		// Image image = null;
		// if(element instanceof Customer){
		// int length = element.getClass().getSimpleName().length();

		// image =
		// registry.get("icons/"+element.getClass().getSimpleName().substring(0,
		// length-4)+".png");//IMG_CUSTOMER);

		// System.out.println("icons/"+element.getClass().getSimpleName().substring(0,
		// length-4)+".png");
		// System.out.println(element.getClass().getSimpleName());
		// }
		
		Image image = null;
		if (element instanceof Customer) {
			image = registry.get(IMG_CUSTOMER);
		} else {
			image = registry.get(IMG_OBJECT);
		}
		return image;
	}

	public String getText(Object element) {
		if (element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		} else {
			return super.getText(element);
		}
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub

		return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
	}

	@Override
	public Font getFont(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
}

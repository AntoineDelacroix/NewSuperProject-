package com.celad.rental.ui.views;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyLabelProvider extends LabelProvider {
	public Image getImage(Object element){
		String path = "icons/Agency.png";

		Bundle bundle = Platform.getBundle("com.celad.rental.ui");

		URL url = FileLocator.find(bundle, new Path(path), null);

		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);

		Image image = imageDesc.createImage();
		return image;
	}

	public String getText(Object element) {
		if(element instanceof RentalAgency){
			return ((RentalAgency)element).getName();
		}else{
			return super.getText(element);
		}
	}
}

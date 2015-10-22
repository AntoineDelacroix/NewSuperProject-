package com.celad.rental.ui.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;

import com.celad.rental.ui.addons.RentalUIConstants;

public class ColorPrefPage extends FieldEditorPreferencePage implements RentalUIConstants{

	public ColorPrefPage() {
		// TODO Auto-generated constructor stub
		super(GRID);
	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		addField(new ColorFieldEditor(PREF_CUSTOMER_COLOR, "Customer : ", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_RENTAL_COLOR, "Rental : ", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_OBJECT_COLOR, "Object : ", getFieldEditorParent()));
	}

}

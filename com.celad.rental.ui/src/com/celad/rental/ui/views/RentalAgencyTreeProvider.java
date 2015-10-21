package com.celad.rental.ui.views;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.opcoach.training.rental.RentalAgency;

public class RentalAgencyTreeProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		Object[] results = null;
		if (inputElement instanceof List<?>) {
			results = ((List<?>) inputElement).toArray();
		}
		return results;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		Object[] results = null;
		/*if (parentElement instanceof RentalAgency) {
			// results = ((RentalAgency)
			// parentElement).getCustomers().toArray();
			RentalAgency a = (RentalAgency) parentElement;
			return new Node[] { new Node(Node.NODE_CLIENTS, a), new Node(Node.NODE_LOCATION, a),
					new Node(Node.NODE_OBJECTS, a) };
		} else if (parentElement instanceof Node) {
			results = ((Node) parentElement).getChildren();
			// results = ((EObject) parentElement).eContents().toArray();
		} else{*/
			results = ((EObject) parentElement).eContents().toArray();
			//			results = ((EObject) parentElement).eGet(RentalPackage.Literals.RENTAL_AGENCY__CUSTOMERS);

		//}
		
		//create a class
		/*try {
			Class clazz = Class.forName("com.celad.rental.ui.RentalUIActivator");
			clazz.newInstance();
			//get bundle
			//get location
			//new
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return results;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		return true;
	}

	class Node {
		public static final String NODE_OBJECTS = "Objects";
		public static final String NODE_LOCATION = "Location";
		public static final String NODE_CLIENTS = "Clients";
		private String label;
		private RentalAgency agency;

		public Node(String label, RentalAgency agency) {
			super();
			this.label = label;
			this.agency = agency;
		}

		public Object[] getChildren() {
			if (label == NODE_CLIENTS) {
				return agency.getCustomers().toArray();
			} else if (label == NODE_LOCATION) {
				return agency.getRentals().toArray();
			} else if (label == NODE_OBJECTS) {
				return agency.getObjectsToRent().toArray();
			}
			return null;
		}
	}
}

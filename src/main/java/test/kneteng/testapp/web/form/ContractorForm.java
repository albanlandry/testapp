package test.kneteng.testapp.web.form;

import java.util.ArrayList;
import java.util.List;

import test.kneteng.testapp.domain.Contractor;
import test.kneteng.testapp.domain.Manager;

public class ContractorForm {
	/**
	 * Add as much managers as specified in managerNumber to c
	 * @param c contractor
	 * @param managerNumber number of manager to add to the contractor
	 * @return Contractor c
	 * */
	public static Contractor addEmptyManager(Contractor contractor, int managerNumber) {
		List<Manager> managers= contractor.getManagers();
		
		if(managers == null) 
			managers = new ArrayList<Manager>();
		
		for(int i = 0; i < managerNumber; i++) {
			managers.add(new Manager());
		}
		
		contractor.setManagers(managers);
		
		return contractor;
	}
}

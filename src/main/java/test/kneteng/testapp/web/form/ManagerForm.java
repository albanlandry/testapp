package test.kneteng.testapp.web.form;

import test.kneteng.testapp.domain.Manager;

public class ManagerForm {
	public boolean isEmpty(Manager m) {
		return  (m.getTel() == null || m.getTel().isEmpty())
				&& (m.getName() == null || m.getName().isEmpty())
				&& (m.getDepartment() == null || m.getDepartment().isEmpty());
	} 
}

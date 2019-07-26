import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.EmployeeDAO;
import com.revature.daoimp.EmployeeDAOImp;

public class EmployeeDAOTest {

	EmployeeDAO edao = new EmployeeDAOImp();
	
//	@Test(expected = Test.None.class)
//	public void ProperIDCausesNoIssue() {
//		int id = 1;
//		try {
//			edao.getEmployeeInfo(id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void CheckIfEmployeeIsAlsoManager() {
		int id = 1;
		try {
			assertTrue(edao.isManager(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package JavaBean.DAO;

import JavaBean.DBC.DatabaseConnection;
import JavaBean.VO.Application;
import JavaBean.VO.Checkifo;
import JavaBean.VO.Student;
import JavaBean.VO.Teacher;

import java.util.ArrayList;
import java.util.List;


public class DAOProxy implements IDAO {
	private DatabaseConnection dbc = null;
	private IDAO dao = null;

	public DAOProxy() {
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dao = new DAOImpl(dbc.getConnection());
	}

	@Override
	public boolean findLogin(Student s) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(s);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean findLogin(Teacher t) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(t);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public Student findstudent(String id) throws Exception {
		Student s;
		try {
			s = this.dao.findstudent(id);
		} catch (Exception e) {
			throw e;
		}
		return s;
	}

	@Override
	public Teacher findteacher(String id) throws Exception {
		Teacher t;
		try {
			t = this.dao.findteacher(id);
		} catch (Exception e) {
			throw e;
		}
		return t;
	}

	@Override
	public boolean addcheck(Checkifo c) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.addcheck(c);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean addapplication(Application a) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.addapplication(a);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public List<Application> application(String id) throws Exception {
		List<Application> list = new ArrayList<>();
		try {
			list = this.dao.application(id);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public boolean agree(String id, String date,String status) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.agree(id, date,status);
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public List<Student> checkinfo(String id) throws Exception {
		List<Student> list = new ArrayList<>();
		try {
			list=this.dao.checkinfo(id);
		}catch (Exception e){
			throw e;
		}
		return list;
	}


}
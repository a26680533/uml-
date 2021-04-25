package JavaBean.DAO;

import JavaBean.VO.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
public class DAOImpl implements IDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;

	public DAOImpl(Connection conn) {
		this.conn = conn;
	}


	@Override
	public boolean findLogin(Student s) throws Exception {
		boolean flag = false;
		String sql = "select * from student where s_id=? and s_pwd=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, s.getId());
		this.ps.setString(2, s.getPwd());
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			flag = true;
		this.ps.close();
		return flag;
	}

	@Override
	public boolean findLogin(Teacher t) throws Exception {
		boolean flag = false;
		String sql = "select * from teacher where t_id=? and t_pwd=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, t.getId());
		this.ps.setString(2, t.getPwd());
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			flag = true;
		this.ps.close();
		return flag;
	}

	@Override
	public Student findstudent(String id) throws Exception {
		String sql = "select * from student where s_id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Student s = new Student();
			s.setId(rs.getString("s_id"));
			s.setName(rs.getString("s_name"));
			s.setTid(rs.getString("t_id"));
			s.setTname(rs.getString("t_name"));
			return s;
		} else
			return null;
	}

	@Override
	public Teacher findteacher(String id) throws Exception {
		String sql = "select * from teacher where t_id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Teacher t = new Teacher();
			t.setId(rs.getString("T_id"));
			t.setPwd(rs.getString("T_pwd"));
			t.setName(rs.getString("T_name"));
			return t;
		} else
			return null;
	}

	@Override
	public boolean addcheck(Checkifo c) throws Exception {
		String sql = "insert into checkifo values(?,?,?,?,?)";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		ps.setString(1, c.getSid());
		ps.setString(2, c.getSname());
		ps.setString(3, c.getDate());
		ps.setString(4, c.getHealthy());
		ps.setString(5, c.getAddress());

		int count = ps.executeUpdate();
		if (count >= 1) {
			flag = true;
		}
		return flag;

	}

	@Override
	public boolean addapplication(Application a) throws Exception {
		String sql = "insert into application (s_id,s_name,a_date,t_id,t_name,a_reason)values(?,?,?,?,?,?)";
		boolean flag = false;
		this.ps = this.conn.prepareStatement(sql);
		ps.setString(1, a.getSid());
		ps.setString(2, a.getSname());
		ps.setString(3, a.getDate());
		ps.setString(4, a.getTid());
		ps.setString(5, a.getTname());
		ps.setString(6, a.getReason());

		int count = ps.executeUpdate();
		if (count >= 1) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Application> application(String id) throws Exception {
		List<Application> list = new ArrayList<>();
		String sql = "select * from application where t_id=? and isnull(a_status)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Application a = new Application();
			a.setSid(rs.getString("s_id"));
			a.setSname(rs.getString("s_name"));
			a.setDate(rs.getString("a_date"));
			a.setReason(rs.getString("a_reason"));

			list.add(a);
		}
		return list;
	}

	@Override
	public boolean agree(String id, String date,String status) throws Exception {
		boolean flag = false;
		String sql = "update application set a_status=? where s_id=? and a_date=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		ps.setString(2, id);
		ps.setString(3, date);
		int count = ps.executeUpdate();
		if (count >= 1) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Student> checkinfo(String id) throws Exception {
		List<Student> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = sdf.format(new Date());
		String sql ="select * from student left outer join (select * from checkifo where c_date=?) " +
				"as a on student.s_id=a.s_id where ISNULL(c_date) and t_id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, dateNow);
		this.ps.setString(2, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getString("s_id"));
			s.setName(rs.getString("s_name"));
			list.add(s);
		}
		return list;

	}

}
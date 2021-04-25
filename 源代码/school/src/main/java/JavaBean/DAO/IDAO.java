package JavaBean.DAO;
import java.util.List;

import JavaBean.VO.*;

public interface IDAO {
    public boolean findLogin(Student s) throws Exception ;
    public boolean findLogin(Teacher t) throws Exception ;
    public Student findstudent(String no) throws Exception;
    public Teacher findteacher(String no) throws Exception;
    public boolean addcheck(Checkifo c) throws Exception;
    public boolean addapplication(Application a) throws Exception;
    public List<Application> application(String id)throws Exception;
    public boolean agree(String id,String date,String status) throws Exception;
    public  List<Student> checkinfo(String id) throws Exception;


    
 
} 
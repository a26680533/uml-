package JavaBean.DAO;

import JavaBean.DAO.DAOProxy;
import JavaBean.DAO.IDAO;

public class DAOFactory {
	public static IDAO getIDAOInstance(){
		return new DAOProxy() ;
	}
}
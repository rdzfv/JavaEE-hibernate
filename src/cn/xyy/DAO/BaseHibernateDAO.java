package cn.xyy.DAO;

import org.hibernate.Session;

public class BaseHibernateDAO {
    public Session getSession() {
        return HibernateUtil.getSession();
    }
}

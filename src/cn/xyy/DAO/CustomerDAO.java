package cn.xyy.DAO;

import java.util.List;

import cn.xyy.po.CustomerEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CustomerDAO extends BaseHibernateDAO {
    private Log log = LogFactory.getLog(CustomerDAO.class);

    public List findByHql(String hql) {
        log.debug("finding Customer instance by hql");
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }

    public void save(CustomerEntity instance) {
        log.debug("saving Customer instance");
        Transaction transaction = getSession().beginTransaction();
        try {
            getSession().save(instance);
            System.out.println("保存成功");
            log.debug("save successful");
        } catch (RuntimeException re) {
            System.out.println("保存失败");
            log.error("save failed", re);
            throw re;
        }
        transaction.commit();
//        getSession().flush();
        getSession().close();
    }

    public void update(CustomerEntity instance) {
        log.debug("updating Customer instance");
        try {
            getSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void delete(CustomerEntity instance) {
        log.debug("deleting Customer instance");
        try {
            getSession().delete(instance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
}

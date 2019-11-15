package cn.xyy.DAO;

import cn.xyy.po.AddressEntity;
import cn.xyy.po.CustomerEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDAO extends BaseHibernateDAO {
    private Log log = LogFactory.getLog(AddressDAO.class);

    public AddressEntity findById(int id) {
        String queryString = "from AddressEntity as address where addressId='" + id + "'";
        Query queryObject = getSession().createQuery(queryString);
        return (AddressEntity) queryObject.list().get(0);
    }

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

    public void save(AddressEntity instance) {
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

    public void update(AddressEntity instance) {
        log.debug("updating Customer instance");
        try {
            getSession().update(instance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void delete(AddressEntity instance) {
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

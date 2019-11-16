package cn.xyy.Service;

//import cn.xyy.HelloStructs2.UserBean;

import cn.xyy.DAO.AddressDAO;
import cn.xyy.DAO.CustomerDAO;
import cn.xyy.po.AddressEntity;
import cn.xyy.po.CustomerEntity;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Transaction;


public class UserService {
    private Map<String, Object> request, session;

    public boolean delAddr(CustomerEntity loginUser, AddressEntity address) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        CustomerDAO c_dao = new CustomerDAO();
        AddressDAO a_dao = new AddressDAO();
        loginUser = c_dao.findById(loginUser.getCustomerId());
        loginUser.getAddressEntity().setCustomerEntity(null);
//        printAddress(loginUser);
        Transaction tran = null;
        try {
            tran = c_dao.getSession().beginTransaction();
            c_dao.update(loginUser);
            tran.commit();
            request.put("loginUser", loginUser);
            request.put("tip", "删除地址成功！");
            return true;
        } catch (Exception e) {
            if (tran != null) tran.rollback();
            return false;
        } finally {
            c_dao.getSession().close();
        }
    }

    public boolean addAddr(CustomerEntity loginUser, AddressEntity address) {
        ActionContext ctx = ActionContext.getContext();
        request = (Map) ctx.get("request");
        CustomerDAO c_dao = new CustomerDAO();
        AddressDAO a_dao = new AddressDAO();
        loginUser = (CustomerEntity) c_dao.findById(loginUser.getCustomerId());
        // address.setCustomerEntity(loginUser); // 注释1
        loginUser.setAddressEntity(address);
        loginUser.getAddressEntity().setCustomerEntity(loginUser);
        Transaction tran = null;
        try {
            tran = c_dao.getSession().beginTransaction();
            c_dao.update(loginUser);
            tran.commit();
            request.put("loginUser", loginUser);
            request.put("tip", "添加地址成功！");
            return true;
        } catch (Exception e) {
            if (tran != null) tran.rollback();
            return false;
        } finally {
            c_dao.getSession().close();
        }
    }

    //        Set<CustomerEntity> resultLoginUsers = new HashSet(0);
//        Iterator<CustomerEntity> it = resultLoginUsers.iterator();
//        while (it.hasNext()) {
//            CustomerEntity loginUser = it.next();
//            CustomerEntity resultLoginUser = c_dao.findById(loginUser.getCustomerId());
//            resultLoginUsers.add(resultLoginUser);
//        }
//    loginUser = c_dao.findById(loginUser.getCustomerId());


    public boolean login(CustomerEntity loginUser) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        String account = loginUser.getAccount();
        String password = loginUser.getPassword();
        String hql = "from CustomerEntity as user where Account='" + account + "' and Password='" + password + "'";
        CustomerDAO dao = new CustomerDAO();
        List list = dao.findByHql(hql);
        dao.getSession().close();
        if (list.isEmpty()) return false;
        else {
            session.put("user", account);
            request.put("tip", "登录成功！");
            loginUser = (CustomerEntity) list.get(0);
            request.put("loginUser", loginUser);
            return true;
        }
    }

    public boolean register(CustomerEntity loginUser) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        String account = loginUser.getAccount();
        Date birthday = loginUser.getBirthday();
        System.out.println(account);
        System.out.println(birthday);

        CustomerDAO dao = new CustomerDAO();
        try {
            dao.save(loginUser);
        } catch (Exception e) {
            System.out.println(e);
            request.put("tip", "注册失败");
            return false;
        } finally {
            dao.getSession().close();
        }

        session.put("user", account);
        request.put("tip", "注册成功！");
        request.put("loginUser", loginUser);
        return true;

    }

    public boolean update(CustomerEntity loginUser) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        CustomerDAO dao = new CustomerDAO();
        Transaction tran = null;
        try {
            tran = dao.getSession().beginTransaction();
            System.out.println(loginUser.getBirthday());
            dao.update(loginUser);
            tran.commit();
            session.remove("user");
            request.put("tip", "更新个人信息成功，请重新登录！");
            return true;
        } catch (Exception e) {
            if (tran != null) tran.rollback();
            return false;
        } finally {
            dao.getSession().close();
        }
    }

    public boolean delete(CustomerEntity loginUser) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        request = (Map) ctx.get("request");
        CustomerDAO dao = new CustomerDAO();
        Transaction tran = null;
        try {
            tran = dao.getSession().beginTransaction();
            dao.delete(loginUser);
            tran.commit();
            session.remove("user");
            request.put("tip", "删除个人信息成功，请重新登录！");
            return true;
        } catch (Exception e) {
            if (tran != null) tran.rollback();
            return false;
        } finally {
            dao.getSession().close();
        }
    }
}

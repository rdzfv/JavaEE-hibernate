package cn.xyy.action;

//import cn.xyy.HelloStructs2.ItemBean;
//import cn.xyy.HelloStructs2.ItemOrderBean;
//import cn.xyy.HelloStructs2.ShopppingCartBean;
//import cn.xyy.HelloStructs2.UserBean;

import cn.xyy.Service.UserService;
import cn.xyy.po.AddressEntity;
import cn.xyy.po.CustomerEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

public class UserAction {
    private CustomerEntity loginUser;
    public CustomerEntity getLoginUser() {
        return loginUser;
    }
    public void setLoginUser(CustomerEntity loginUser) {
        this.loginUser = loginUser;
    }

    private AddressEntity address;

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String login() {
        UserService userServ = new UserService();
        if (userServ.login(loginUser)) return "loginsuccess";
        else return "loginfail";
    }

    public String addAddr() {
        UserService userServ = new UserService();
        if (userServ.addAddr(loginUser, address)) return "addAddrsuccess";
        else return "addAddrfail";
    }

    public String delAddr() {
        UserService userServ = new UserService();
        if (userServ.delAddr(loginUser, address)) return "delAddrsuccess";
        else return "delAddrfail";
    }

    public String register() {
        UserService userServ = new UserService();
        System.out.println(loginUser.getBirthday());
        if (userServ.register(loginUser)) return "registersuccess";
        else return "registerfail";
    }

    public String update() {
        UserService userServ = new UserService();
        if (userServ.update(loginUser)) return "updatesuccess";
        else return "updatefail";
    }

    public String delete() {
        UserService userServ = new UserService();
        if (userServ.delete(loginUser)) return "deletesuccess";
        else return "deletefail";
    }
}
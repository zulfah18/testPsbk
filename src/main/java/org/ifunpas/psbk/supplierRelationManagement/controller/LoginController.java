/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.ifunpas.psbk.supplierRelationManagement.database.UserDAO;
import org.ifunpas.psbk.supplierRelationManagement.model.Login;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "loginController")
@SessionScoped

public class LoginController {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("id_user");
        } else {
            return null;
        }
    }

    public String loginProject(Login login) {
        boolean result = UserDAO.login(login.getUname(), login.getPassword());
        if (result) {
            HttpSession session = getSession();
            session.setAttribute("username", login.getUname());

            return "home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "index.xhtml?faces-redirect=true";
        }
    }

    public String logout() {
        HttpSession session = getSession();
        session.invalidate();
        return "index.xhtml?faces-redirect=true";
    }
}

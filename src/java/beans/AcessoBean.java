/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CadastroDeAcessoDAO;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CadastroDeAcesso;

/**
 *
 * @author 2840481621039
 */
@ManagedBean
@RequestScoped
public class AcessoBean {

    /**
     * Creates a new instance of UserBean
     */
    private CadastroDeAcesso acesso;
    private CadastroDeAcessoDAO dao;
    private List<CadastroDeAcesso> acessos;
    public AcessoBean() {
        acesso = new CadastroDeAcesso();
        acessos = new ArrayList<>();
        dao = new CadastroDeAcessoDAO(javax.persistence.Persistence.createEntityManagerFactory("ControleEntradaSaidaPU"));
    }

    public CadastroDeAcesso getAcesso() {
        return acesso;
    }

    public void setIdentificacao(CadastroDeAcesso acesso) {
        this.acesso = acesso;
    }

    public CadastroDeAcessoDAO getDao() {
        return dao;
    }

    public void setDao(CadastroDeAcessoDAO dao) {
        this.dao = dao;
    }

    public List<CadastroDeAcesso> getacessos() {
        return acessos;
    }

    public void setIdentificacoes(List<CadastroDeAcesso> acessos) {
        this.acessos = acessos;
    }

 
    
    public void inserir() {
        dao.create(acesso);
    }
    
    public List<CadastroDeAcesso> listar() {
        acessos = dao.findCadastroDeAcessoEntities();
        return acessos;
    }
    
    public void excluir(CadastroDeAcesso c) {
        try {
            dao.destroy(c.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AcessoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

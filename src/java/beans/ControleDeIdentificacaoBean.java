/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.IdentificacaoDAO;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Identificacao;

/**
 *
 * @author 2840481621039
 */
@ManagedBean
@RequestScoped
public class ControleDeIdentificacaoBean {

    /**
     * Creates a new instance of UserBean
     */
    private Identificacao identificacao;
    private IdentificacaoDAO dao;
    private List<Identificacao> identificacoes;
    public ControleDeIdentificacaoBean() {
        identificacao = new Identificacao();
        identificacoes = new ArrayList<>();
        dao = new IdentificacaoDAO(javax.persistence.Persistence.createEntityManagerFactory("ControleEntradaSaidaPU"));
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }

    public IdentificacaoDAO getDao() {
        return dao;
    }

    public void setDao(IdentificacaoDAO dao) {
        this.dao = dao;
    }

    public List<Identificacao> getIdentificacoes() {
        return identificacoes;
    }

    public void setIdentificacoes(List<Identificacao> identificacoes) {
        this.identificacoes = identificacoes;
    }

 
    
        public void inserir() {
        dao.create(identificacao);
    }
    
    public List<Identificacao> listar() {
        identificacoes = dao.findIdentificacaoEntities();
        return identificacoes;
    }
    
    public void excluir(Identificacao c) {
        try {
            dao.destroy(c.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControleDeIdentificacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

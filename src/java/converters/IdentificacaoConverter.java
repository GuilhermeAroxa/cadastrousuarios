/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.IdentificacaoDAO;
import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import model.Identificacao;

/**
 *
 * @author kenji
 */
@FacesConverter(value = "identificacaoConverter", forClass = Identificacao.class)
public class IdentificacaoConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            IdentificacaoDAO disciplinasDAO = new IdentificacaoDAO(javax.persistence.Persistence.createEntityManagerFactory("ControleEntradaSaidaPU"));
            
            return disciplinasDAO.findIdentificacao(Integer.valueOf(value));
        }
        
        return null;
    }
    
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && (value instanceof Identificacao)) {
            return String.valueOf(((Identificacao) value).getId());
        }
        
        return null;
    }


}

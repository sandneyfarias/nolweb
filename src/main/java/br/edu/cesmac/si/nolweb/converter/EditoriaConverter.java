package br.edu.cesmac.si.nolweb.converter;

import br.edu.cesmac.si.nolweb.domain.Editoria;
import br.edu.cesmac.si.nolweb.util.VerificadorUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.util.Map;

@Named
@FacesConverter(value = "editoriaConverter", forClass = Editoria.class)
public class EditoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (VerificadorUtil.naoEstaNuloOuVazio(value)) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (VerificadorUtil.naoEstaNuloOuVazio(value)) {
            Editoria editoria = (Editoria) value;

            this.addAttribute(component, editoria);

            return editoria.getIdEditoria().toString();
        }
        return (String) value;
    }

    protected void addAttribute(UIComponent component, Editoria editoria) {
        String key = editoria.getIdEditoria().toString();
        this.getAttributesFrom(component).put(key, editoria);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}

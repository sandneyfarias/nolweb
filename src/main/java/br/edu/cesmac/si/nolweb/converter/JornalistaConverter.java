package br.edu.cesmac.si.nolweb.converter;

import br.edu.cesmac.si.nolweb.domain.Jornalista;
import br.edu.cesmac.si.nolweb.util.VerificadorUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.util.Map;

@Named
@FacesConverter(value = "jornalistaConverter", forClass = Jornalista.class)
public class JornalistaConverter implements Converter {

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
            Jornalista jornalista = (Jornalista) value;

            this.addAttribute(component, jornalista);

            return jornalista.getIdJornalista().toString();
        }
        return (String) value;
    }

    protected void addAttribute(UIComponent component, Jornalista jornalista) {
        String key = jornalista.getIdJornalista().toString();
        this.getAttributesFrom(component).put(key, jornalista);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}

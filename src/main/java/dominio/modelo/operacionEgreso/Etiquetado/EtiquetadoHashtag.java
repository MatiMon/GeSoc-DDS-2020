package dominio.modelo.operacionEgreso.Etiquetado;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Hashtag")
public class EtiquetadoHashtag extends TipoEtiqueta {

    private String hashtag;

    public EtiquetadoHashtag(String hashtag){
        this.hashtag = hashtag;
    }

    @Override
    public String getDescripcion() {
        return this.hashtag;
    }
}

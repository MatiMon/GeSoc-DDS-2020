package Dominio.OperacionEgreso.Etiquetado;

import javax.persistence.DiscriminatorValue;

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

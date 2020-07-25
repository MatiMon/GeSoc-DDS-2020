package Dominio.OperacionEgreso.Etiquetado;

public class EtiquetadoHashtag implements TipoEtiqueta {

    private String hashtag;

    public EtiquetadoHashtag(String hashtag){
        this.hashtag = hashtag;
    }

    @Override
    public String getDescripcion() {
        return this.hashtag;
    }
}

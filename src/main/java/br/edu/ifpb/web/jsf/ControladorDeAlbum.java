package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.model.album.ServiceAlbum;
import br.edu.ifpb.domain.model.album.Album;
import br.edu.ifpb.domain.model.banda.Integrante;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped; //CDI
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped; //JSF
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/11/2017, 09:11:44
 */
@Named
@RequestScoped
//@ManagedBean
//@RequestScoped
public class ControladorDeAlbum {

    private Album album = new Album();
//    private Integrante integrante = new Integrante();

    private ServiceAlbum service = new ServiceAlbum();

    public String salvar() {
        if (this.service.salvar(album)) {
            return "listar.xhtml";
        }
        return null;
    }

    public String excluir(Album albumParaExcluir) {
        this.service.excluirAlbum(albumParaExcluir);
        return null;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

//    public Integrante getIntegrante() {
//        return integrante;
//    }
//
//    public void setIntegrante(Integrante integrante) {
//        this.integrante = integrante;
//    }

    
    public List<Album> albuns() {
        return this.service.todosOsAlbuns();

    }

    public List<Integrante> integrantes() {
        return this.service.todosOsIntegrantes();

    }
}

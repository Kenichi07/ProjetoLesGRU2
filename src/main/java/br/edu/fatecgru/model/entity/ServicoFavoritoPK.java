package br.edu.fatecgru.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicoFavoritoPK implements Serializable{
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    // Construtores
    public ServicoFavoritoPK() {}
    public ServicoFavoritoPK(Usuario usuario, Servico servico) {
        this.usuario = usuario;
        this.servico = servico;
    }

    // Getters e Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    // Equals e HashCode (importante!)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicoFavoritoPK)) return false;
        ServicoFavoritoPK that = (ServicoFavoritoPK) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(servico, that.servico);
    }
    @Override
    public int hashCode() {return Objects.hash(usuario, servico);}
}

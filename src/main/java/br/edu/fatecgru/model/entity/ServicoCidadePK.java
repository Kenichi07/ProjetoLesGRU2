package br.edu.fatecgru.model.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicoCidadePK {
	//Atributos
	@ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    //Construtores
    public ServicoCidadePK() {}
    public ServicoCidadePK(Servico servico, Cidade cidade) {
        this.servico = servico;
        this.cidade = cidade;
    }
    
  //Getters e Setters
	public Servico getServico() {return servico;}
	public void setServico(Servico servico) {this.servico = servico;}
	
	public Cidade getCidade() {return cidade;}
	public void setCidade(Cidade cidade) {this.cidade = cidade;}
	
	//Equals e HashCode (importante!)
	@Override
	public int hashCode() {	return Objects.hash(cidade, servico);}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		ServicoCidadePK other = (ServicoCidadePK) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(servico, other.servico);
	}  
}

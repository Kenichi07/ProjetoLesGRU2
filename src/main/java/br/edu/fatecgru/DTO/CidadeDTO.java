package br.edu.fatecgru.DTO;

public class CidadeDTO {
	private String nome;
    private String estado;
    private String siglaEstado;

    
    public CidadeDTO(String nome, String estado, String siglaEstado) {
        this.nome = nome;
        this.estado = estado;
        this.siglaEstado = siglaEstado;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getSiglaEstado() { return siglaEstado; }
    public void setSiglaEstado(String siglaEstado) { this.siglaEstado = siglaEstado; }
}

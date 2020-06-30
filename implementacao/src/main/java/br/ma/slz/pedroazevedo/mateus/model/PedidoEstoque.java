package br.ma.slz.pedroazevedo.mateus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ma.slz.pedroazevedo.mateus.enums.eTipoPedido;

@Entity
@Table(name = "pedidos_estoque")
public class PedidoEstoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String observacao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private eTipoPedido tipo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "filial_id", nullable = false)
	private Filial filial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public eTipoPedido getTipo() {
		return tipo;
	}

	public void setTipo(eTipoPedido tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	@Override
	public String toString() {
		return  "ID: " + id + "\n" +
				"Observacao: " + observacao + "\n" +
				"Usuario: " + usuario.getNome() + "\n" + 
				"Cliente: " + cliente.getNome() + "\n" +
				"Filial: " + filial.getNome();
	}

}

package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Projeto;

public class ClientTest {
	
	private HttpServer server;
	private Client client;

	@Before
	public void startaServidor() {
		server = Servidor.startaServidor();
	}
	
	@After 
	public void mataServidor() {
		server.stop();
	}
	
	private WebTarget startaCliente() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:8080");
		return target;
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		WebTarget target = startaCliente();
		Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	
	
	@Test
	public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
		WebTarget target = startaCliente();
		Projeto projeto = target.path("/projetos/1").request().get(Projeto.class);
		Assert.assertEquals(projeto.getNome(), "Minha loja");
	}
	
	@Test
	public void testaQueAdicionarUmCarrinho() {
		WebTarget target = startaCliente();
		
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
		carrinho.setRua("Rua Vergueiro");
		carrinho.setCidade("Sao Paulo");
		
		Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);
		Response response = target.path("/carrinhos").request().post(entity);
		
		Assert.assertEquals(201, response.getStatus());
		
		String location = response.getHeaderString("Location");
		Carrinho carrinho2 = client.target(location).request().get(Carrinho.class);
		
		Assert.assertEquals(carrinho2.getProdutos().get(0).getNome(), "Tablet");
	}
	
	@Test
	public void testaQueAdicionarUmProjeto() {
		WebTarget target = startaCliente();
		
		Projeto projeto = new Projeto(7l, "Teste", 2017);		
		
		Entity<Projeto> entity = Entity.entity(projeto, MediaType.APPLICATION_XML);
		
		Response response = target.path("/projetos").request().post(entity);
		
		Assert.assertEquals(201, response.getStatus());
		
		String location = response.getHeaderString("Location");
		Projeto projeto2 = client.target(location).request().get(Projeto.class);
		
		Assert.assertEquals(projeto2.getNome(), "Teste");
	}

}

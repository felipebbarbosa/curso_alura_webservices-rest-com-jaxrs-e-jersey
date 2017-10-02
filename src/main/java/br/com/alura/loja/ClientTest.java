package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

public class ClientTest {
	
	private HttpServer server;

	@Before
	public void startaServidor() {
		server = Servidor.startaServidor();
	}
	
	@After 
	public void mataServidor() {
		server.stop();
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos").request().get(String.class);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertTrue(carrinho.getRua().equals("Rua Vergueiro 3185, 8 andar"));
	}
	
	@Test
	public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		Assert.assertTrue(projeto.getNome().equals("Minha loja"));
	}

}

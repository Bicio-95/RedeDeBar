package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import ctrl.*;

public class ControleTeste {

	private ControleCliente controle;
	private ClienteDTO cliente;
	private ClienteDTO cliente2;
	
	@Before
	public void set(){
		controle = new ControleCliente();
		cliente = new ClienteDTO("João Teste", "111111111", 20, Genero.M, controle.getClientesCadastrados().size());
		cliente2 = new ClienteDTO("Isabel Teste", "2222222222", 20, Genero.F, controle.getClientesCadastrados().size());
	}


	@Test
	public void testeCadastraNovoUsuario(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarAcessoSemCadastrar(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarSaidaCliente(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.liberaSaidaCliente(cliente.getCpf());
		assertEquals(0, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarSaidaClienteNaoCadastrado(){
		controle.liberaAcessoCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(0, controle.getClientesCadastrados().size());
		controle.liberaSaidaCliente(cliente.getCpf());
		assertEquals(0, controle.getClientesNaCasa().size());
		assertEquals(0, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarEntradaClienteViaCPF(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.liberaSaidaCliente(cliente.getCpf());
		assertEquals(0, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.liberaAcessoCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarSaidaSemNenhumClienteNaCasa(){
		controle.liberaSaidaCliente(cliente.getCpf());
	}
	
	@Test
	public void testeLiberarSaidaCPFErrado(){
		controle.liberaSaidaCliente("00000000000");
	}
	
	@Test
	public void testeCadastrarDoisSociosComMesmoCPF(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.liberaSaidaCliente(cliente.getCpf());
		assertEquals(0, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeCadastrarDuasVezesMesmoCliente(){
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeLiberarAcessoECadastrarSocioSemQueEleSaia(){
		controle.liberaAcessoCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(0, controle.getClientesCadastrados().size());
		controle.cadastraCliente(cliente);
		assertEquals(1, controle.getClientesNaCasa().size());
		assertEquals(1, controle.getClientesCadastrados().size());
	}
	
	@Test
	public void testeBuscarCPFValido(){
		controle.cadastraCliente(cliente);
		ClienteDTO c = controle.buscaClienteCadastrado(cliente.getCpf());
		assertEquals(cliente, c);
	}
	
	@Test
	public void testeBuscarCPFInvalido(){
		ClienteDTO c = controle.buscaClienteCadastrado(cliente.getCpf());
		assertEquals(null, c);
	}
	
	@Test
	public void testeLiberarAcessoComCPFMenorQue11Digitos(){
		ClienteDTO cliente3 = new ClienteDTO("Isabel Teste", "2222", 20, Genero.F, controle.getClientesCadastrados().size());
		controle.liberaAcessoCliente(cliente3);
	}
	
	
}

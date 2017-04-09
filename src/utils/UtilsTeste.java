package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTeste {

	@Test
	public void testeVerificaPorcentagem() {
		int aux = 0;
		aux = Utils.verificaPorcentagem(154, 154);
		assertEquals(100, aux);
		aux = Utils.verificaPorcentagem(154, 147);
		assertEquals(95, aux);
		aux = Utils.verificaPorcentagem(154, 139);
		assertEquals(90, aux);
		aux = Utils.verificaPorcentagem(154, 57);
		assertEquals(37, aux);
		aux = Utils.verificaPorcentagem(154, 74);
		assertEquals(48, aux);
		aux = Utils.verificaPorcentagem(154, 1);
		assertEquals(0, aux);
		aux = Utils.verificaPorcentagem(154, 4);
		assertEquals(2, aux);
	}
	
	@Test
	public void testeContemNumeroComCaracteresEspeciais() {
		boolean b = Utils.naoContemNumero(",.+-*/[]/;^´-.!@#$%¨&¹²³£¢¬");
		assertTrue(b);
	}
	
	@Test
	public void testeContemNumeroNoMeioDeString() {
		boolean b = Utils.naoContemNumero("Tes4te");
		assertFalse(b);
	}
	
	@Test
	public void testeContemNumeroNasPontasDaString() {
		boolean b = Utils.naoContemNumero("4Teste4");
		assertFalse(b);
	}
	
	@Test
	public void testeContemNumeroNasPontasDaStringComEspacos() {
		boolean b = Utils.naoContemNumero(" Teste 4 Teste");
		assertFalse(b);
	}
}

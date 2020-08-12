package model.services;

public class Paypal implements ServicoPagamentoOnline{
	
	public static final double TAXA = 0.02;
	public static final double JURO_MENSAL = 0.01;

	@Override
	public Double taxaPagamento(Double valor) {
		// TODO Auto-generated method stub
		return valor * TAXA;
	}

	@Override
	public Double juros(Double valor, Integer mes) {
		// TODO Auto-generated method stub
		return valor * JURO_MENSAL * mes;
	}

}

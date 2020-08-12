package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ContratoServico {
	private ServicoPagamentoOnline servicoPagamentoOnline;
		
	public ContratoServico(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processaContrato(Contrato contrato, Integer meses) {
		Double parcelaBasica = contrato.getVlrTotal() / meses;
		for(int i = 0; i < meses; i++) {
			Double parcelaJuros = parcelaBasica + servicoPagamentoOnline.juros(parcelaBasica, i+1);
			Double parcelaFinal = parcelaJuros + servicoPagamentoOnline.taxaPagamento(parcelaJuros);
			Date vencimento = adicionaMes(contrato.getData(), i+1);
			
			contrato.getPrestacoes().add(new Prestacao(vencimento, parcelaFinal));
		}
	}
	
	private Date adicionaMes(Date data, int qtde) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, qtde);
		
		return calendar.getTime();
	}
}

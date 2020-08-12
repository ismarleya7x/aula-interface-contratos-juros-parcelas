package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.services.ContratoServico;
import model.services.Paypal;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("---SERVIÇO DE PAGAMENTOS ONLINE---\n\n");
		
		System.out.print("Entre com o número do contrato: ");
		int numero = sc.nextInt();
		
		System.out.print("Informe a data de vigência do contrato: ");
		Date data = sdf.parse(sc.next());
		
		System.out.print("Entre com o valor total: R$");
		Double vlrTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, vlrTotal);
		
		System.out.print("Entre com o número de parcelas: ");
		int meses = sc.nextInt();
		
		ContratoServico cs = new ContratoServico(new Paypal());
		
		cs.processaContrato(contrato, meses);
		
		System.out.println("\n---Dados do contrato---\n");
		
		System.out.println("Número do contrato: " + contrato.getNumero());
		System.out.println("Data de vigência: " + sdf.format(contrato.getData()));
		System.out.println("Valor total: R$" + contrato.getVlrTotal());
		System.out.println("---PARCELAS---");
		for(Prestacao prestacao : contrato.getPrestacoes()) {
			System.out.println(sdf.format(prestacao.getVencimento()) + " " + prestacao.getValor());
		}
		
		sc.close();
	}

}

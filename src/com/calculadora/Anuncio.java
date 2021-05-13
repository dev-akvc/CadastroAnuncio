package com.calculadora;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Anuncio {

	private String nomeAnuncio;
	private String nomeCliente;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Double investimentoDiario;

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}
	
	public Anuncio() {
		// TODO Auto-generated constructor stub
	}

	public Anuncio(String nomeAnuncio, String nomeCliente, LocalDate dataInicio, LocalDate dataFim,
			Double investimentoDiario) {
		this.nomeAnuncio = nomeAnuncio;
		this.nomeCliente = nomeCliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.investimentoDiario = investimentoDiario;
	}

	public long getCalculoPeriodo() {

		long periodo = ChronoUnit.DAYS.between(dataInicio, dataFim);
		/*
		 * REGRA DE NEG�CIO: SE UM AN�NIO FOR LAN�ADO NUM DIA E ENCERRADO NO MESMO DIA,
		 * O PERIODO SER� CONSIDERADO DE 1 DIA
		 */
		if (periodo == 0) {
			periodo = 1;
		}
		return periodo;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Double getInvestimentoDiario() {
		return investimentoDiario;
	}

	public void setInvestimentoDiario(Double investimentoDiario) {
		this.investimentoDiario = investimentoDiario;

	}

	public String toStringDoAnuncio() {
		return "Anuncio [nomeAnuncio=" + nomeAnuncio + ", nomeCliente=" + nomeCliente + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + ", investimentoDiario=" + investimentoDiario + ", getCalculoPeriodo()="
				+ getCalculoPeriodo() + "]";
	}

	
	// EXECU��O
	public static void main(String[] args) throws ParseException {

		Scanner teclado = new Scanner(System.in);
		List<Anuncio> listaDeAnuncios = new ArrayList<>();
		cargaInicialDeDadosParaTestes(listaDeAnuncios);

		visualizarMenu();

		while (true) {

			System.out.println("\n" + "Digite o n�mero correspondente a op��o desejada: \n");

			int opcao = teclado.nextInt();

			switch (opcao) {
			case 1:
				cadastrarAnuncio(listaDeAnuncios);
				break;

			case 2:
				listarAnuncios(listaDeAnuncios);
				break;

			case 3:
				gerarRelatorioAnuncios(listaDeAnuncios);
				break;

			case 4:
				consultaRelatoriosPorPeriodo(listaDeAnuncios);
				break;

			case 5:
				consultaRelatorioPorCliente(listaDeAnuncios);
				break;

			case 6:
				consultaRelatoriosPorData(listaDeAnuncios);
				break;

			case 7:
				consultaRelatorioPorPeriodoECliente(listaDeAnuncios);
				break;

			case 8:
				consultaRelatorioPorNomeDoAnuncio(listaDeAnuncios);
				break;

			case 9:
				System.out.println("Retornando ao Menu incial...\n ");
				visualizarMenu();
				break;

			case 10:
				System.out.println("Obrigado por usar nossa Anuncio...");
				return;

			default:
				break;
			}
		}
	}
	
	public static void relatorioIndividual(double investimento, Anuncio anuncio) {
		DecimalFormat df = new DecimalFormat("0.00");

		int periodo = (int) anuncio.getCalculoPeriodo();

		if (periodo == 0) {
			periodo = 1;
		}

		investimento *= 30 * periodo;
		double taxa_1 = 0.12;
		double taxa_2 = 0.15;
		double taxa_3 = 40;

		double numeroDeCliques = 1;
		double numeroDeCompartilhamentos = 1;
		double visualizacoes = 1;

		double totalDeCliques = 0;
		double totalDeCompartilhamentos = 0;
		double totalDeVisualizacoes = 0;

		for (int i = 0; i < 3; i++) {

			numeroDeCliques = investimento *= taxa_1;
			totalDeCliques += numeroDeCliques;

			numeroDeCompartilhamentos = investimento *= taxa_2;
			totalDeCompartilhamentos += numeroDeCompartilhamentos;

			visualizacoes = investimento *= taxa_3;
			totalDeVisualizacoes += visualizacoes;

		}


		System.out.println("\n - " + "O valor investido: " + df.format(investimento));
		System.out.println("\n - " + "O Total de Cliques foi: " + Math.round(totalDeCliques));
		System.out.println("\n - " + "O Total de Compartilhamentos foi: " + Math.round(totalDeCompartilhamentos));
		System.out.println("\n - " + "O Total de Visualiza��es foi: " + Math.round(totalDeVisualizacoes + 30.0) + "\n");

	}

	public static void visualizarMenu() {
		System.out.println("=== SELECIONE UMA OPERA��O ===");
		System.out.println("1 - PARA CADASTRAR UM AN�NCIO: ");
		System.out.println("2 - PARA LISTAR TODOS OS AN�NCIOS: ");
		System.out.println("3 - GERAR RELAT�RIO DE TODOS OS AN�NCIOS: ");
		System.out.println("4 - GERAR RELAT�RIO POR PER�ODO: ");
		System.out.println("5 - GERAR OS RELAT�RIOS DOS AN�NCIOS POR CLIENTES: ");

		System.out.println("\n\n === FUN��ES EXTRAS === \n\n");

		System.out.println("6 - GERAR OS RELAT�RIOS DOS AN�NCIOS POR DATA: ");
		System.out.println("7 - GERAR RELAT�RIO POR PER�ODO E CLIENTE: ");
		System.out.println("8 - GERAR RELAT�RIO POR NOME DO AN�NCIO: ");

		System.out.println("9 - PARA VOLTAR AO MENU PRINCIPAL: ");
		System.out.println("10 - PARA SAIR: ");
	}

	public static void listarAnuncios(List<Anuncio> anuncios) {
		for (Anuncio anuncio : anuncios) {
			dadosDoAnuncio(anuncio);
		}

	}


	public static void cadastrarAnuncio(List<Anuncio> anuncios) throws ParseException {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o nome do an�ncio: (Separado por tra�os) ");
		String nomeAnuncio = teclado.next();

		System.out.println("Digite o nome do cliente: (Separado por tra�os) ");
		String nomeCliente = teclado.next();

		System.out.println("Digite a data incial separada por barras: ");
		String dataTexto1 = teclado.next();

		System.out.println("Digite a data final separada por barras: ");
		String dataTexto2 = teclado.next();

		System.out.println("Digite o valor do investimento di�rio: ");
		Double investimentoDiario = teclado.nextDouble();

		LocalDate dataInicial = StringToDate(dataTexto1);
		LocalDate dataFinal = StringToDate(dataTexto2);

		Anuncio cadastroAnuncio = new Anuncio(nomeAnuncio, nomeCliente, dataInicial, dataFinal, investimentoDiario);
		anuncios.add(cadastroAnuncio);
		cadastroAnuncio.toString();

		System.out.println("Cadastro realizado com sucesso!");

	}

	public static void gerarRelatorioAnuncios(List<Anuncio> anuncios) {

		for (Anuncio anuncio : anuncios) {
			dadosDoAnuncio(anuncio);
			relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
		}
	}

	// VAI RECEBER UMA DATA DIGITADA PELO USUARIO E CONVERTER PARA UMA DATA
	public static LocalDate StringToDate(String data) {

		String[] dataSeparada = data.split("/");
		LocalDate dataConvertida = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]),
				Integer.parseInt(dataSeparada[0]));
		
		
		return dataConvertida;

	}

	public static void cargaInicialDeDadosParaTestes(List<Anuncio> anuncios) {
		Anuncio anuncio1 = new Anuncio("An�ncio1", "Cliente1", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 1), 1.0);
		Anuncio anuncio11 = new Anuncio("An�ncio11", "Cliente1", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3),
				1.0);
		Anuncio anuncio2 = new Anuncio("An�ncio2", "Cliente2", LocalDate.of(2021, 1, 5), LocalDate.of(2021, 1, 10),
				1.0);
		Anuncio anuncio3 = new Anuncio("An�ncio3", "Cliente3", LocalDate.of(2021, 5, 2), LocalDate.of(2021, 5, 5), 1.0);
		Anuncio anuncio4 = new Anuncio("An�ncio4", "Cliente4", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 1), 1.0);

		anuncios.addAll(Arrays.asList(anuncio1, anuncio11, anuncio2, anuncio3, anuncio4));
	}

	public static void consultaRelatoriosPorData(List<Anuncio> anuncios) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite uma data para a consulta no formato dia/m�s/ano: ");
		String data = teclado.next();

		LocalDate dataConsulta = StringToDate(data);
		for (Anuncio anuncio : anuncios) {
			
			if (dataConsulta.equals(anuncio.getDataInicio())) {
				dadosDoAnuncio(anuncio);
				relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
			}

		}

	}

	public static void consultaRelatoriosPorPeriodo(List<Anuncio> anuncios) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite a data inicial do periodo a ser consultado: ");
		String dataInicial = teclado.next();

		System.out.println("Digite a data final do periodo a ser consultado: ");
		String dataFinal = teclado.next();

		LocalDate data1 = StringToDate(dataInicial);
		LocalDate data2 = StringToDate(dataFinal);

		

		for (Anuncio anuncio : anuncios) {

			if ((((anuncio.getDataInicio().isEqual(data1)) || (anuncio.getDataInicio().isAfter(data1)))
					&& ((anuncio.getDataInicio().isBefore(data2)) || (anuncio.getDataInicio().isEqual(data2))))
					&& (((anuncio.getDataFim().isEqual(data1)) || (anuncio.getDataFim().isAfter(data1)))
							&& ((anuncio.getDataFim().isBefore(data2)) || (anuncio.getDataFim().isEqual(data2))))

			)

			{

				dadosDoAnuncio(anuncio);
				relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
			} else {
				System.out.println("Dados n�o encontrados");
				return;
			}
		}
	}

	public static void consultaRelatorioPorCliente(List<Anuncio> anuncios) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite um nome de cliente para a consulta: ");
		String nomeDoCliente = teclado.next();

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getNomeCliente().contains(nomeDoCliente)) {
				dadosDoAnuncio(anuncio);
				relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
			}
		}
	}

	public static void consultaRelatorioPorNomeDoAnuncio(List<Anuncio> anuncios) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite um nome de anuncio para a consulta: ");
		String nomeDoAnuncio = teclado.next();

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getNomeAnuncio().contains(nomeDoAnuncio)) {
				dadosDoAnuncio(anuncio);
				relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
			} else {
				System.out.println("Dados n�o encontrados");
				return;
			}
		}
	}

	public static void consultaRelatorioPorPeriodoECliente(List<Anuncio> anuncios) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o nome do cliente: ");
		String nomeDoCLiente = teclado.next();

		System.out.println("Digite a data inicial do periodo: ");
		String dataInicial = teclado.next();

		System.out.println("Digite a data final do periodo: ");
		String dataFinal = teclado.next();

		LocalDate dataInicialConsulta = StringToDate(dataInicial);
		LocalDate dataFinalConsulta = StringToDate(dataFinal);

		for (Anuncio anuncio : anuncios) {
			if (anuncio.getNomeCliente().contains(nomeDoCLiente)
					&& (anuncio.getDataInicio().equals(dataInicialConsulta)
							|| anuncio.getDataInicio().isAfter(dataInicialConsulta))
					&& (anuncio.getDataFim().equals(dataFinalConsulta)
							|| anuncio.getDataFim().isBefore(dataFinalConsulta))) {

				dadosDoAnuncio(anuncio);
				relatorioIndividual(anuncio.getInvestimentoDiario(), anuncio);
			} else {
				System.out.println("Dados n�o encontrados");
				return;
			}
		}

	}

	public static void dadosDoAnuncio(Anuncio anuncio) {
		System.out.println("Nome do an�ncio: " + anuncio.getNomeAnuncio());
		System.out.println("Cliente dono do an�ncio: " + anuncio.getNomeCliente());
		System.out.println("Data inicial do an�ncio: " + anuncio.getDataInicio());
		System.out.println("Data final do an�ncio: " + anuncio.getDataFim());
		System.out.println("Per�odo do an�ncio: " + (int) anuncio.getCalculoPeriodo() + "\n");

	}
	
	


}

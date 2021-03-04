package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OperacoesController {

	public OperacoesController() {
		super();
	}

	public String soNome() {
		String so = System.getProperty("os.name");
		return so;
	}

	public void listarProcessos(String so) {
		String processo;

		if (so.contains("Windows")) {
			processo = "TASKLIST /FO TABLE";
		} else {
			processo = "ps -ef";
		}

		try {
			Process proc = Runtime.getRuntime().exec(processo);
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}

			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void matarPid(String so, int pid) {
		StringBuffer buffer = new StringBuffer();

		if (so.contains("Windows")) {
			buffer.append("TASKKILL /PID" + " " + pid);
		} else {
			buffer.append("kill -9" + " " + pid);
		}

		try {
			Runtime.getRuntime().exec(buffer.toString());
			System.out.println("Processo finalizado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void matarNome(String so, String processo) {
		StringBuffer buffer = new StringBuffer();

		if (so.contains("Windows")) {
			buffer.append("TASKKILL /IM" + " " + processo);
		} else {
			buffer.append("pkill -f" + " " + processo);
		}

		try {
			Runtime.getRuntime().exec(buffer.toString());
			System.out.println("Processo finalizado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

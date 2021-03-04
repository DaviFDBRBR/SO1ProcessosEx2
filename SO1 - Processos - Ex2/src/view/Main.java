package view;

import java.util.Scanner;

import controller.OperacoesController;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OperacoesController op = new OperacoesController();
		String so = op.soNome(), processo;
		int opc, pid;
		
		do {
			System.out.print("1 - Listar Processos\n2 - Matar por pid\n3 - Matar por nome\n0 - Encerrar\n");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				op.listarProcessos(so);
				break;
			case 2:
				pid = sc.nextInt();
				op.matarPid(so, pid);
				break;
			case 3:
				processo = sc.next();
				op.matarNome(so, processo);
				break;
			case 0:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção Inválida!");
			}

		} while (opc != 0);

		sc.close();
	}

}

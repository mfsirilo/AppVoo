package javaapplication3;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        Principal ler = new Principal();
        ControleVoo cadVoo = new ControleVoo();
        Scanner scan = new Scanner(System.in);
        System.out.println("Se deseja cadastrar um cliente digite 1");
        System.out.println("Se deseja cadastrar um Voo digite 2");
        System.out.println("Se deseja vender uma passagem digite 3");

        System.out.println("");
        int opcao = scan.nextInt();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    cadVoo.CadastraVoo();
                    break;
                case 2:
                    cadVoo.readCsvFile();
                    break;
            }
            System.out.print("Caso deseje sair digite 0 \n do contrario informe uma opção desejada");
            opcao = scan.nextInt();
        }
    }

}

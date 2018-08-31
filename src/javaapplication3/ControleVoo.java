package javaapplication3;

import com.sun.xml.internal.stream.buffer.stax.StreamWriterBufferCreator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ControleVoo {

    private int id;
    private int numeroVoo;
    private String horaSaida;
    private String horaChegada;
    private String cidadeSaida;
    private String cidadeChegada;

    ControleVoo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public String getCidadeSaida() {
        return cidadeSaida;
    }

    public void setCidadeSaida(String cidadeSaida) {
        this.cidadeSaida = cidadeSaida;
    }

    public String getCidadeChegada() {
        return cidadeChegada;
    }

    public void setCidadeChegada(String cidadeChegada) {
        this.cidadeChegada = cidadeChegada;
    }

    public ControleVoo(int id, int numeroVoo, String horaSaida, String horaChegada, String cidadeSaida, String cidadeChegada) {
        this.id = id;
        this.numeroVoo = numeroVoo;
        this.horaSaida = horaSaida;
        this.horaChegada = horaChegada;
        this.cidadeSaida = cidadeSaida;
        this.cidadeChegada = cidadeChegada;
    }

    Scanner scan = new Scanner(System.in);

    public void CadastraVoo() throws IOException {
        System.out.println("Informe os dados do Voo");
        numeroVoo = scan.nextInt();
        horaSaida = scan.next();
        horaChegada = scan.next();
        cidadeSaida = scan.next();
        cidadeChegada = scan.next();
        gravarNoCsv(horaSaida, horaSaida, horaChegada, cidadeSaida, cidadeChegada);
    }

    public void readCsvFile() {
        String arquivo = "/home/marcos/NetBeansProjects/AppVooCSV/arquivos/voos.csv";
        //ControleVoo newVoo = new ControleVoo();
        BufferedReader buffer = null;
        String linha = "";
        String divisor = ",";

        try {
            buffer = new BufferedReader(new FileReader(arquivo));
            buffer.readLine();
            while ((linha = buffer.readLine()) != null) {
                String[] voos = linha.split(divisor);
                System.out.println(" Numero Voo: " + voos[0] + " Hora Saída: " + voos[1] + " Hora Chegada: " + voos[2]
                        + " Cidade Saida: " + voos[3] + " Cidade Chegada: " + voos[4]);
                System.out.println("");

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("ERRO!");
        }
    }

    //private static final String NEW_LINE_SEPARATOR = "\n";
    public static void gravarNoCsv(String numeroVoo, String horaSaida, String horaChegada, String cidadeSaida, String cidadeChegada) throws IOException {
        String arquivo = "/home/marcos/NetBeansProjects/AppVooCSV/arquivos/voos.csv";
        BufferedReader bufferReader;
        BufferedWriter buffer;
        String linha = "";
        String divisor = ",";

        FileWriter writer = new FileWriter(arquivo);
        try {
            
            bufferReader = new BufferedReader(new FileReader(arquivo));

            buffer = new BufferedWrite(new FileWrite(arquivo));

            while ((linha = bufferReader.readLine()) != null) {

                if (buffer.readLine() == null) {
                    writer.append(numeroVoo);
                    writer.append(',');
                    writer.append(horaSaida);
                    writer.append(',');
                    writer.append(horaChegada);
                    writer.append(',');
                    writer.append(cidadeSaida);
                    writer.append(',');
                    writer.append(cidadeChegada);
                    writer.append('\n');
                }
            }
            //generate whatever data you want
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

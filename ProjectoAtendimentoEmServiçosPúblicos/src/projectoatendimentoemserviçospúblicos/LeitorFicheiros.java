/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoatendimentoemserviçospúblicos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hugod
 */
public class LeitorFicheiros {

    public static void main(String[] args) {
        lerFicheiroReparticoes();
        lerFicheiroCidadoes();
        lerFicheiroSenhas();
    }

    private static void lerFicheiroReparticoes() {
        String fileName = "fx_repartições.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] reparticoes = line.split(",");
                Reparticao r;
                ArrayList<String> listaServicos = new ArrayList<>();
                for (int i = 4; i < reparticoes.length; i++) {
                    listaServicos.add(reparticoes[i]);
                }
                r = new Reparticao(reparticoes[1], Integer.parseInt(reparticoes[2]), Integer.parseInt(reparticoes[3]), listaServicos);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
    }

    private static void lerFicheiroCidadoes() {
        String fileName = "fx_cidadaos.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] cidadaos = line.split(",");
                Cidadao c;
                c = new Cidadao(cidadaos[1],Integer.parseInt(cidadaos[2]),cidadaos[3],cidadaos[4],Integer.parseInt(cidadaos[5]));
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
    }

    private static void lerFicheiroSenhas() {
        String fileName = "fx_senhas.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] senhas = line.split(",");
                Senha s;
                s = new Senha(senhas[2],Integer.parseInt(senhas[3]));// o que fazer ao valor do numero de contribuinte ? edit 1 : prob tem a ver com a estrutura que querem que estabeleca entre senhas e cidadao que nao  sei qual sera mas ate parece bddad
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }
    }
}

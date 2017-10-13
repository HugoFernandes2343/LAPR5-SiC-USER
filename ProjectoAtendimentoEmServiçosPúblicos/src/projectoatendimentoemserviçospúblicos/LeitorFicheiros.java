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
import java.util.Iterator;

/**
 *
 * @author hugod
 */
public class LeitorFicheiros {

    private ListaReparticao listaReparticoes;

    public void LeitorFicheiros() {
        this.listaReparticoes = new ListaReparticao();
        lerFicheiroReparticoes();
        lerFicheiroCidadoes();
        lerFicheiroSenhas();
    }

    private void lerFicheiroReparticoes() {
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
                r = new Reparticao(reparticoes[0], Integer.parseInt(reparticoes[1]), Integer.parseInt(reparticoes[2]), listaServicos);
                DoublyLinkedList<Reparticao> l = listaReparticoes.getListaReparticao();
                l.addLast(r);
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

    private void lerFicheiroCidadoes() {
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
                c = new Cidadao(cidadaos[0], Integer.parseInt(cidadaos[1]), cidadaos[2], cidadaos[3], Integer.parseInt(cidadaos[4]));
                Reparticao r = listaReparticoes.getReparticaoPorNumero(Integer.parseInt(cidadaos[4]));
                ListaCidadao l = r.getListaCidadao();
                l.getListaCidadao().addLast(c);
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

    private void lerFicheiroSenhas() {
        Iterator itr = this.listaReparticoes.getListaReparticao().iterator();
        while (itr.hasNext()) {
            Reparticao r = (Reparticao) itr.next();
            String fileName = "Senhas_" + String.valueOf(r.getNumeroReparticao()) + ".txt";
            String line = null;

            try {
                FileReader fileReader
                        = new FileReader(fileName);

                BufferedReader bufferedReader
                        = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    String[] senhas = line.split(",");
                    Senha s;
                    s = new Senha(senhas[1], Integer.parseInt(senhas[2]));// o que fazer ao valor do numero de contribuinte ? edit 1 : prob tem a ver com a estrutura que querem que estabeleca entre senhas e cidadao que nao  sei qual sera mas ate parece bddad
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
}

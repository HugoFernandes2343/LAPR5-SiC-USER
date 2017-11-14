/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class FileRead {

    private GameBase gb;

    public GameBase getGameBase() {
        return gb;
    }

    public void FileRead() throws CloneNotSupportedException {
        this.gb = new GameBase();
        lerMatrix();
        lerMap();
    }

    private void lerMatrix() {
        String fileName = "Matrix-LocaisxCaminhos_M.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            if ((line = bufferedReader.readLine()) != "LOCAIS") {
                while ((line = bufferedReader.readLine()) != "CAMINHOS") {
                    String[] specifics = line.split(",");
                    gb.insertLocale(specifics[0], Integer.parseInt(specifics[1]));
                }
                while ((line = bufferedReader.readLine()) != null) {
                    String[] specifics = line.split(",");
                    Locale l1 = gb.searchForLocal(specifics[0]);
                    Locale l2 = gb.searchForLocal(specifics[1]);
                    gb.insertRoads(Integer.parseInt(specifics[2]), l1, l2);
                }
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

    private void lerMap() {
        String fileName = "Map-PersonagemxAlianca_M.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            if ((line = bufferedReader.readLine()) != "PERSONAGENS") {
                while ((line = bufferedReader.readLine()) != "ALIANÇAS") {
                    String[] specifics = line.split(",");
                    Locale l1 = gb.searchForLocal(specifics[2]);
                    gb.insertCharacter(specifics[0], Integer.parseInt(specifics[1]), l1);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    String[] specifics = line.split(",");
                    Character c1 = gb.searchForCharacter(specifics[0]);
                    Character c2 = gb.searchForCharacter(specifics[1]);
                    boolean b1 = true;
                    if (specifics[2].equalsIgnoreCase("TRUE")) {
                        b1 = true;
                    }
                    if (specifics[2].equalsIgnoreCase("FALSE")) {
                        b1 = false;
                    }
                    float cf = Float.parseFloat(specifics[3]);
                    float p = (c1.getStrength() + c2.getStrength()) * cf;
                    gb.insertAliance(b1, cf, p, c1, c2);
                }
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

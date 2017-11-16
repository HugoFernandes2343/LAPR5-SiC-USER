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
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
 */
public class FileRead {

    private GameBase gb;
    

    public void FileRead() throws CloneNotSupportedException {
        this.gb = new GameBase();
        gb.GameBase();
        lerMatrix();
        lerMap();
    }

    public GameBase getGamebase(){
    return gb;
    }
    private void lerMatrix() {
        String fileName = "locais_S.txt";

        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            if ((line = bufferedReader.readLine()).equalsIgnoreCase("LOCAIS")) {
                int i = 0;
                while (!(line = bufferedReader.readLine()).equalsIgnoreCase("CAMINHOS")) {
                  //System.out.println(line);
                    String[] specifics = line.split(",");
                    gb.insertLocale(specifics[0], Integer.parseInt(specifics[1]));
                    System.out.println(i);
                    i++;
                }
                System.out.println(line);
                i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    String[] specifics = line.split(",");
                    Locale l1 = gb.searchForLocal(specifics[0]);
                    Locale l2 = gb.searchForLocal(specifics[1]);
                    gb.insertRoads(Integer.parseInt(specifics[2]), l1, l2);
                    i++;
                    
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
        String fileName2 = "pers_S2.txt";

        String line;

        try {
            FileReader fileReader2
                    = new FileReader(fileName2);

            BufferedReader bufferedReader2
                    = new BufferedReader(fileReader2);

            if ((line = bufferedReader2.readLine()).equalsIgnoreCase("PERSONAGENS")) {
                System.out.println(line);
                while (!(line = bufferedReader2.readLine()).equalsIgnoreCase("ALIANCAS")) {
                    System.out.println(line);
                    String[] specifics = line.split(",");
                    int i = specifics.length;
                    System.out.println(i);
                    Locale l1 = gb.searchForLocal(specifics[2]);
                    gb.insertCharacter(specifics[0], Integer.parseInt(specifics[1]), l1);
                    
                }
                System.out.println(line);
                while ((line = bufferedReader2.readLine()) != null) {
                     System.out.println(line);
                    String[] specifics = line.split(",");
                    Character c1 = gb.searchForCharacter(specifics[0]);
                    Character c2 = gb.searchForCharacter(specifics[1]);
                    boolean b1 = true;
                    if (specifics[2].equalsIgnoreCase("FALSE")) {
                        b1 = false;
                    }
                    float cf = Float.parseFloat(specifics[3]);
                    float p = (c1.getStrength() + c2.getStrength()) * cf;
                    gb.insertAliance(b1, cf, p, c1, c2);
                }
            }

            bufferedReader2.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName2 + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName2 + "'");

        }
    }
}

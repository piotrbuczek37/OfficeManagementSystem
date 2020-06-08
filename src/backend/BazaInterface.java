/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author Piotr Buczek
 */
public interface BazaInterface {
    public void zapis(Object o);
    public void modyfikuj(Object o);
    public ArrayList odczyt();
    public void usun(Object o);
}

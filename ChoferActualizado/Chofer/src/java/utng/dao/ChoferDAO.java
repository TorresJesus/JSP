/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Chofer;

/**
 *
 * @author Erick
 */
public interface ChoferDAO {
    void agregarChofer(Chofer chofer);
    void borrarChofer(int idChofer);
    void cambiarChofer(Chofer chofer);
    List<Chofer> desplegarChofer();
    Chofer elegirChofer(int idChofer);
 }

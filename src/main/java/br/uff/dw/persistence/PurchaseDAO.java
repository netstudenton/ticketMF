/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.persistence;

import br.uff.dw.model.Event;
import br.uff.dw.model.Purchase;
import br.uff.dw.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabio
 */
public interface PurchaseDAO extends CrudRepository<Purchase,Long>{

    public List<Purchase> findByEvent(Event e);
    public List<Purchase> findByUser(User e);
    public Purchase findByUserAndEvent(User e,Event ev);
}

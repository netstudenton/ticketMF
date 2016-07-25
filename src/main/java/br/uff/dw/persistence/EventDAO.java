/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.persistence;

import br.uff.dw.model.Event;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabio
 */
public interface EventDAO extends CrudRepository<Event, Long> {
   // 
    public List<Event> findByTitleContainingOrDescriptionContaining(String word,String word2);

    public List<Event> findByPlaceAndTypeOrderByPriceAsc(String local, String type);

    public List<Event> findByPlaceAndTypeOrderByPriceDesc(String local, String type);

    public List<Event> findByPlaceAndTypeOrderByDateAsc(String local, String type);

    public List<Event> findByPlaceAndTypeOrderByAmountAsc(String local, String type);
}

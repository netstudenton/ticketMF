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
    public List<Event> findByTitleContainingAndLocalAndType(String word, String local, String type);

    public List<Event> findByDescriptionContainingAndLocalAndType(String word, String local, String type);

    public List<Event> findByLocalAndTypeOrderByPriceAsc(String local, String type);

    public List<Event> findByLocalAndTypeOrderByPriceDesc(String local, String type);

    public List<Event> findByLocalAndTypeOrderByDateAsc(String local, String type);

    public List<Event> findByLocalAndTypeOrderByAmountAsc(String local, String type);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.control;

import br.uff.dw.persistence.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fabio
 */
@Controller
public class SelectEventMenuController {
    //jcombobox de ordenação por ranking , pelo mais novos , por preço
    //metodo de exibir uma lista paginada dado um tipo , cinema,show ..
    //metodo exibe lista do resultado de uma busca por titulo ou descricao
    @Autowired
    private EventDAO eventDAO;
    
    
}

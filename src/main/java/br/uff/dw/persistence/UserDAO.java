/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.persistence;

import br.uff.dw.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author fabio
 */
public interface UserDAO extends CrudRepository<User,Long>{
    
    public User findByEmail(String email);
    public User findByCpf(String cpf);
}

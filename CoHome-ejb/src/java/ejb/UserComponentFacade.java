/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marco
 */
@Stateless
public class UserComponentFacade extends AbstractFacade<UserComponent> implements UserComponentFacadeLocal {
    @PersistenceContext(unitName = "CoHome-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserComponentFacade() {
        super(UserComponent.class);
    }
    
}

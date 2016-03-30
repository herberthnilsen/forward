package br.com.forward.interfaces.business;

import java.util.List;

import javax.ejb.Local;

import br.com.forward.common.ColaboradorVO;
import br.com.forward.exception.EntityManagerException;

/**
 * Classe responsável por ...
 *
 * @since 14 de mar de 2016 21:56:52
 * @version x.x
 */
@Local
public interface ColaboradorBusinessLocal {

	public List<ColaboradorVO> listarColaboradores() throws EntityManagerException;

}

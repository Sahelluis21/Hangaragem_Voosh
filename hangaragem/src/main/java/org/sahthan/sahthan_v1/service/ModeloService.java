package org.sahthan.sahthan_v1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.sahthan.sahthan_v1.dao.ModeloDAO;
import org.sahthan.sahthan_v1.model.Modelo;

import java.io.Serializable;
import java.util.List;

@RequestScoped
public class ModeloService implements Serializable {

    private final ModeloDAO modeloDAO = new ModeloDAO();

    public void salvarModelo(Modelo modelo) throws Exception{
        try{
            modeloDAO.inserirModelo(modelo);

        }catch (Exception e){

            throw new Exception("Falha ao salvar o modelo Service");
        }
    }

    public void deletarModelo(Modelo modelo) throws Exception{
        try{
            modeloDAO.excluirModelo(modelo.getId());

        }catch (Exception e){

            throw new Exception("Falha ao deletar o modelo Service");
        }

    }

    public List<Modelo> listarModelos(){
        return modeloDAO.listarModelo();
    }

    public void editarModelo(Modelo modelo){
        modeloDAO.atualizarModelo(modelo);
    }
}


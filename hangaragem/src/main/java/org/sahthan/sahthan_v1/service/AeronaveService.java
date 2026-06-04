package org.sahthan.sahthan_v1.service;

import jakarta.enterprise.context.RequestScoped;
import org.sahthan.sahthan_v1.dao.AeronaveDAO;
import org.sahthan.sahthan_v1.model.Aeronave;

import java.io.Serializable;
import java.util.List;

@RequestScoped
public class AeronaveService implements Serializable {

    private final AeronaveDAO aeronaveDAO = new AeronaveDAO();

    public void salvarAeronave(Aeronave aeronave) throws Exception{
        try{
            aeronaveDAO.inserirAeronave(aeronave);

        }catch (Exception e){

            throw new Exception("Falha ao salvar o modelo Service");
        }
    }

    public void deletarAeronave(Aeronave aeronave) throws Exception{
        try{
            aeronaveDAO.excluirAeronave(aeronave.getId());

        }catch (Exception e){

            throw new Exception("Falha ao deletar o modelo Service");
        }

    }

    public List<Aeronave> listarAeronaves(){
        return aeronaveDAO.listarAeronave();
    }

    public void editarAeronave(Aeronave aeronave){
        aeronaveDAO.atualizarAeronave(aeronave);
    }
}


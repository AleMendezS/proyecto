package com.ProyectoWeb.service;


import com.ProyectoWeb.dao.ClienteDao;
import com.ProyectoWeb.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServicelmpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override

    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
      clienteDao.delete(cliente);
    }

    @Override
   @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
     return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    
    @Override
    public List<Cliente> findByCedula(int cedula) {
        
     return clienteDao.findByCedula(cedula);
    }
}


package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.UbicacionDao;
import com.ProyectoWeb.domain.Ubicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionDao ubicacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> getUbicacion() {
        return (List<Ubicacion>) ubicacionDao.findAll();
    }

    @Override
    @Transactional
    public void save(Ubicacion ubicacion) {
        ubicacionDao.save(ubicacion);
    }

    @Override
    @Transactional
    public void delete(Ubicacion ubicacion) {
        ubicacionDao.delete(ubicacion);
    }

    @Override

    public Ubicacion getUbicacion(Ubicacion ubicacion) {
        return ubicacionDao.findById(ubicacion.getIdUbi()).orElse(null);
    }
}

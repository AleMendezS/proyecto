package com.ProyectoWeb.service;


import com.ProyectoWeb.dao.EmpleadoDao;
import com.ProyectoWeb.domain.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServicelmpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> getEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override

    public Empleado getEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }

}

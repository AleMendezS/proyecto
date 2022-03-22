
package com.ProyectoWeb.service;


import com.ProyectoWeb.domain.Empleado;
import java.util.List;

public interface EmpleadoService {
    public List<Empleado> getEmpleados();
    
    public void save(Empleado empleado);
    
    public void delete(Empleado empleado);
    
    public Empleado getEmpleado (Empleado empleado);
}

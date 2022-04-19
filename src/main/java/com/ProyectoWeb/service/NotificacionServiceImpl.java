/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.NotificacionDao;
import com.ProyectoWeb.domain.Notificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionDao notificacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Notificacion> getNotificaciones() {
        return (List<Notificacion>) notificacionDao.findAll();
    }

    @Override
    @Transactional
    public void save(Notificacion notificacion) {
        notificacionDao.save(notificacion);
    }

    @Override
    @Transactional
    public void delete(Notificacion notificacion) {
        notificacionDao.delete(notificacion);
    }

    @Override

    public Notificacion getNotificacion(Notificacion notificacion) {
        return notificacionDao.findById(notificacion.getIdNoti()).orElse(null);
    }

}

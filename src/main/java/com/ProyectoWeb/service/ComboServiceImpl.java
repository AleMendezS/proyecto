package com.ProyectoWeb.service;

import com.ProyectoWeb.dao.ComboDao;
import com.ProyectoWeb.domain.Combo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComboServiceImpl implements ComboService {

    @Autowired
    private ComboDao comboDao;

    @Override
    @Transactional(readOnly = true)
    public List<Combo> getCombos() {
        return (List<Combo>) comboDao.findAll();
    }

    @Override
    @Transactional
    public void save(Combo combo) {
        comboDao.save(combo);
    }

    @Override
    @Transactional
    public void delete(Combo combo) {
        comboDao.delete(combo);
    }

    @Override

    public Combo getCombo(Combo combo) {
        return comboDao.findById(combo.getIdCombo()).orElse(null);
    }
}

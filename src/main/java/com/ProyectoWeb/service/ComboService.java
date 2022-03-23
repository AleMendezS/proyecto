package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Combo;
import java.util.List;

public interface ComboService {
     public List<Combo> getCombos();
    
    public void save(Combo combo);
    
    public void delete(Combo combo);
    
    public Combo getCombo (Combo combo);
}

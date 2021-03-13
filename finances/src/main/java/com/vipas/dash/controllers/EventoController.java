package com.vipas.dash.controllers;


import com.vipas.dash.models.Evento;
import com.vipas.dash.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;



    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.GET)
    public  String form(){
    return "evento/formEvento";
}

    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.POST)
    public  String form(Evento evento){
        er.save(evento);
        return "evento/formEvento";
    }


}

package com.vipas.dash.controllers;


import com.vipas.dash.models.Evento;
import com.vipas.dash.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv= new ModelAndView("home");
        Iterable<Evento> eventos=er.findAll();
        mv.addObject("eventos",eventos);
        return mv;
    }



    @RequestMapping("/{codigo}")//Retorna o coigo a partir da URL quando clicado
    public ModelAndView detalhesEvento(@PathVariable("codigo")/*Define que o parametro sera mapeado como variavel de retorna na URL*/ long codigo){

        ModelAndView modelAndView= new ModelAndView("evento/detalhesEvento");
        Evento evento= er.findByCodigo(codigo);
        modelAndView.addObject("evento",evento);

        return modelAndView;




    }



}

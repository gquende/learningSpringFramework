package com.vipas.dash.controllers;


import com.vipas.dash.models.Convidado;
import com.vipas.dash.models.Evento;
import com.vipas.dash.repository.ConvidadoRepository;
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

    @Autowired
    private ConvidadoRepository cr;



    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.GET)
    public  String form(){
    return "evento/formEvento";
}

    @RequestMapping(value = "/cadastrarEvento",method = RequestMethod.POST)
    public  String form(Evento evento){
        er.save(evento);
        return "redirect: /cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv= new ModelAndView("home");
        Iterable<Evento> eventos=er.findAll();
        mv.addObject("eventos",eventos);
        return mv;
    }



    @RequestMapping(value="/{codigo}",method = RequestMethod.GET)//Retorna o coigo a partir da URL quando clicado
    public ModelAndView detalhesEvento(@PathVariable("codigo")/*Define que o parametro sera mapeado como variavel de retorna na URL*/ long codigo){

        ModelAndView modelAndView= new ModelAndView("evento/detalhesEvento");
        Evento evento= er.findByCodigo(codigo);
        modelAndView.addObject("evento",evento);
        return modelAndView;
    }
    @RequestMapping(value="/{codigo}", method = RequestMethod.POST)//Retorna o coigo a partir da URL quando clicado
    public String detalhesEventoPost(@PathVariable("codigo")long codigo, Convidado convidado){
        cr.save(convidado);
        return "redirect:/{codigo}";

    }



}

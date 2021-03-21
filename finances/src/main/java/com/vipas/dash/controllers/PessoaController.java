package com.vipas.dash.controllers;


import com.vipas.dash.models.Pessoa;
import com.vipas.dash.repository.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController {
   private PessoaRepository pessoaRepository;

 @RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.GET)
public String form(){
    return "pessoa/formPessoa";
}


@RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
public String form(Pessoa pessoa){
     pessoaRepository.save(pessoa);
     return "pessoa/formPessoa";
}



@RequestMapping("/pessoas")
    public ModelAndView listarPessoas(){
     /*Define em qual view sera apresentado os dados*/
     ModelAndView modelAndViewPessoa= new ModelAndView("home");
     Iterable<Pessoa> pessoas= pessoaRepository.findAll();
     modelAndViewPessoa.addObject(pessoas);
     return modelAndViewPessoa;
}





}

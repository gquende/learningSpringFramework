package com.vipas.dash.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PessoaController {


 @RequestMapping("/cadastrarPessoa")
public String form(){
    return "pessoa/formPessoa";
}


}

package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Scope("request")
@Controller

public class ContatoServico {
    
    @Autowired
     SolicitacaoContatoDAO conexaoBanco;
   

    @RequestMapping("/processar-form-contato")
    public String recebeDadosParaContato(@RequestParam Map<String, String> todosParametros) {
        System.out.println("Entrei no metodo: /processar-form-contato");
        System.out.println(todosParametros);

        SolicitacaoContato novaSolicitacao = new SolicitacaoContato();
        novaSolicitacao.nome = todosParametros.get("nome");
        novaSolicitacao.email = todosParametros.get("email");
        novaSolicitacao.duvida = todosParametros.get("duvida");

        
        System.out.println("Nova solicitação recebida: " + novaSolicitacao);

        conexaoBanco.save(novaSolicitacao);
        return "redirect:/Principal.xhtml";

    }

    @RequestMapping("/todas-solicitacoes")
    @ResponseBody
    public String geraTelaTodasContatos() {

        String html = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>TODO supply a title</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        \n"
                + "        \n"
                + "        <table>\n"
                + "            \n"
                + "            <tr>\n"
                + "                <td> Nome</td>\n"
                + "                <td> Email</td>\n"
                + "                <td>Duvida</td>\n"
                + "            </tr>";

        for (SolicitacaoContato sol : conexaoBanco.findAll()) {

            String linhaTabela = "<tr>";
            //nome
            linhaTabela += "<td>";

            linhaTabela += sol.nome;

            linhaTabela += "</td>";
            //EMail
            linhaTabela += "<td>";

            linhaTabela += sol.email;

            linhaTabela += "</td>";
            //duvida
            linhaTabela += "<td>";

            linhaTabela += sol.duvida;

            linhaTabela += "</td>";
            linhaTabela += "</tr>";
            html += linhaTabela;
        }

        html = html + "</table>\n <td><a href=\"Contato.xhtml\">Voltar</a>"
                + "        \n"
                + "        \n"
                + "    </body>\n"
                + "</html>\n"
                + " ";

        return html;
    }
    @RequestMapping(value = "/contato/todos-ws")
    @ResponseBody
    public Iterable<SolicitacaoContato> todosContatos() {
        return this.conexaoBanco.findAll();
    }


}

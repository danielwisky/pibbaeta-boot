package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pedido-oracao")
@AllArgsConstructor
public class PedidoOracaoController {

  private PedidoOracaoService pedidoOracaoService;

  @RequestMapping(method = RequestMethod.GET)
  public String lista(final Model model) {
    model.addAttribute("menu", "pedidoOracao");
    return "pedidoOracao/lista";
  }

  @RequestMapping(value = "/pesquisa")
  public @ResponseBody
  List<PedidoOracao> pesquisa() {
    return pedidoOracaoService.lista();
  }
}

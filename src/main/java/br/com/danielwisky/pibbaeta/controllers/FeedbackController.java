package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.Feedback;
import br.com.danielwisky.pibbaeta.models.PedidoOracao;
import br.com.danielwisky.pibbaeta.services.FeedbackService;
import br.com.danielwisky.pibbaeta.services.PedidoOracaoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/feedback")
@AllArgsConstructor
public class FeedbackController {

  private FeedbackService feedbackService;

  @RequestMapping(method = RequestMethod.GET)
  public String lista(final Model model) {
    model.addAttribute("menu", "feedback");
    return "feedback/lista";
  }

  @RequestMapping(value = "/pesquisa")
  public @ResponseBody
  List<Feedback> pesquisa() {
    return feedbackService.lista();
  }
}

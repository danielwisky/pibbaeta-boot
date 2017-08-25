package br.com.danielwisky.pibbaeta.controllers;

import br.com.danielwisky.pibbaeta.models.FirebaseConfig;
import br.com.danielwisky.pibbaeta.services.FirebaseConfigService;
import java.io.IOException;
import java.util.Locale;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/firebase")
@AllArgsConstructor
public class FirebaseConfigController {

  private MessageSource messageSource;
  private FirebaseConfigService firebaseConfigService;

  @RequestMapping(method = RequestMethod.GET)
  public String config(final FirebaseConfig firebaseConfig, final boolean containErrors,
      final Model model) {

    final FirebaseConfig config =
        containErrors ? firebaseConfig : firebaseConfigService.getConfig();

    model.addAttribute("menu", "firebase");
    model.addAttribute("firebaseConfig", config);

    return "firebase/config";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String salva(@Valid final FirebaseConfig firebaseConfig, final BindingResult bindingResult,
      final RedirectAttributes redirectAttributes, final Locale locale, final Model model) {

    if (bindingResult.hasErrors()) {
      return config(firebaseConfig, true, model);
    }

    firebaseConfigService.salva(firebaseConfig);
    if (firebaseConfigService.tokenValido()) {
      redirectAttributes.addFlashAttribute("sucesso",
          messageSource.getMessage("firebase.sucesso", null, locale));
    } else {
      redirectAttributes.addFlashAttribute("falha",
          messageSource.getMessage("firebase.falha", null, locale));
    }

    return "redirect:/firebase";
  }
}
package fiap.com.br.GlobalSolution.controller;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("/index")
	public String retornaPagina() {
		return "index";
	}
	
	@GetMapping("/setLocale")
	public String setLocale(@RequestParam("lang") String lang, HttpServletRequest request) {
	    Locale locale = new Locale(lang);
	    LocaleContextHolder.setLocale(locale);
	    // Redirecionar de volta para a página anterior
	    String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}


}
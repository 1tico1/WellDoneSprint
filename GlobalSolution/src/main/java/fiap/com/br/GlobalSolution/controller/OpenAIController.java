package fiap.com.br.GlobalSolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ai.openai.OpenAiChatClient;

@Controller
public class OpenAIController {

    @Autowired
    private OpenAiChatClient chatClient; // Injeção do cliente da OpenAI

    // Exibir o formulário para interagir com o ChatGPT
    @GetMapping("/form_chat_gpt")
    public String retornaFormChatGPT() {
        return "form_chat_gpt";
    }

    // Endpoint para processar a pergunta e obter a resposta e retornar na index
    @PostMapping("/enviar_chat_gpt")
    public String enviarPerguntaChatGPT(@RequestParam(name = "pergunta") String pergunta, Model model) {
        try {
            // Envia a pergunta ao OpenAI e obtém a resposta
            String resposta = chatClient.call(pergunta);
            model.addAttribute("resposta", resposta);
        } catch (Exception e) {
            model.addAttribute("resposta", "Ocorreu um erro ao processar sua pergunta.");
        }

        return "index"; // Retornar para a página index
    }
}

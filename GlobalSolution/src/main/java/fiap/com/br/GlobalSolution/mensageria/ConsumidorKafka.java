package fiap.com.br.GlobalSolution.mensageria;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorKafka {

    @KafkaListener(topics = ProdutorKafka.TOPICO, groupId = "well-done-group")
    public void lerMensagem(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}

package fiap.com.br.GlobalSolution.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProdutorKafka {

    public static final String TOPICO = "WellDone_Topico"; // Nome do tópico

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send(TOPICO, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}

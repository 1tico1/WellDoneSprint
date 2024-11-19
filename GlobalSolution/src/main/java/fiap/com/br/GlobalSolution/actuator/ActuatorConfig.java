package fiap.com.br.GlobalSolution.actuator;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ActuatorConfig {

    // Configuração do HttpExchangeRepository (opcional)
    @Bean
    public HttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository(); // Armazena dados em memória
    }

    // Contribuição de informações personalizadas para o endpoint /actuator/info
    @Bean
    public InfoContributor customInfo() {
        return builder -> builder
            .withDetail("Nome", "WellDoneEcoEnergy")
            .withDetail("Objetivo", "Promover o uso sustentável da energia renovável, oferecendo visibilidade sobre a geração e consumo de energia, enquanto se incentiva a economia por meio da gamificação.")
            .withDetail("Descrição", "O EcoEnergy é uma plataforma inovadora para monitoramento e gestão de energia renovável, voltada para consumidores e gestores de energia.")
            .withDetail("Público-Alvo", "Residências, empresas e administradores que desejam gerenciar e visualizar de forma eficiente o consumo de energia renovável.")
            .withDetail("Recursos Principais", Arrays.asList(
                    "Monitoramento em Tempo Real: Acompanhe a geração e consumo de energia de fontes renováveis como solar e eólica.",
                    "Autenticação Segura: Gerenciamento de usuários com diferentes níveis de acesso (administrador e usuário).",
                    "Gestão de Energia: Visualize a produção de energia, gerencie o consumo e consulte relatórios históricos.",
                    "Distribuição de Brindes: Incentive os usuários com brindes de acordo com metas de economia de energia.",
                    "Internacionalização: Suporte a múltiplos idiomas para facilitar o uso por diferentes perfis de usuários.",
                    "Relatórios Personalizados: Gere relatórios detalhados sobre o consumo e a geração de energia ao longo do tempo."
            ))
            .withDetail("Tecnologias Utilizadas", Arrays.asList(
                    "Spring Boot",
                    "Thymeleaf",
                    "React Native",
                    "Firebase",
                    "Kafka",
                    "MySQL",
                    "Actuator para monitoramento",
                    "Internacionalização com suporte a múltiplos idiomas"
            ))
            .withDetail("Funções dos Usuários", Arrays.asList(
                    "Usuário Admin: Gerencia , Edita e Atualiza Relatorios ou Usuarios ou Consumos.",
                    "Usuário Comum: Visualiza o consumo e geração de energia."
            ))
            .withDetail("Acessibilidade", "A plataforma oferece um design intuitivo com foco na simplicidade, tornando o processo de monitoramento de energia acessível para todos.")
            .withDetail("Contato", "Para dúvidas e suporte, envie um e-mail para suporte@WellDoneEcoEnergy.com")
            .withDetail("Licença", "MIT License");
    }
}

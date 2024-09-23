package com.mensageria.aula08_mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *  Serviço responsável por enviar mensagens ao Kafka em lote
 *  Está sendo utilizado o KafkaTemplate, que são agrupadas em lotes
 *  de acordo com as configurações definidas.
 */
@Service
public class KafkaBatchProducer {

    //KafkaTemplate injeta a capacidade de produzir mensagem para o Kafka
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //Nome do tópico onde as mensagens serão enviadas
    private final String TOPIC = "batch-topico";

    /**
     * Envia uma série de mensagens para o Kafka de forma agrupada
     * Este metodo envia 20 mensagens de batch-size ao tópico criado
     * Seguirá as configurações de batch-size e linger.ms. E serão enviadas em lote
     */
    public void sendMessagesInBatch() {
        for (int i = 0; i < 20; i++) {
            String message = String.format("Messagem %d", i);
            kafkaTemplate.send(TOPIC, message);
            System.out.println("Enviado: " + message);
        }
    }


}

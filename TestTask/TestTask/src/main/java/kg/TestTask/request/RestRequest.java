package kg.TestTask.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.TestTask.dao.CurrencyObject;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

public class RestRequest {
    Base64.Encoder encode=Base64.getEncoder();
    ObjectMapper mapper = new ObjectMapper();
    public String requestSend(String mark) throws JsonProcessingException {
       Mono< String > responseWeb;
        responseWeb = WebClient.builder()
                .baseUrl("https://api.giphy.com/v1/gifs/search?q="+mark+"&api_key=8wltkgZPeGuZAjHGS4zxymp0HbYnj6DX&limit=1")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);
        return  encode.encode(responseWeb.block().getBytes()).toString();
    }
    public CurrencyObject requestExchange(String time) throws JsonProcessingException {
        Mono< String > responseWeb;
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        String response,today;
        responseWeb = WebClient.builder()
                .baseUrl("https://openexchangerates.org/api/latest.json?app_id=2456efde79284db6a2dce00e871bde2f&base=USD" +
                        "&callback=historical/"+time+".json")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class);
        response=responseWeb.block().substring(27,responseWeb.block().length()-1);
        System.out.println("response web client response"+response);
        CurrencyObject currencyObject=mapper.readValue(response,CurrencyObject.class);
        System.out.println("response web client Rates"+currencyObject.getRates().getRUB());
        return currencyObject;
    }

}

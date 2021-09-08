package kg.TestTask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import kg.TestTask.dao.CurrencyObject;
import kg.TestTask.dao.ResponseObject;
import kg.TestTask.request.RestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class TaskService {
      public ResponseObject sendRequest() throws JsonProcessingException {
        String currency="RUB",image="",today,yesterday;
          CurrencyObject currencyObject;
        Double lastCourse,todayCourse;
          Calendar cal = Calendar.getInstance();
          SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
          today=formatter.format(cal.getTime());
          cal.add(Calendar.DATE, -1);
          yesterday=formatter.format(cal.getTime());
           currencyObject= new RestRequest().requestExchange(today);
          todayCourse=Double.parseDouble(currencyObject.getRates().getRUB());
           currencyObject= new RestRequest().requestExchange(yesterday);
          lastCourse=Double.parseDouble(currencyObject.getRates().getRUB());
          image= (lastCourse<todayCourse)? "rich":"broke";
        return new ResponseObject(currency,todayCourse,new RestRequest().requestSend(image),today);
    }
}
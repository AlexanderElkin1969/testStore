package pro.sky.java.course2.teststore.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LittleProductExeption extends RuntimeException {
    public LittleProductExeption(String message) {
        super(message);
    }
}

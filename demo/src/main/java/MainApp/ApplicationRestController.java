package MainApp;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import Communication.*;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.IOException;
import java.util.List;


import static MainApp.ChessApplication.board;
@RestController
public class ApplicationRestController {
    @GetMapping("/move")
    public String getMoves(@RequestParam(value = "position") String position){
        Gson gson = new Gson();
        return gson.toJson(board.getBoard().get(position).getPiece().allPossibleMoves(position, board.getBoard()));
    }



}

package MainApp;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Communication.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import Model.ChessBoard;

@SpringBootApplication
@Controller
public class ChessApplication {
    final static ChessBoard board = new ChessBoard();
    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
    }
    @GetMapping("/")
    public String index(@RequestParam(value = "name", defaultValue = "Foreigner") String name, Model model) {
        return "forward:/hello";
    }
    @GetMapping("/hello")
    public String player(@RequestParam(value = "name", defaultValue = "Player1") String name, Model model) {
        model.addAttribute("board", board);
        return "hello";
    }
    @PostMapping("/movePiece")
    public String movePiece(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end)  {
        board.movePiece(start, end);
        return "redirect:/hello";
    }


}


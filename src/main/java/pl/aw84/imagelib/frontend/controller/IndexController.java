package pl.aw84.imagelib.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import pl.aw84.imagelib.frontend.dto.ImagePaginatedResponse;

@Controller
@RefreshScope
public class IndexController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Value("${imageSourceHost}")
    String imageSourceHost;

    @GetMapping(value = "/index")
    public String getHomepage(Model model, @RequestParam(defaultValue = "0") Integer p) {

        ImagePaginatedResponse pir = webClientBuilder.build().get()
                .uri("http://api/image?p={p}", p)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ImagePaginatedResponse.class)
                .block();

        model.addAttribute("imageHost", imageSourceHost);
        model.addAttribute("images", pir.getContent());
        model.addAttribute("totalPages", pir.getTotalPages());
        model.addAttribute("currentPage", pir.getNumber());
        return "index-b";
    }
}

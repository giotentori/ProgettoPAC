package com.example.pacbackend.Ranking;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pacbackend.Users.User.User;
import com.example.pacbackend.Users.User.UserService;


@RestController
@RequestMapping("/ranking")
public class RankingController {
  private final RankingService rankingService;

  public RankingController(RankingService rankingService){
    this.rankingService = rankingService;
  }

  //Ritorna la lista degli utenti secondo ranking
  @GetMapping("/getRanking")
  @ResponseBody
  public List<User> getRanking(){
    return rankingService.getRanking();
  }
  
}

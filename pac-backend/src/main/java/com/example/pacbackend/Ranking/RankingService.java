package com.example.pacbackend.Ranking;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pacbackend.Users.User.UserRepository;
import com.example.pacbackend.Users.User.User;

@Service
public class RankingService {

  private final UserRepository userRepository;

      public RankingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getRanking() {
        List<User> userList = userRepository.findAll();
        mergeSort(userList, 0, userList.size() - 1);
        return userList;
    }



        private void mergeSort(List<User> userList, int left, int right) {
        if (left < right) {
            // Trova il punto medio
            int middle = left + (right - left) / 2;

            // Esegui il merge sort per la parte sinistra e destra
            mergeSort(userList, left, middle);
            mergeSort(userList, middle + 1, right);

            // Unisci le parti ordinate
            merge(userList, left, middle, right);
        }
    }



    private void merge(List<User> userList, int left, int middle, int right) {
      int n1 = middle - left + 1;
      int n2 = right - middle;

      // Crea array temporanei
      User[] leftArray = new User[n1];
      User[] rightArray = new User[n2];

      // Copia i dati negli array temporanei
      for (int i = 0; i < n1; ++i) {
          leftArray[i] = userList.get(left + i);
      }
      for (int j = 0; j < n2; ++j) {
          rightArray[j] = userList.get(middle + 1 + j);
      }

      // Fase di merge
      int i = 0, j = 0;
      int k = left;
      while (i < n1 && j < n2) {
          if (leftArray[i].getRating() >= rightArray[j].getRating()) {
              userList.set(k, leftArray[i]);
              i++;
          } else {
              userList.set(k, rightArray[j]);
              j++;
          }
          k++;
      }

      // Copia gli elementi rimanenti di leftArray, se ce ne sono
      while (i < n1) {
          userList.set(k, leftArray[i]);
          i++;
          k++;
      }

      // Copia gli elementi rimanenti di rightArray, se ce ne sono
      while (j < n2) {
          userList.set(k, rightArray[j]);
          j++;
          k++;
      }
  }
}
  


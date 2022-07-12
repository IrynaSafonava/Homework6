package by.it_academy.onliner.navigation;

import by.it_academy.onliner.page_object.HomePage;

public class OnlinerNavigation {

   public static void navigateToOnlinerHomePage(){
       new HomePage().navigate("https://www.onliner.by");
   }

}

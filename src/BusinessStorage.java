public class BusinessStorage   {

     String[] businesses ={"IT Company","Restaurant Business","Clothing Store","Constructor Company","Transport Company","Pharmacy Business", "Fitness Center","Agriculture Business","Online Shop"};

    void addBusiness(String newBusiness){
       for (int i = 0; i < businesses.length; i++){
           if (businesses[i] == null){
               businesses[i] = newBusiness;
               break;
           }
       }
    }

    void showAllBusiness(){
        for (int i = 0; i < businesses.length; i++){
            if(businesses[i] != null){
                System.out.println(businesses[i]);
            }
        }
    }
void findBusiness(int number){
        switch (number){
            case 0:
                System.out.println(businesses[0]);
        break;
            case 1:
                System.out.println(businesses[1]);
                break;
            case 2:
                System.out.println(businesses[2]);
                break;
            case 3:
                System.out.println(businesses[3]);
                break;
                case 4:
                    System.out.println(businesses[4]);
            case 5:
                System.out.println(businesses[5]);
            break;
                case 6:
                    System.out.println(businesses[6]);
                    break;
            case 7:
                System.out.println(businesses[7]);
                break;
            case 8:
                System.out.println(businesses[8]);
              break;
            case 9:
                System.out.println(businesses[9]);
                break;
            default:
                System.out.println("Business not found");
        }
}

void removeBusiness(int removeIndex ){
        if(removeIndex >= 0 && removeIndex < businesses.length){
            businesses[removeIndex] = null;
            System.out.println("Bussiness removed");
        } else{
            System.out.println("Wrong index");
        }
}
  
}

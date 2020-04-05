package com.email.shipment.repository;

import com.email.shipment.model.person.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person,Long> {
}
 class HumanReadableTime {
     public static void main(String[] args) {
         System.out.println(makeReadable(142630));
     }
     public static String makeReadable(int seconds) {
         int h = seconds/3600;
         System.out.println(h);
         int m = (seconds- h*3600)/60;
         System.out.println(m);
         int s = seconds - h * 3600 - m * 60;
         System.out.println(s);
         return format(h) + ":" + format(m) + ":" + format(s);
     }
     public static String format(int x){
        return x >= 10 ? String.valueOf(x) : "0" + x;
     }
}
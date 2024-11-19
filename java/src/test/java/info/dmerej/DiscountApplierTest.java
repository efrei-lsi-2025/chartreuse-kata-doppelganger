package info.dmerej;

import info.dmerej.stubs.NotifierStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    //GIVEN
    User user = new User("user","user@gmail.com");
    User user1 = new User("user","user1@gmail.com");

    List<User> users = Arrays.asList(user1,user);
    NotifierStub notifier = new NotifierStub();
    DiscountApplier discountApplier = new DiscountApplier(notifier);

    //WHEN
    discountApplier.applyV1(50, users);

    //THEN
    Assertions.assertEquals(2, notifier.getMessagesCount());
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    //GIVEN
    User user1 = new User("user1","user1@gmail.com");
    User user2 = new User("user1","user2@gmail.com");

    List<User> users = Arrays.asList(user1,user2);
    NotifierStub notifier = new NotifierStub();
    DiscountApplier discountApplier = new DiscountApplier(notifier);

    //WHEN
    discountApplier.applyV2(50, users);

    //THEN
    Assertions.assertEquals(1, notifier.getMessagesCount(user1));
    Assertions.assertEquals(1, notifier.getMessagesCount(user2));
  }

}

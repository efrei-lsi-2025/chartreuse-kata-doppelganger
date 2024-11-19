package info.dmerej.stubs;

import info.dmerej.Notifier;
import info.dmerej.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierStub implements Notifier{
    private final Map<User, Integer> messages = new HashMap<>();

    @Override
    public void notify(User user, String message) {
        messages.put(user, messages.getOrDefault(user,0) + 1);
    }

    public int getMessagesCount(User user) {
        return this.messages.getOrDefault(user,0);
    }

    public int getMessagesCount() {
        Collection<Integer> values = this.messages.values();
        int sum = 0;
        for(Integer value : values){
            sum+=value;
        }
        return sum;
    }

}

package assignment;
import java.util.*;

public class WaitingList {
   private List<User> vipWaitingList;
   private List<User> memberWaitingList;
   private List<User> normalWaitingList;

    public WaitingList() {
    this.vipWaitingList = new ArrayList<>();
    this.memberWaitingList = new ArrayList<>();
    this.normalWaitingList = new ArrayList<>();
    }

public void addWaiting(User user) {
    switch(user.getMemberType()) {
        case "VIP":
            vipWaitingList.add(user);
            break;
        case "NORMAL":
            memberWaitingList.add(user);
            break;
        case "NON_MEMBER":
            normalWaitingList.add(user);
            break;
    }
}

public String getWaiting(User user) {
    switch(user.getMemberType()) {
        case "VIP":
            if (vipWaitingList.isEmpty()) {
                return "No user currently in vip waiting list.";
            } else {
                String tobereturn ="VIP Waiting List:\n";

                for(int i=0; i<vipWaitingList.size();i++){
                    tobereturn+= (i+1)+" . "+vipWaitingList.get(i).getName().toString()+"\n";
                }
                return tobereturn;
            }
        case "NORMAL":
            if (memberWaitingList.isEmpty()) {
                return "No user currently in member waiting list.";
            } else {
                String tobereturn ="Member Waiting List:\n";

                for(int i=0; i<memberWaitingList.size();i++){
                    tobereturn+= (i+1)+" . "+memberWaitingList.get(i).getName().toString()+"\n";
                }
                return tobereturn;
            }
        case "NON_MEMBER":
            if (normalWaitingList.isEmpty()) {
                return "No user currently in non-member waiting list.";
            } else {
                String tobereturn ="Non-member Waiting List:\n";

                for(int i=0; i<normalWaitingList.size();i++){
                    tobereturn+= (i+1)+" . "+normalWaitingList.get(i).getName().toString()+"\n";
                }
                return tobereturn;
            }        
        default:
            return null;
    }
}

    public void removeWaiting(User user) {
        switch (user.getMemberType()) {
            case "VIP":
                vipWaitingList.remove(user);
                break;
            case "NORMAL":
                memberWaitingList.remove(user);
                break;
            case "NON_MEMBER":
                memberWaitingList.remove(user);
                break;
        }
    }
}


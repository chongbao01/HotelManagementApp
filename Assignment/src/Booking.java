public class Booking {
    private User user;
    
    public Booking(User user) {
        this.user = user;
    }

    public void setBooking(int numRooms, Room room, WaitingList waitinglist){
        int maxRooms;
        String memberType = user.getMemberType();

        switch(memberType) {
            case "VIP":
                maxRooms = 3;
                if (numRooms > maxRooms) {
                    System.out.println("Error: User is trying to book more than the allowed number of rooms.");
                    return;
                }   
                if (room.checkRoom("vip")) {
                    room.vip -= numRooms;
                    if (room.vip < 0){
                        if(room.checkRoom("deluxe")){
                            room.deluxe -= Math.abs(room.vip);
                            if(room.deluxe < 0){
                                if(room.checkRoom("standard")){
                                    room.standard -= Math.abs(room.deluxe);
                                    if (room.standard < 0){
                                        for(int i = room.standard;i < 0; i++){
                                            waitinglist.addWaiting(user); 
                                        }  
                                        room.standard = 0;
                                    }   
                                }
                                room.deluxe = 0;
                            }
                        }
                        else if(room.checkRoom("standard")){
                            room.standard -= Math.abs(room.vip);
                            if (room.standard < 0){
                                for(int i = room.standard;i < 0; i++){
                                    waitinglist.addWaiting(user); 
                                }  
                                room.standard = 0;
                            }   
                        }
                        else{
                            for(int i = room.vip;i < 0; i++){
                                waitinglist.addWaiting(user); 
                            }  
                        }
                        room.vip = 0;
                    }
                }   
                else if (room.checkRoom("deluxe")) {
                    room.deluxe -= numRooms;
                    if(room.deluxe < 0){
                        if(room.checkRoom("standard")){
                            room.standard -= Math.abs(room.deluxe);
                            if (room.standard < 0){
                                for(int i = room.standard;i < 0; i++){
                                    waitinglist.addWaiting(user); 
                                }  
                                room.standard = 0;
                            }   
                        }
                        else{
                            for(int i = room.deluxe;i < 0; i++){
                                waitinglist.addWaiting(user); 
                            }  
                        }
                        room.deluxe = 0;
                    }
                }   
                else if (room.checkRoom("standard")) {
                    room.standard -= numRooms;
                    if (room.standard <0){
                        for(int i = room.standard;i < 0; i++){
                            waitinglist.addWaiting(user);
                        }
                        room.standard = 0;
                    }
                }   
                else {
                    for (int i = 0;i<numRooms;i++){
                        waitinglist.addWaiting(user);
                    }
                }
                break;
            case "NORMAL":
                maxRooms = 2;
                if (numRooms > maxRooms) {
                    System.out.println("Error: User is trying to book more than the allowed number of rooms.");
                    return;
                }   
                if (room.checkRoom("deluxe")) {
                    room.deluxe -= numRooms;
                    if (room.deluxe <0){
                        if(user.getRewardStatus() && room.checkRoom("vip")){
                            room.vip -= Math.abs(room.deluxe);
                            user.setRewardStatus(false);
                            if (room.vip < 0){
                                if(room.checkRoom("standard")){
                                    room.standard -= Math.abs(room.vip);
                                    if (room.standard <0){
                                        for(int i = room.standard;i < 0; i++){
                                            waitinglist.addWaiting(user);
                                        }
                                        room.standard = 0;
                                    }
                                }
                                room.vip = 0;
                            }
                        }
                        else if(room.checkRoom("standard")){
                            room.standard -= Math.abs(room.deluxe);
                            if (room.standard <0){
                                for(int i = room.standard;i < 0; i++){
                                    waitinglist.addWaiting(user);
                                }
                                room.standard = 0;
                            }
                        }
                        else{
                            for(int i = room.deluxe;i < 0; i++){
                                waitinglist.addWaiting(user);
                            }
                        }
                        room.deluxe = 0;
                    }
                }
                else if (user.getRewardStatus() && room.checkRoom("vip")){
                    room.vip -= numRooms;
                    user.setRewardStatus(false);
                    if (room.vip < 0){
                        if(room.checkRoom("standard")){
                            room.standard -= Math.abs(room.vip);
                            if (room.standard <0){
                                for(int i = room.standard;i < 0; i++){
                                    waitinglist.addWaiting(user);
                                }
                                room.standard = 0;
                            }
                        }
                        else{
                            for(int i = room.vip;i < 0; i++){
                                waitinglist.addWaiting(user);
                            } 
                        }
                        room.vip = 0;
                    }
                }
                else if(room.checkRoom("standard")){
                    room.standard -= Math.abs(room.deluxe);
                    if (room.standard <0){
                        for(int i = room.standard;i < 0; i++){
                            waitinglist.addWaiting(user);
                        }
                        room.standard = 0;
                    }
                    else{
                        for(int i = room.deluxe;i < 0; i++){
                            waitinglist.addWaiting(user);
                        }
                    }
                }
                else {
                    for (int i = 0;i<numRooms;i++){
                        waitinglist.addWaiting(user);
                    }
                }
                break;
            case "NON_MEMBER":
                maxRooms = 1;
                if (numRooms <= maxRooms) {
                    if (room.checkRoom("standard")) {
                        room.standard -= numRooms;
                        if (room.standard <0){
                            for(int i = room.standard;i < 0; i++){
                                waitinglist.addWaiting(user);
                            }
                            room.standard = 0;
                        }
                    } else {
                        for (int i = 0;i<numRooms;i++){
                            waitinglist.addWaiting(user);
                        }
                    }
                }   
                else{
                    System.out.println("Error: User is trying to book more than the allowed number of rooms.");
                    return;
                }
                break;
        }
    }
    public void cancelBooking(WaitingList waitinglist) {
        waitinglist.removeWaiting(user);
    }
}

package pojos;

public class BookingDatesPojo {
    // 1-) Tüm keyler için private variable'lar olusturuyoruz

    private String checkin;
    private String checkout;

    // 2-) Tüm parametreler ile parametreli, bir tane de parametresiz constructor olusturuyoruz

    public BookingDatesPojo(String checkin, String checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo(){
    }

    // 3-) Public getter ve setter methodlarini olusturuyoruz

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // 4-) toString() methodunu olusturuyoruz


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}

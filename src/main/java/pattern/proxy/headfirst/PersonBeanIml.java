package pattern.proxy.headfirst;

public class PersonBeanIml  implements  PersonBean{
    String name;
    String gender;
    String interest;
    int rating;
    int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interest;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount==0)return 0;
        return (rating/ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interest = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating = rating;
        ratingCount++;
    }
}

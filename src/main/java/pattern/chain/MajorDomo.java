package pattern.chain;

public class MajorDomo extends  Manager {
    public MajorDomo(String name) {
        super(name);
    }

    @Override
    void requestApplications(Request request) {
        if ("请假".equals(request.requestType)&&request.number<5){
            System.out.println(name+" "+ request.requestContent+ " 数量   "+ request.number+" 被批准");
        }else {
            if (superior!=null)
                superior.requestApplications(request);
        }
    }
}

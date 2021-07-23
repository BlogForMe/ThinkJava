package pattern.chain;

public class CommonManager extends  Manager {
    public CommonManager(String name) {
        super(name);
    }

    @Override
    void requestApplications(Request request) {
        if ("请假".equals(request.requestType)&&request.number<2){
            System.out.println(name+" "+ request.requestContent+ " 数量   "+ request.number+" 被批准");
        }else {
            if (superior!=null)
                superior.requestApplications(request);
        }
    }
}

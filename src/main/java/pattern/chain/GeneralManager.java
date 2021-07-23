package pattern.chain;

public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    void requestApplications(Request request) {
        if ("请假".equals(request.requestType) && request.number < 5) {
            System.out.println(name + " " + request.requestContent + " 数量   " + request.number + "  被批准");
        } else if ("加薪".equals(request.requestType) && request.number < 500) {
            System.out.println(name + " " + request.requestContent + " 数量   " + request.number + "  被批准");
        }else if ("加薪".equals(request.requestType) && request.number > 500) {
            System.out.println(name + " " + request.requestContent + " 数量   " + request.number + "  再说吧");
        }
    }
}

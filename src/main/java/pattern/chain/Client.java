package pattern.chain;

/**
 * 大话设计模式
 * chain of Responsibility Pattern
 */
public class Client {
    public static void main(String[] args) {
        CommonManager commonManager = new CommonManager("经理");
        MajorDomo majorDomo = new MajorDomo("总监");
        GeneralManager generalManager = new GeneralManager("总经理");

        commonManager.setSuperior(majorDomo);//设置上级
        majorDomo.setSuperior(generalManager);

        Request request = new Request();
        request.requestType = "请假";
        request.number = 4;
        request.requestContent = "去找小姐姐";
        commonManager.requestApplications(request);


        Request request1 = new Request();
        request1.requestType = "加薪";
        request1.number = 888;
        request1.requestContent = "给哥加薪";
        commonManager.requestApplications(request1);
    }

}
